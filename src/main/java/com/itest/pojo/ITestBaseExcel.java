package com.itest.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: 咏蛙
 * @date: 2022/7/30 09:35
 * @description: ITest 用例模板
 */
@Data
@Component
public class ITestBaseExcel {

    /**
     * 从第几行开始读取、写入，从0开始
     */
    @ExcelIgnore
    @ExcelProperty(index = 5)
    private int row;

    @ExcelProperty("编号/校验码")
    private String projectId = "add";

    @ExcelProperty("功能项/目录")
    private String projectName = "";

    @ExcelProperty("用例描述")
    private String baseDesc;

    @ExcelProperty("前置条件")
    private String preCondition;

    /**
     * 步骤
     */
    @ExcelProperty("操作过程及数据")
    private String baseStep;

    @ExcelProperty("预期结果")
    private String baseResult;

    @ExcelProperty("线上状态")
    private String proState = "未测试";

    @ExcelProperty("离线执行状态")
    private String executeState = "未执行";

    @ExcelProperty("执行版本")
    private String executeVersion;

    @ExcelProperty("类型")
    private String type = "功能";

    @ExcelProperty("优先级")
    private String priority;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("标签（多个标签空格隔开）")
    private String tag;

}
