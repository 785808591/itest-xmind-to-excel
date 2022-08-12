package com.itest.json;

import cn.hutool.core.bean.BeanUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.itest.pojo.ITestBaseExcel;
import com.itest.pojo.XMindJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: 咏蛙
 * @date: 2022/8/7 11:57
 * @description: 解析xmind JSON文件 转Excel
 */
@Slf4j
@Component
public class JsonToExcel {
    @Resource
    ITestBaseExcel baseExcel;
    @Resource
    XMindJson xmind;

    List<ITestBaseExcel> iTestBaseExcelList = new LinkedList<>();

    List<String> titleList = new LinkedList<>();

    public void jsonLeaf(JsonNode node) {
        if (node.isValueNode()) {
//            System.out.println(node.toString());
            return;
        }

        if (node.isObject()) {
            try {
                if (!node.get("markers").isEmpty() && !node.get("markers").isNull()){

                    // 组装用例信息
                    xmindTest(node.get("markers").at("/0/markerId").asText(), node.get(xmind.getTitleContent()).asText(), baseExcel);

                    // log.info("用例信息： {}" , JSON.toJSON(baseExcel));
                }

            } catch (Exception e) {
                // log.info("markers 等于NUll: {}", e.getMessage());
            }

            try {
                if (!node.get("notes").isEmpty() && !node.get("notes").isNull()){

                    // 组装用例信息
                    xmindTest("content", node.get("notes").at("/plain/content").asText(), baseExcel);

                    // log.info("用例信息： {}" , JSON.toJSON(baseExcel));
                } else {
                    baseExcel.setRemark("");
                }

            } catch (Exception e) {
                // log.info("notes 等于NUll: {}", e.getMessage());
            }

            Iterator<Map.Entry<String, JsonNode>> it = node.fields();

            while (it.hasNext()) {
                Map.Entry<String, JsonNode> entry = it.next();
                // 核心关键代码
                if (entry.getValue().asText().equals(xmind.getModule())) {
                    titleList.remove(titleList.size() - 1);
                    titleList.remove(titleList.size() - 1);
                }

                jsonLeaf(entry.getValue());
            }
        }

        if (node.isArray()) {
            Iterator<JsonNode> it = node.iterator();
            while (it.hasNext()) {
                var json = it.next();
                try {
                    if (json.get("markers").at("/0/markerId").asText().equals(xmind.getModule())){
                        // 获取内容
                        var titleContent = json.get(xmind.getTitleContent()).asText();

                        titleList.add(titleContent);
                        titleList.add("/");

                        String projectName = "";
                        for (String name : titleList) {
                            projectName += name;
                        }
                        // 添加项目模块，字符串追加
                        baseExcel.setProjectName(projectName);
                    }

                } catch (Exception e) {
                    // log.info("不是项目模块: {}", e.getMessage());
                }
                jsonLeaf(json);
            }
        }
    }

    /**
     * 组装用例信息
     *
     * @param markerId      xmind 标记
     * @param titleContent  用例内容
     * @param baseExcel     excel 实体类
     * @return              组装后的excel 实体类
     */
    public ITestBaseExcel xmindTest(String markerId, String titleContent, ITestBaseExcel baseExcel){

        // 前置条件
        if (xmind.getPreCondition().equals(markerId)) {
            baseExcel.setPreCondition(titleContent);
            return baseExcel;
        }
        // 步骤
        if (xmind.getBaseStep().equals(markerId)) {
            baseExcel.setBaseStep(titleContent);
            return baseExcel;
        }
        // 用例优先级：高
        if (xmind.getHigh().equals(markerId)) {
            baseExcel.setBaseDesc(titleContent);
            baseExcel.setPriority("高");
            return baseExcel;
        }
        // 用例优先级：中
        if (xmind.getMedium().equals(markerId)) {
            baseExcel.setBaseDesc(titleContent);
            baseExcel.setPriority("中");
            return baseExcel;
        }
        // 用例优先级：低
        if (xmind.getLow().equals(markerId)) {
            baseExcel.setBaseDesc(titleContent);
            baseExcel.setPriority("低");
            return baseExcel;
        }
        // 预期结果
        if (xmind.getBaseResult().equals(markerId)) {
            baseExcel.setBaseResult(titleContent);

            iTestBaseExcelList.add(BeanUtil.copyProperties(baseExcel, ITestBaseExcel.class));

            return baseExcel;
        }
        // 备注
        if (xmind.getRemark().equals(markerId)) {
            baseExcel.setRemark(titleContent);
            return baseExcel;
        }

        return baseExcel;
    }

    public List<ITestBaseExcel> getiTestBaseExcelList() {
        return iTestBaseExcelList;
    }

    public void setiTestBaseExcelList(List<ITestBaseExcel> iTestBaseExcelList) {
        this.iTestBaseExcelList = iTestBaseExcelList;
    }
}
