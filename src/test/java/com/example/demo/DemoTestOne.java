package com.example.demo;

import com.example.demo.dao.util.YfPropertyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.MessageFormat;

/**
 * 测试类
 * @author lbs
 * @date 2019/9/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTestOne {

    private static final String REMIND_GO_SCHOOL= "remind.go_school";

    @Value("${remind.go_school}")
    private String remind;

    @Test
    public void getPropertyValue() {
        //获取配置文件中key对应的value值
        String properyValue = YfPropertyUtil.getProperyValue(REMIND_GO_SCHOOL);
        System.out.println(properyValue); // {0}骑着摩托，去{1}。
        System.out.println(remind); // {0}骑着摩托，去{1}。
        //使用MessageFormat 填充值
        String format = MessageFormat.format(remind, "小明", "学校");
        System.out.println(format); // 小明骑着摩托，去学校。
    }
}
