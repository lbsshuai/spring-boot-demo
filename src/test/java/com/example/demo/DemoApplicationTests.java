package com.example.demo;

import com.example.demo.dao.test.MyBean;
import com.example.demo.dao.test.MyBeanProperties;
import com.example.demo.dao.util.SysUtil;
import com.example.demo.restTestmplate.ThreadTest1;
import com.google.common.collect.HashBasedTable;
import org.apache.catalina.webresources.war.WarURLConnection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.ConsoleHandler;

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
	@Value("${shoeMessageInfo}")
	private String shoeMessageInfo;
	@Value("${spring.datasource.url}")
	private String springDataSourceUrl;

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
			//Release_2020
			System.out.println("Release_2020");
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

	@Test
	public void testFenZhi(){
		System.out.println(SysUtil.getOrderIdByTime());

		System.out.println(SysUtil.getOrderIdByUUId());

		String aa = MessageFormat.format(shoeMessageInfo, "小明", "郑州");
		System.out.println(aa);
		System.out.println(springDataSourceUrl);
	}

    @Test
    public void testFenZhi1(){
        String aa = MessageFormat.format(shoeMessageInfo, "张三", "郑州", "王五");
        System.out.println(aa);
    }


    @Test
	public void tantan(){
		Date date = new Date();
		System.out.println("当前系统时间显示："+ date);
		//时间格式转换
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDate = simpleDateFormat.format(date);
		System.out.println("转换后的时间格式：" + formatDate);

	}
	@Test
	public void tantan1(){
		String a1 = "[\"低蛋白质饮食\",\"低盐饮食\",\"低脂饮食\",\"运动30分钟\"]";
		String a2 = a1.replace("[", "").replace("]", "")
				.replace("\"", "");
		System.out.println(a2);
	}

	@Test
	public void testDateTime() {
		Long dateTime = Long.parseLong("20190715142130");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = new Date(dateTime);
			String format1 = format.format(date);
			System.out.println(format1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public  void  testList() {
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.remove("aaa");
		System.out.println(list);
		/*for (String str : list) {
			if ("aaa".equals(str)) {
				list.remove("aaa");
			}
		}*/
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
		}
		HashMap<String, String> map = new HashMap<>();
		map.put("1","a");
		map.put("2","b");
		map.put("3","c");
		map.put("4","d");
		map.put(null,"f");
		HashMap<String, String> map1 = new HashMap<>(map);
		Set<Map.Entry<String, String>> entries = map1.entrySet();
		Iterator<Map.Entry<String, String>> iterator1 = entries.iterator();
		while (iterator1.hasNext()) {
			Map.Entry<String, String> next = iterator1.next();
			if (next.getKey() == null){
				System.out.println("----------------------");
				System.out.println(next.getKey() + "--" + next.getValue());
			}
		}

	}

	@Test
	public void testHashTable() {
		Hashtable<String, String> hashtable = new Hashtable<>();
		hashtable.put("1", "1");
		hashtable.put("2","2");

		for (Map.Entry<String, String> map : hashtable.entrySet()) {
			System.out.println(map.getKey() + "" + map.getValue());
		}

		ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
		concurrentHashMap.put("1", "1");
		concurrentHashMap.put("2", "2");
		Set<Map.Entry<String, String>> entries = concurrentHashMap.entrySet();
		Iterator<Map.Entry<String, String>> iterator = entries.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> next = iterator.next();

			System.out.println(next.getKey() + "-" + next.getValue());
			System.out.println(next.getKey().hashCode());
			System.out.println(next.getValue());
		}
	}


	@Test
	public void testType() {
		HashMap<Integer, Integer> hashMap = new HashMap();
		hashMap.put(1,1);
		//hashMap.put("--", "22");
		System.out.println(hashMap.toString());

	}

	@Test
	public void contextLoads1() {
		ThreadTest1 threadTest1 = new ThreadTest1();
		Thread thread = new Thread(threadTest1);
		thread.start();
	}

	@Test
	private void two20191219Test2() {
		System.out.println("我是20191219Test2");
	}
}
