package com.itest.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itest.json.JsonToExcel;
import com.itest.service.BaseToExcelService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.ZipFile;

/**
 * @author: 咏蛙
 * @date: 2022/8/7 12:14
 * @description: xmind 转Excel 文件接口服务
 */
@Slf4j
@RestController
public class XMindToExcelController {

    @Resource
    JsonToExcel jsonToExcel;
    @Resource
    BaseToExcelService excelService;

    @SneakyThrows
    @PostMapping("/upload")
    public String httpUpload(@RequestParam("file") MultipartFile multipartFile, @RequestParam("filePath")String filePath){
        // 新建文件
        File file = FileUtil.file(filePath + multipartFile.getOriginalFilename());
        // 写入到文件
        FileUtil.writeBytes(multipartFile.getBytes(), file);
        // 修改文件类型, 将文件改为zip 格式
        File alterSuffixName = FileUtil.rename(file,FileUtil.getPrefix(file) + ".zip", true);

        ZipFile zipFile = new ZipFile(alterSuffixName);

        // 读取zip 中的指定文件
        var str = ZipUtil.get(zipFile, "content.json");

        // 读取JSON 文件
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(str);

        jsonToExcel.jsonLeaf(jsonNode.findValue("rootTopic"));

        excelService.save(jsonToExcel.getiTestBaseExcelList(),filePath + FileUtil.getPrefix(file) + ".xlsx");

        str.close();
        zipFile.close();

        String canonicalPath = FileUtil.getCanonicalPath(alterSuffixName);
        log.info("获取文件的绝对路径：{}", canonicalPath);

        var result = forceDelete (alterSuffixName);
        log.info("杀死进程：{}", result);
        FileUtil.del(canonicalPath);

        return "文件已解析完成，请查看保存文件的目录！";
    }

    public boolean forceDelete(File file) {
        boolean result = file.delete();
        int tryCount = 0;
        while (!result && tryCount++ < 10) {
            System.gc();    //回收资源
            result = file.delete();
        }
        return result;
    }


}
