package com.example.demo.dao.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 系统工具类
 * @author lbs
 * @dete 2019年4月17日
 */
public class SysUtil {


    /**
     * 用UUID生成十六位数唯一订单号
     * 000000994767961
     * @return
     */
    public static String getOrderIdByUUId(){
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {
            hashCodeV = -hashCodeV;
        }
        return String.format("%015d",hashCodeV);
    }

    /**
     * 当前时间+随机数
     * 20190417151648778
     * 扩展（可以加id等唯一性标识）
     * @return
     */
    public static String getOrderIdByTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i< 3; i++){
            result += random.nextInt(10);
        }
        return newDate + result;

    }

}


