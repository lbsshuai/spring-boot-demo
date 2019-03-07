package com.example.demo.dao.test;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author lbs
 * @dete
 */
@Configuration
@PropertySource(value = "classpath:application-test.properties")
@ConfigurationProperties(prefix = "com.lbs")
@Data
public class MyBeanProperties {

    private String one;
    private String two;
}
