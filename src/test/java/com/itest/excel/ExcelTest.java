package com.itest.excel;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileNameUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itest.listener.ITestDataListener;
import com.itest.pojo.ITestBaseExcel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: 咏蛙
 * @date: 2022/7/30 15:09
 * @description: 读写excel 测试类
 */
@Slf4j
public class ExcelTest {

    @Test
    public void testExcel() throws Exception {

        String fileName = "C:\\Users\\78580\\Desktop\\excel\\ItestCaseImpExpTemplate.xlsx";

        ITestDataListener listener = new ITestDataListener();
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, ITestBaseExcel.class, listener).sheet().headRowNumber(5).doRead();
    }



    private List<ITestBaseExcel> data() {
        List<ITestBaseExcel> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            ITestBaseExcel data = new ITestBaseExcel();
            // data.setString("字符串" + i);
            // data.setDate(new Date());
            // data.setDoubleData(0.56);
            // list.add(data);
        }
        return list;
    }

    @Test
    public void test() throws Exception {
        // System.out.println("1234" + "/");
        ITestBaseExcel baseExcel = new ITestBaseExcel();

        baseExcel.setProjectName("123" + "/");
        System.out.println(baseExcel);

        baseExcel.setProjectName(baseExcel.getProjectName() + "456" + "/");
        System.out.println(baseExcel);
    }

    @Test
    public void test01() throws Exception {
        String str = "{\"notes\":{\"plain\":{\"content\":\"笔记备注\"}}}";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(str);
        System.out.println(jsonNode.get("notes").at("/plain/content"));

    }

    @Test
    public void test02() throws Exception {
        List<String> notes = new LinkedList<>();
        notes.add("123");
        notes.add("/");
        notes.add("456");
        notes.add("/");
        notes.add("789");
        notes.add("/");
        System.out.println(notes.toString());

        notes.remove(notes.size() - 1);
        System.out.println(notes.toString());
        notes.remove(notes.size() - 1);
        System.out.println(notes.toString());

        String projectName = "";
        for (String note : notes) {
            projectName += note;
        }
        System.out.println(projectName);
    }

    @Test
    public void test03() throws Exception {
        String[] head = {"用户账户名称","版本","购买时间","购买时长（天）","支付金额"};
        // EasyExcel.writerSheet().head(head).build();
    }

    @Test
    public void testHutoolExcel() throws Exception {

        String fileName = "C:\\Users\\78580\\Desktop\\excel\\noModelWrite.xlsx";

        // 这里 需要指定写用哪个class去写
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, ITestBaseExcel.class).relativeHeadRowIndex(4).build()) {
            // 这里注意 如果同一个sheet只要创建一次
            WriteSheet writeSheet = EasyExcel.writerSheet("sheet1").build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
            for (int i = 0; i < 5; i++) {
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<ITestBaseExcel> data = dataBase();
                excelWriter.write(data, writeSheet);
            }
        }
        System.out.println("BaseExcelUtil.writerBaseExcel(fileName) = " + BaseExcelUtil.writerBaseExcel(fileName));
    }

    public List<ITestBaseExcel> dataBase () {
        List<ITestBaseExcel> list = new ArrayList<>();
        ITestBaseExcel base = new ITestBaseExcel();
        base.setProjectName("demo");
        base.setBaseDesc("123");
        base.setPreCondition("123");
        base.setBaseStep("123");
        base.setBaseResult("243");
        base.setProState("未测试");
        base.setExecuteState("134");
        base.setExecuteVersion("345");
        base.setType("53");
        base.setPriority("1324");
        base.setRemark("fasdfadsf");
        base.setTag("1534");

        list.add(base);
        return list;
    }

    /**
     * 不创建对象的写
     */
    @Test
    public void noModelWrite() {
        // 写法1
        String fileName = "C:\\Users\\78580\\Desktop\\excel\\noModelWrite.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName).head(head()).sheet().doWrite(dataList());

    }

    private List<List<String>> head() {
        List<List<String>> list = ListUtils.newArrayList();
        List<String> head0 = ListUtils.newArrayList();
        head0.add("字符串" + System.currentTimeMillis());
        List<String> head1 = ListUtils.newArrayList();
        head1.add("数字" + System.currentTimeMillis());
        List<String> head2 = ListUtils.newArrayList();
        head2.add("日期" + System.currentTimeMillis());
        list.add(head0);
        list.add(head1);
        list.add(head2);
        return list;
    }

    private List<List<Object>> dataList() {
        List<List<Object>> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            List<Object> data = ListUtils.newArrayList();
            data.add("字符串" + i);
            data.add(new Date()); 
            data.add(0.56);
            list.add(data);
        }
        return list;
    }

    @Test
    public void testFile() throws Exception {
        System.out.println(FileUtil.getPrefix("C:\\Users\\78580\\Desktop\\excel\\test\\demo.xmind"));

        // FileNameUtil
    }

}
