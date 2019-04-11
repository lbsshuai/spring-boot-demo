package com.example.demo;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.dao.test.MyBean;
import com.example.demo.dao.test.MyBeanProperties;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Value("${my.name}")
	private String name;
	@Value("${my.age}")
	private String age;
	@Value("${my.number}")
	private Integer number;
	@Value("${my.uuid}")
	private String uuid;
	@Value("${my.max}")
	private Integer max;
	@Value("${my.value}")
	private String value;
	@Value("${my.greeting}")
	private String greeting;

	@Autowired
	private MyBean myBean;
	@Autowired
	private MyBeanProperties myBeanProperties;

	@Test
	public void contextLoads() {

		System.out.println(name);
		System.out.println(age);
		System.out.println(number);
		System.out.println(max);
		System.out.println(uuid);
		System.out.println(value);
		System.out.println(greeting);

		System.out.println(myBean);
		System.out.println(myBeanProperties);
	}
	@Test
	public void context1(){
		//当前时间
		Date date = new Date();
		long time = date.getTime();

		Date date1 = new Date();
		long time1 = date1.getTime();

		System.out.println(time1-time);
		System.out.println((time1-time)/(1000));
		System.out.println((time1-time)/(1000*60));
		System.out.println((time1-time)/(1000*60*60));
	}

	@Test
	public void context2(){

		flag1:
		for(int i=0;i<3;i++){
			System.out.println("i:"+i);
			flag2:
			for (int j = 0; j<5; j++){
				if(j==3){
					break flag1;
				}
				System.out.println("j:"+j);
			}
			System.out.println("结束"+i);
			//test-01
		}
	}
	@Test
	public void testFenZhi(){
		System.out.println("我回退了吗？");
	}

}
