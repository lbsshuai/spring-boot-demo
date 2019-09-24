package com.example.demo.dao.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 获取配置文件中的值
 * @author lbs
 * @date 2019/9/18
 */
@Configuration
public class YfPropertyUtil {
    private static Log logger = LogFactory.getLog(YfPropertyUtil.class);

    @Autowired
    private static Environment env;

    public YfPropertyUtil(Environment env) {
        YfPropertyUtil.env = env;
    }

    public static String getProperyValue(String key) {
        System.out.println(env);
        String value = null;
        if (StringUtils.isNotBlank(key)) {
            value = env.getProperty(key);
            // 当编码格式不同时，可以使用以下代码进行转换
            /*if (StringUtils.isNotBlank(value)) {
                try {
                    value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    logger.error("YfPropertyUtil Exception", e);
                }
            }*/
        }
        return value;
    }
}
