package com.itest.service;

import com.alibaba.excel.EasyExcel;
import com.itest.excel.BaseExcelUtil;
import com.itest.pojo.ITestBaseExcel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 咏蛙
 * @date: 2022/7/30 10:00
 * @description: 用例保存到excel 中
 */
@Slf4j
@Service
public class BaseToExcelService {

    /**
     * 保存用例
     *
     * @param list 用例信息
     */
    public void save(List<ITestBaseExcel> list, String fileName) {

        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
        EasyExcel.write(fileName, ITestBaseExcel.class).sheet("sheet1").relativeHeadRowIndex(4).doWrite(list);
        var result = BaseExcelUtil.writerBaseExcel(fileName);

        log.info("使用hutool 写入文件：{}", result);
    }
}
