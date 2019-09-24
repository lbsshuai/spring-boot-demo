package com.example.demo.controller.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lbs
 * @date 2019/9/18
 */
@Configuration
public class WebConfInterceptor implements WebMvcConfigurer {

    //获取拦截器实体类
    @Bean
    public HandlerInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }
    @Bean
    public BizInterceptor getBizInterceptor() {
        return new BizInterceptor();
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(getBizInterceptor()).addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
