package com.example.demo.dao.test;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lbs
 * @dete
 */
@ConfigurationProperties(prefix = "my")
@Component
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
