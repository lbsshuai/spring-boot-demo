package com.example.demo.restTestmplate;

import com.example.demo.dao.test.BackInfo;
import com.example.demo.dao.test.BankInfoList;
import com.example.demo.dao.util.HttpUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 调用其他http服务 测试
 * @author lbs
 * @dete
 */
public class RestTestmplateTest {
    private RestTemplate restTemplate;

    @Before
    public void init(){
        restTemplate = new RestTemplate();
    }

    @Test
    public void testGet(){
        String url = "https://story.hhui.top/detail?id=666106231640";
        InnerRes res = restTemplate.getForObject(url, InnerRes.class);
        System.out.println(res);
    }
    @Test
    public void HttpClientTest1() {
        String http = HttpUtil.getHttp("http://10.1.16.114:8097/api/common/bank/info/query");
        System.out.println(http);
    }
    @Test
    public void HttpClientTest2() {
        //获取token
        Map<String, String> map = new HashMap<>();
        map.put("username","wna-nccp-mid");
        map.put("password", "6WUH9RZk/XezcUQc/yPukw==");
        String s = HttpUtil.postHttp("http://svc-gateway.sit.noahgrouptest.com/api/login", map);
        System.out.println(s);
    }
    @Test
    public void HttpClientTest3() {
        //获取token
        JSONObject jsonObject = null;
        try {
            jsonObject =  new JSONObject();
            jsonObject.put("username", "wna-nccp-mid");
            jsonObject.put("password", "6WUH9RZk/XezcUQc/yPukw==");
            String json = jsonObject.toString();
            String s = HttpUtil.postData("http://svc-gateway.sit.noahgrouptest.com/api/login", json,"application/json", null);
            System.out.println(s);
            Map<String, String> map = (Map)net.sf.json.JSONObject.fromObject(s);
            String token = null;
            if(map != null){
                for (Map.Entry<String, String> entry : map.entrySet()){
                    if (entry.getKey().equals("data")) {
                        System.out.println(entry.getKey());
                        token = entry.getValue();
                        System.out.println(entry.getValue());
                    }
                }
            }

            jsonObject =  new JSONObject();
            jsonObject.put("operator", "1582");
            jsonObject.put("password", "12345");
            jsonObject.put("subscriberNo", "3");
            jsonObject.put("type", "1");
            //调用接口
            String s1 = jsonObject.toString();
            String s2 = HttpUtil.postData("http://svc-gateway.sit.noahgrouptest.com/nccp-api/api/common/bank/info/query", s1, "application/json",
                    token);
            System.out.println(s2);

           Map<String, String> map1 = (Map) net.sf.json.JSONObject.fromObject(s2);
           for (Map.Entry<String, String> entry : map1.entrySet()){
               if (entry.getKey().equals("data")) {
                   net.sf.json.JSONObject jsonObject1 = net.sf.json.JSONObject.fromObject(entry.getValue());
                   Map<String, BankInfoList> map2= (Map)net.sf.json.JSONObject.fromObject(jsonObject1);
                   System.out.println("map2:"+map2);
                   for (Map.Entry<String, BankInfoList> entry1 : map2.entrySet()) {
                       System.out.println(entry1.getKey());
                       System.out.println(entry1.getValue());
                   }

               }
           }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
