package com.example.demo;

import com.example.demo.dao.test.MyBean;
import com.example.demo.dao.test.MyBeanProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Temporal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

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
	public void sysTest(){
		System.out.println(System.nanoTime());
		System.out.println(System.currentTimeMillis());
		long lo = System.currentTimeMillis();
		Date time1 = new Date();
		Calendar calendar= Calendar.getInstance();
		System.out.println("Calendar:" + calendar);
		System.out.println(time1);
		long time2 = System.currentTimeMillis();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy年 MM月 dd天 HH时 mm分 ss秒 a E");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-mm-dd");
		String formatTime = format1.format(time1);
		System.out.println(format1.format(time1));
		System.out.println(format2.format(time1));
		System.out.println(format1.format(time2));


		long date = new Date().getTime();
		Timestamp timestamp = new Timestamp(date);
		System.out.println(new Timestamp(date));

	}

	@Test
	public void properties(){
		Properties properties = new Properties();
		String aa = properties.getProperty("aaaa");
		String bb = String.valueOf(properties.getProperty("server.port"));
		System.out.println(aa+ "-----"+ bb);
	}

	@Test
	public void configBean(){
		System.out.println(myBeanProperties.getUrl());
		System.out.println(myBeanProperties.getUsername());
	}
}
