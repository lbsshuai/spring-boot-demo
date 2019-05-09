package com.example.demo.dao.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * swagger配置
 * @author lbs
 * @date: 2019年 05月 07日
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) /*调用下边apiInfo方法*/
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller.cpts"))/*设置生成API的目录*/
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Demo 公司平台管理系统_接口文档")
                .description("包含 平台首页、平台商品展示、平台购物车及订单展示等")
                .contact(new Contact("二哈先生", "www.baidu.com", "shuai.163.com"))
                .version("版本号 1.0")
                .build();
    }
}
