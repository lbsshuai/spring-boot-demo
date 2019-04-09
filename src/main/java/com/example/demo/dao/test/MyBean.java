package com.example.demo.dao.test;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lbs
 * @dete
 */
@ConfigurationProperties(prefix = "my")
@Component //为了让这个MyBean 可以被SpringBoot项目启动时被扫描并加入到Spring容器中
@Data
public class MyBean {

    private String name;
    private String age;
    private Integer number;
    private String uuid;
    private Integer max;
    private String value;
    private String greeting;
    private String aFree;

}
