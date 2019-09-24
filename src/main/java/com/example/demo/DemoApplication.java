package com.example.demo;

import com.example.demo.controller.interceptor.BizInterceptor;
import org.apache.xmlbeans.impl.regex.REUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.controller.interceptor.LoginInterceptor;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement //支持事务注解
@EnableAsync //支持异步注解
@MapperScan(basePackages= {"com.example.demo.dao.mapper","com.example.demo.*.mapper"})
//@PropertySource注解可以一个一个读取配置文件 不能直接使用*.properties操作
@PropertySource(value = {"classpath:properties/sys.properties",
						"classpath:properties/dbconf.properties",
						"classpath:properties/quartz.properties"})
public class DemoApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
