package com.example.demo.dao.util;

import java.sql.Timestamp;

/**
 * 日期工具类
 * @author lbs
 * @dete 2019年4月17日
 */
public class DateUtil {


    /**
     * 获取当前时间戳
     * 2019-04-17 15:15:06.339
     * @return
     */
    public static Timestamp getSystemTimestamp(){
        long currentTime = System.currentTimeMillis();
        return new Timestamp(currentTime);
    }



}
