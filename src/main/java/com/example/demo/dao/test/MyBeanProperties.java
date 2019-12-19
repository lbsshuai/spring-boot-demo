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
@PropertySource(value = "classpath:properties/dbconf.properties")
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class MyBeanProperties {

    private String url;
    private String username;
}