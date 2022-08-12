package com.itest.excel;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

/**
 * @author: 咏蛙
 * @date: 2022/8/6 18:49
 * @description: 添加指定单元格内容
 */
public class BaseExcelUtil {

    public static String writerBaseExcel (String fileName) {
        //通过构造方法创建writer
        ExcelWriter writer = ExcelUtil.getWriter(fileName);
        writer.writeCellValue(11,3, "源校验码");
        writer.writeCellValue(12,3, "无");
        writer.close();

        return "写入完成！";
    }
}
