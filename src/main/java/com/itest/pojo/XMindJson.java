package com.itest.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: 咏蛙
 * @date: 2022/7/30 16:06
 * @description: 解析并配置xmind JSON
 */
@Data
@Component
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "base")
public class XMindJson {

    /**
     * xmind JSON 根路径
     */
    @Value("${rootTopic}")
    private String rootTopic;

    /**
     * 项目名称
     */
    @Value("${titleContent}")
    private String titleContent;

    /**
     * 项目模块
     */
    @Value("${module}")
    private String module;

    /**
     * 前置条件
     */
    @Value("${preCondition}")
    private String preCondition;

    /**
     * 步骤
     */
    @Value("${baseStep}")
    private String  baseStep;

    /**
     * 用例优先级：高
     */
    @Value("${high}")
    private String high;

    /**
     * 用例优先级：中
     */
    @Value("${medium}")
    private String medium;

    /**
     * 用例优先级：低
     */
    @Value("${low}")
    private String low;

    /**
     * 预期结果
     */
    @Value("${baseResult}")
    private String baseResult;

    /**
     * 备注
     */
    @Value("${remark}")
    private String remark;
}
