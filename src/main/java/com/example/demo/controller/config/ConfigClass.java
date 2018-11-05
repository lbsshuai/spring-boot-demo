package com.example.demo.controller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations= {"file:src/main/resources/application-bean.xml"})
public class ConfigClass {

}
