package com.example.demo.configuration.base;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * 属性文件读取配置
 * @author lbs
 * @date 2019/9/18
 */
@Configuration
@PropertySources({@PropertySource("classpath:config/bizconf.properties"),
                @PropertySource("classpath:config/sysconf.properties")})
public class PropertyConfiguration {

}
