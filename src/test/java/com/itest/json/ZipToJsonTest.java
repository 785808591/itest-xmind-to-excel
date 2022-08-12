package com.itest.json;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itest.ITestApplication;
import com.itest.pojo.ITestBaseExcel;
import com.itest.pojo.XMindJson;
import com.itest.service.BaseToExcelService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipFile;

/**
 * @author: 咏蛙
 * @date: 2022/7/30 17:29
 * @description: tudo
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = ITestApplication.class)
public class ZipToJsonTest {

    static ITestBaseExcel baseExcel = new ITestBaseExcel();
    @Resource
    XMindJson xmind;

    List<ITestBaseExcel> iTestBaseExcelList = new LinkedList<>();

    List<String> titleList = new LinkedList<>();
    String fileName = "C:\\Users\\78580\\Desktop\\excel\\"+ System.currentTimeMillis() +".xlsx";

    @Test
    public void testZip() throws Exception {

        File name = FileUtil.rename(FileUtil.file("C:\\Users\\78580\\Desktop\\excel\\demo.xmind"),"demo.zip", false);
        System.out.println(name);

        var str = ZipUtil.get(new ZipFile(name), "content.json");

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(str);

        System.out.println(xmind);

        BaseToExcelService excelService = new BaseToExcelService();

        // System.out.println(jsonNode.at("/0/title"));

        jsonLeaf(jsonNode.findValue("rootTopic"));

        System.out.println(JSON.toJSON(iTestBaseExcelList));

        excelService.save(iTestBaseExcelList, fileName);
    }

    @Test
    public void testJson() throws Exception {
        String str = "[{\"id\":\"93e9b21e1ea8a478d1fd7932f7\",\"class\":\"sheet\",\"title\":\"画布 1\",\"rootTopic\":{\"id\":\"b9aa22deba98b3b20c7ac8aca2\",\"class\":\"topic\",\"title\":\"demo\",\"structureClass\":\"org.xmind.ui.map.unbalanced\",\"children\":{\"attached\":[{\"id\":\"b58888b5ceebbf0e68dada0656\",\"title\":\"登录\",\"children\":{\"attached\":[{\"title\":\"异常登录\",\"id\":\"6fd08f4f-dfa8-4237-a547-bd44a5386deb\",\"children\":{\"attached\":[{\"id\":\"0ce90ae0-e5dd-48d2-9a7e-8536d512f151\",\"title\":\"前置条件\",\"children\":{\"attached\":[{\"id\":\"6c1db6be-3074-4a1d-bfd7-cf6bed127095\",\"title\":\"用例-1\",\"children\":{\"attached\":[{\"id\":\"f6f39a37-cc35-4816-9bb3-70c17993648d\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"d2476f19-a4f3-4b13-b9e0-68e8da908906\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}],\"notes\":{\"plain\":{\"content\":\"预期结果笔记\"},\"ops\":{\"ops\":[{\"insert\":\"预期结果笔记\\n\"}]},\"html\":{\"content\":{\"paragraphs\":[{\"spans\":[{\"text\":\"预期结果笔记\"}]}]}}}}]},\"markers\":[{\"markerId\":\"people-blue\"}],\"notes\":{\"plain\":{\"content\":\"步骤笔记\"},\"ops\":{\"ops\":[{\"insert\":\"步骤笔记\\n\"}]},\"html\":{\"content\":{\"paragraphs\":[{\"spans\":[{\"text\":\"步骤笔记\"}]}]}}}}]},\"markers\":[{\"markerId\":\"priority-2\"}],\"notes\":{\"plain\":{\"content\":\"用例笔记\"},\"ops\":{\"ops\":[{\"insert\":\"用例笔记\\n\"}]},\"html\":{\"content\":{\"paragraphs\":[{\"spans\":[{\"text\":\"用例笔记\"}]}]}}}},{\"id\":\"04b0d4df-297e-4f40-b8f6-7cda0736b54f\",\"title\":\"用例-2\",\"markers\":[{\"markerId\":\"priority-2\"}],\"children\":{\"attached\":[{\"id\":\"a9737d7a-fc5f-4815-96f5-f864787dd220\",\"title\":\"步骤-2\",\"children\":{\"attached\":[{\"id\":\"2c567bfc-3d0e-4f37-b216-2ce8bb327c8c\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"90d70c51-5046-4f04-bf59-66d39d4a213b\",\"title\":\"用例-3\",\"markers\":[{\"markerId\":\"priority-2\"}],\"children\":{\"attached\":[{\"id\":\"5ac7561a-d254-44fb-9393-4f4b4d379470\",\"title\":\"步骤-3\",\"children\":{\"attached\":[{\"id\":\"f675e17d-9ae4-490b-8516-0d4ba1551030\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"15209f9b-0348-49e8-bd39-7b2177fb5363\",\"title\":\"用例-4\",\"markers\":[{\"markerId\":\"priority-2\"}],\"children\":{\"attached\":[{\"id\":\"0f475382-c0e1-4c32-8d87-df1a2747c1a9\",\"title\":\"步骤-4\",\"children\":{\"attached\":[{\"id\":\"c8169b60-7e96-4430-8bf1-44f5d82c2326\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"d7262037-196b-4e56-98e1-555b0443d551\",\"title\":\"用例-5\",\"markers\":[{\"markerId\":\"priority-2\"}],\"children\":{\"attached\":[{\"id\":\"b465a8e3-e976-4545-8e89-802c4b24151b\",\"title\":\"步骤-5\",\"children\":{\"attached\":[{\"id\":\"f7cf3432-af0b-4b3b-b909-3ec8cde25964\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}}]},\"markers\":[{\"markerId\":\"flag-red\"}],\"notes\":{\"plain\":{\"content\":\"前置条件笔记\"},\"ops\":{\"ops\":[{\"insert\":\"前置条件笔记\\n\"}]},\"html\":{\"content\":{\"paragraphs\":[{\"spans\":[{\"text\":\"前置条件笔记\"}]}]}}}}]},\"markers\":[{\"markerId\":\"tag-red\"}],\"notes\":{\"plain\":{\"content\":\"笔记备注\"},\"ops\":{\"ops\":[{\"insert\":\"笔记备注\\n\"}]},\"html\":{\"content\":{\"paragraphs\":[{\"spans\":[{\"text\":\"笔记备注\"}]}]}}}},{\"title\":\"正确登陆\",\"id\":\"37453333-181e-4c88-b481-5f4dd3a8e77a\",\"children\":{\"attached\":[{\"id\":\"81a300dd-9aed-42fa-9abb-00d52cf1b5d3\",\"title\":\"前置条件\",\"position\":{\"x\":-134,\"y\":-508.25},\"children\":{\"attached\":[{\"id\":\"a5aaf28a-16b2-4050-aba2-242641b17f58\",\"title\":\"用例-1\",\"markers\":[{\"markerId\":\"priority-2\"}],\"children\":{\"attached\":[{\"id\":\"232ec22d-91f3-4f40-96a0-b37a892354d1\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"e2fe50a6-a9c2-4fe1-b27d-3531c6aa8ecc\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"a51bf899-9e6e-4dee-af47-1fe27677cc9d\",\"title\":\"用例-2\",\"markers\":[{\"markerId\":\"priority-2\"}],\"children\":{\"attached\":[{\"id\":\"ddab400c-d280-4541-b443-8359068a47f5\",\"title\":\"步骤-2\",\"children\":{\"attached\":[{\"id\":\"92d30e83-f7ae-4b63-99d4-9eb07a22d8ea\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"fd042d50-ca04-4424-9270-6be2067acf8e\",\"title\":\"用例-3\",\"markers\":[{\"markerId\":\"priority-2\"}],\"children\":{\"attached\":[{\"id\":\"186e974b-ac52-4216-9f9e-d9c5e2123c0e\",\"title\":\"步骤-3\",\"children\":{\"attached\":[{\"id\":\"f1537eac-0026-4dfb-b814-88e2d17d0c5f\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"12282234-d8aa-436d-a7b1-36d3a73a9fb1\",\"title\":\"用例-4\",\"markers\":[{\"markerId\":\"priority-2\"}],\"children\":{\"attached\":[{\"id\":\"a2666e3b-983f-4821-8e3c-ba06fced4133\",\"title\":\"步骤-4\",\"children\":{\"attached\":[{\"id\":\"e8144385-f483-4402-b730-d0e13095dd1a\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"1b46ecc6-2e52-4530-b091-4276eaf3464a\",\"title\":\"用例-5\",\"markers\":[{\"markerId\":\"priority-2\"}],\"children\":{\"attached\":[{\"id\":\"3ce3910a-3fc3-4f92-989f-0a14bd211c27\",\"title\":\"步骤-5\",\"children\":{\"attached\":[{\"id\":\"26ac6016-f896-4121-a0db-7180482797a8\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}}]},\"markers\":[{\"markerId\":\"flag-red\"}]}]},\"markers\":[{\"markerId\":\"tag-red\"}]}]},\"markers\":[{\"markerId\":\"tag-red\"}]},{\"title\":\"新建账号\",\"id\":\"c51146b0-7ef6-467f-be65-894222f822b0\",\"children\":{\"attached\":[{\"title\":\"填写用户名\",\"id\":\"459aae7c-565c-4011-b376-c6319e3c6f97\",\"children\":{\"attached\":[{\"id\":\"8a4bd4a5-a3e1-4fa4-accb-cc386a405a4a\",\"title\":\"前置条件\",\"children\":{\"attached\":[{\"id\":\"a216a71d-8730-4888-85e4-1496b21fa7ae\",\"title\":\"用例-1\",\"markers\":[{\"markerId\":\"priority-3\"}],\"children\":{\"attached\":[{\"id\":\"ebb0d31a-4e1f-46bc-9720-03fca5be27d0\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"c3a0d270-7cce-44d8-a904-fea1bb32f220\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"7d1edbad-7460-450d-94cb-0de6ae56d012\",\"title\":\"用例-2\",\"markers\":[{\"markerId\":\"priority-3\"}],\"children\":{\"attached\":[{\"id\":\"150627b7-0eb1-4347-afa0-9d3ed761bc05\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"47d85edc-332f-4bdd-a0d5-0b22267d02dc\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"62316560-dff5-4d48-98c2-21a2248342d7\",\"title\":\"用例-3\",\"markers\":[{\"markerId\":\"priority-3\"}],\"children\":{\"attached\":[{\"id\":\"23896c18-5365-4922-9a7e-01d4746e4fae\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"efe1da9b-64ef-4f04-a6ee-a861301217ed\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}}]},\"markers\":[{\"markerId\":\"flag-red\"}]}]},\"markers\":[{\"markerId\":\"tag-red\"}]},{\"title\":\"填写密码\",\"id\":\"39a5a6e3-60c6-4073-8e09-9876c33b7a32\",\"children\":{\"attached\":[{\"id\":\"0a771392-5c57-4305-a95c-6f39b5205eb5\",\"title\":\"前置条件\",\"children\":{\"attached\":[{\"id\":\"53ed1c84-9269-4c13-b144-a4c3b9662423\",\"title\":\"用例-1\",\"markers\":[{\"markerId\":\"priority-3\"}],\"children\":{\"attached\":[{\"id\":\"add3f142-6f69-4e9b-8c92-ade694cdfa08\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"81891be2-30a3-4373-a215-04f365ef2b71\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"0f2b8711-12eb-4368-8310-0745fc9a3dab\",\"title\":\"用例-2\",\"markers\":[{\"markerId\":\"priority-3\"}],\"children\":{\"attached\":[{\"id\":\"d1994712-a11e-4a89-bc54-3d7c74fea455\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"0857558c-692f-4e66-b048-7881146fb185\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"c9b68b1f-96d1-4a3f-9661-36b44a4721b6\",\"title\":\"用例-3\",\"markers\":[{\"markerId\":\"priority-3\"}],\"children\":{\"attached\":[{\"id\":\"10609824-c1f0-415a-bc34-36040ba0f6f8\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"99584210-f1b8-4518-82e1-fd9ed0667212\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}}]},\"markers\":[{\"markerId\":\"flag-red\"}]}]},\"markers\":[{\"markerId\":\"tag-red\"}]},{\"title\":\"填写邮箱\",\"id\":\"fc73b167-a191-4ba7-9108-80dbcb8bd5be\",\"children\":{\"attached\":[{\"id\":\"f8e444fc-8f00-4517-b8fc-61720bff5dbe\",\"title\":\"前置条件\",\"children\":{\"attached\":[{\"id\":\"cd3a96ca-61d5-4167-9de7-4e1f05532c81\",\"title\":\"用例-1\",\"markers\":[{\"markerId\":\"priority-3\"}],\"children\":{\"attached\":[{\"id\":\"b6018e76-c2f8-48dc-9e16-3265b3df9927\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"102661b3-4ff9-4beb-8633-952a678287fb\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"9e3a69b7-71d4-4de2-b68a-fee2e008279c\",\"title\":\"用例-2\",\"markers\":[{\"markerId\":\"priority-3\"}],\"children\":{\"attached\":[{\"id\":\"339076d0-85a0-4037-bc90-f96c503f3352\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"9fb3d2ab-f06c-4240-9a64-040c80195e97\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"3bd0312f-8b94-41d9-8f31-ecbbfc65e643\",\"title\":\"用例-3\",\"markers\":[{\"markerId\":\"priority-3\"}],\"children\":{\"attached\":[{\"id\":\"23775bb7-9386-466a-b4f5-35cb59243c14\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"105662a0-c86d-4957-baba-a4c27d0b612e\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}}]},\"markers\":[{\"markerId\":\"flag-red\"}]}]},\"markers\":[{\"markerId\":\"tag-red\"}]}]},\"markers\":[{\"markerId\":\"tag-red\"}]},{\"id\":\"193b56735e689ae86a01d91513\",\"title\":\"菜品\",\"children\":{\"attached\":[{\"title\":\"菜品编号\",\"id\":\"bbddf805-907e-4d3c-8e61-d7a6e5556b3a\",\"children\":{\"attached\":[{\"id\":\"0a862751-5a33-407d-abd1-dfdb16542a8c\",\"title\":\"前置条件\",\"children\":{\"attached\":[{\"id\":\"e74430ae-1e9d-47ed-ba85-19a465835206\",\"title\":\"用例-1\",\"markers\":[{\"markerId\":\"priority-3\"}],\"children\":{\"attached\":[{\"id\":\"d0bb675a-a8bb-42c4-97ca-8d1377afa919\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"a1aaa406-0def-4413-8782-ffb4a05bd3a2\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"f5202c6b-fd7b-411c-8840-d260c7bb403a\",\"title\":\"用例-2\",\"markers\":[{\"markerId\":\"priority-3\"}],\"children\":{\"attached\":[{\"id\":\"9ee816e5-18c3-4914-8e1a-69677d12aebc\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"a513398f-3fb0-4866-8fa0-5f7fda413f05\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"f7cc5789-6da7-4655-a11a-8d1a38075aff\",\"title\":\"用例-3\",\"markers\":[{\"markerId\":\"priority-3\"}],\"children\":{\"attached\":[{\"id\":\"0dd5f8ca-aa88-472a-91db-df51b4bae125\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"d75a051e-7e65-454d-bb30-c09254ff68b0\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}}]},\"markers\":[{\"markerId\":\"flag-red\"}]}]},\"markers\":[{\"markerId\":\"tag-red\"}]},{\"title\":\"菜品名称\",\"id\":\"dc1e1de4-b9e7-4cd1-884b-3955f5779c19\",\"children\":{\"attached\":[{\"id\":\"e9a28293-464d-49af-919e-32c13640f233\",\"title\":\"前置条件\",\"children\":{\"attached\":[{\"id\":\"4ddc0f85-d7ea-4a84-bb16-4ff9eb43c4f3\",\"title\":\"用例-1\",\"markers\":[{\"markerId\":\"priority-3\"}],\"children\":{\"attached\":[{\"id\":\"97e6340f-8c5b-4bc6-af3f-735d4bd9ca31\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"fbcf24a3-279f-4cb9-816c-ce8737fc9148\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"96a4f059-d88e-4862-bd73-d5e3f2aac958\",\"title\":\"用例-2\",\"markers\":[{\"markerId\":\"priority-3\"}],\"children\":{\"attached\":[{\"id\":\"5081b97d-eaba-4b18-a74c-5afb1a58f92a\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"0323ca0b-15e8-4508-b06a-cd3c5644ce25\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"b7ef72ce-5a76-4ea0-bab9-0f2dac26a4d0\",\"title\":\"用例-3\",\"markers\":[{\"markerId\":\"priority-3\"}],\"children\":{\"attached\":[{\"id\":\"41797e58-d9c1-4129-b80e-a58b21efe1e5\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"4a6fbd4e-2e2f-4320-b597-f4da9cc53fca\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}}]},\"markers\":[{\"markerId\":\"flag-red\"}]}]},\"markers\":[{\"markerId\":\"tag-red\"}]}]},\"markers\":[{\"markerId\":\"tag-red\"}]},{\"id\":\"67ddbcb1-85c9-4478-a0aa-580e9fdcd971\",\"title\":\"下单\",\"children\":{\"attached\":[{\"title\":\"支付宝\",\"id\":\"f5ff5962-9ad1-4daf-a237-705ead66dc19\",\"children\":{\"attached\":[{\"id\":\"7dbb4865-eba7-4e26-a006-e39c10b5a824\",\"title\":\"优惠券\",\"children\":{\"attached\":[{\"id\":\"01f22f55-9bea-484e-b9e3-a0b720867bd4\",\"title\":\"前置条件\",\"position\":{\"x\":-134,\"y\":-470.25},\"children\":{\"attached\":[{\"id\":\"b948f3a7-e433-44aa-9789-ae599b560764\",\"title\":\"用例-1\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"1a42f6a4-640e-4e09-8908-d9657eee49c4\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"2cee485a-6466-4114-aca3-0177b1203cac\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"d6c50461-112c-4e7b-a689-13d6137f08d6\",\"title\":\"用例-2\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"e7519263-4f6c-4d60-8993-2c076bb642e6\",\"title\":\"步骤-2\",\"children\":{\"attached\":[{\"id\":\"ee4efc20-05b7-4acf-88c1-9747fc7530d8\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"58cdc8b8-7d02-47cd-b064-96e8f982273e\",\"title\":\"用例-3\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"996d2f21-1870-46b7-8133-faaa9536e945\",\"title\":\"步骤-3\",\"children\":{\"attached\":[{\"id\":\"8ca44221-7b3e-4ba3-88d5-3ed340f8e6d4\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"060d3b73-8991-4adb-9a33-52bf700c31c5\",\"title\":\"用例-1\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"2c50195a-b83a-4981-9422-b5154b1d17c3\",\"title\":\"步骤-4\",\"children\":{\"attached\":[{\"id\":\"bf7a7a9d-a1d3-4eea-8ec9-d81588c0edda\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"a219263d-0399-465a-b357-5b97df27421d\",\"title\":\"用例-2\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"f4ad2c8a-5871-4f39-a293-24afa18fcddb\",\"title\":\"步骤-5\",\"children\":{\"attached\":[{\"id\":\"b347ed6b-f160-4684-a579-13a4876a4eb1\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"f6465488-cea8-4f23-88b7-26e31f8c9088\",\"title\":\"用例-3\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"3773d402-a17d-4fdc-a078-dc3895b16345\",\"title\":\"步骤-6\",\"children\":{\"attached\":[{\"id\":\"7020773c-679d-49b9-a762-3f5730351c2b\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}}]},\"markers\":[{\"markerId\":\"flag-red\"}]}]},\"markers\":[{\"markerId\":\"tag-red\"}]},{\"title\":\"积分\",\"id\":\"91d2b46a-3cd8-4d4f-8fae-675c647a31ec\",\"children\":{\"attached\":[{\"id\":\"9abd4ba0-0bf7-473a-9907-a3686114ab90\",\"title\":\"前置条件\",\"position\":{\"x\":-134,\"y\":-470.25},\"children\":{\"attached\":[{\"id\":\"0a8683c8-49b9-45d6-ac6f-f71cc6b5597c\",\"title\":\"用例-1\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"13019b81-0064-41c1-83e3-2b532a842b08\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"04cceabb-2aeb-456a-93cd-62aa5e80ba88\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"4a57d7b8-1875-4ead-89a1-32bd3ab17f7a\",\"title\":\"用例-2\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"6485f4cf-627d-46b0-b255-6d392b61647d\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"2cfb083b-9c8d-4620-be1c-41425ef0d621\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"5d6d38f6-9c65-48fc-a331-442eacb8a6be\",\"title\":\"用例-3\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"2611d053-a36a-4e38-bd1b-9968c48d0873\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"00f099c6-aa0b-43bb-a866-85edd169f4dd\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"7c04a84a-27b0-4059-bda9-8dec375a1985\",\"title\":\"用例-1\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"fd70fce7-359e-4170-b06d-f6180f594dac\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"08d3455b-d687-4cfc-a24d-7a4904b440b9\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"c7e43d34-851b-4949-98e2-865631fe2fd7\",\"title\":\"用例-2\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"53003d82-5abf-4eb6-aee8-79da858f1c10\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"cb017baa-0788-493d-a641-f80f392a6c18\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"c6808611-6830-48c8-bbe2-20d7e83db366\",\"title\":\"用例-3\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"a3ddcbe5-fad1-4153-92b5-3aae9620e55b\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"a97a2160-7a76-434d-8472-6348c19fb4ec\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}}]},\"markers\":[{\"markerId\":\"flag-red\"}]}]},\"markers\":[{\"markerId\":\"tag-red\"}]}]},\"markers\":[{\"markerId\":\"tag-red\"}]},{\"title\":\"微信\",\"id\":\"591c1d2f-8d81-4166-8f4d-78dbf1a57465\",\"children\":{\"attached\":[{\"id\":\"cf297e28-bb6f-45da-8326-9c31121b4a44\",\"title\":\"优惠券\",\"children\":{\"attached\":[{\"id\":\"244bccfd-49e9-4843-88ea-a53e03b4b82c\",\"title\":\"前置条件\",\"position\":{\"x\":-134,\"y\":-470.25},\"children\":{\"attached\":[{\"id\":\"7067e45e-2cfc-42ff-ba32-42f10cd744d8\",\"title\":\"用例-1\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"89fbf8a9-9c46-476e-acf8-ba8d2b84a6e8\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"8a61d23a-8f05-4e81-94c8-48cdab506bfe\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"81f53e73-59f3-4179-9c4e-96192d711d65\",\"title\":\"用例-2\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"42bfcf2b-82e3-437a-a2b9-1aee3c227d3b\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"7d6dfeeb-c151-4acd-a844-817dbae754ca\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"ae7e4ee5-b5b2-4d0e-bbf1-77a838aaa236\",\"title\":\"用例-3\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"dd39323e-80ba-47b6-a6d8-15f7f817ae39\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"85b7c486-7625-4b73-9503-8b8f5d66ca79\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"2a91c297-566d-4d55-99d6-d45d6c057ceb\",\"title\":\"用例-1\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"a5591cd7-9aa8-4c62-939c-d763b5d7d774\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"dade7e9e-2f26-4d3e-9b0b-2b32ee98702c\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"5e3b1800-8757-4b3d-8968-b63d05b01767\",\"title\":\"用例-2\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"f65c1155-9e49-425e-822a-357b026af9e2\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"872bbea0-c863-400f-a929-66fc2ef2f6ae\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"0ec15eb6-68ad-479c-b6bb-ee7dbd508a80\",\"title\":\"用例-3\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"8667621b-057e-437b-8580-60be3972a94e\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"46c38569-0aa4-47ea-be70-1c865a4d3bb1\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}}]},\"markers\":[{\"markerId\":\"flag-red\"}]}]},\"markers\":[{\"markerId\":\"tag-red\"}]},{\"id\":\"95cc3415-20f9-4999-8f62-3dedb0ef450e\",\"title\":\"积分\",\"children\":{\"attached\":[{\"id\":\"77c47b04-53d1-4d6c-be4e-16a1cf2618f1\",\"title\":\"前置条件\",\"position\":{\"x\":-134,\"y\":-470.25},\"children\":{\"attached\":[{\"id\":\"96865ce1-4be5-4694-af20-22344a0690e8\",\"title\":\"用例-1\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"b8e678de-cf42-4efb-92d9-78fdd6511c0a\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"7d0281ca-9cdd-4f25-9b7d-6109f4a0932c\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"87296fca-6597-468c-8e24-25d7ccec916d\",\"title\":\"用例-2\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"37c3c7f4-f561-438f-966b-7aaba034e01c\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"208485e7-ee8c-4d22-bd7e-2757e5cf1bfc\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"7148940a-bd18-466c-a0a4-ddaa39c87d7d\",\"title\":\"用例-3\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"9b03e919-1ac6-4f69-9f26-66293909985d\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"698b041f-2a57-4749-9b8e-6dca7abe9198\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"1957ce20-8bc5-4b4f-b9b6-bccf92b89dac\",\"title\":\"用例-1\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"fe184097-675a-4e3d-b2a8-06e55ff01aa3\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"0ae5a004-3e09-4a65-9b52-5db4e57eaef8\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"822e5401-2db0-44cf-a199-60a7dce1b67a\",\"title\":\"用例-2\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"c43b94e4-9a64-4ad5-b622-1f3735f88e03\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"3b890a49-d0f4-4f3e-be2f-2c8aeab708fa\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}},{\"id\":\"f9a961b2-22b7-4c73-9f25-a0e2cb930f50\",\"title\":\"用例-3\",\"markers\":[{\"markerId\":\"priority-1\"}],\"children\":{\"attached\":[{\"id\":\"af733971-aff1-49b1-87cb-94319830ae66\",\"title\":\"步骤-1\",\"children\":{\"attached\":[{\"id\":\"a3bf7e1b-3f27-4847-8179-b4eabf25786d\",\"title\":\"预期结果\",\"markers\":[{\"markerId\":\"task-done\"}]}]},\"markers\":[{\"markerId\":\"people-blue\"}]}]}}]},\"markers\":[{\"markerId\":\"flag-red\"}]}]},\"markers\":[{\"markerId\":\"tag-red\"}]}]},\"markers\":[{\"markerId\":\"tag-red\"}]}]},\"markers\":[{\"markerId\":\"tag-red\"}]}]}}}]";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(str);

        System.out.println(xmind);

        BaseToExcelService excelService = new BaseToExcelService();

        // System.out.println(jsonNode.at("/0/title"));

        jsonLeaf(jsonNode.findValue("rootTopic"));

        System.out.println(JSON.toJSON(iTestBaseExcelList));

       excelService.save(iTestBaseExcelList,fileName);
    }


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
                    // log.info("用例信息： {}" , baseExcel);
                }

            } catch (Exception e) {
                // log.info("markers 等于NUll: {}", e.getMessage());
//                log.info("markers 等于NUll 的JSONNode: {}", node);
            }

            try {
                if (!node.get("notes").isEmpty() && !node.get("notes").isNull()){

                    // 组装用例信息
                    xmindTest("content", node.get("notes").at("/plain/content").asText(), baseExcel);

                    // log.info("用例信息： {}" , JSON.toJSON(baseExcel));
                    // log.info("用例信息： {}" , baseExcel);
                } else {
                    baseExcel.setRemark("");
                }

            } catch (Exception e) {



                // log.info("notes 等于NUll: {}", e.getMessage());
//                log.info("notes 等于NUll 的JSONNode: {}", node);
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
}
