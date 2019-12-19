package com.example.demo.controller.mq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author lbs
 * @date 2019/12/5
 */
public class ConnectionFac {

    public static Connection getConnectionFactory() throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        //连接IP
        factory.setHost("127.0.0.1");
        //连接端口
        factory.setPort(5672);
        //虚拟机
        factory.setVirtualHost("/");
        //用户
        factory.setUsername("guest");
        factory.setPassword("guest");

        // 创建连接
        Connection conn = factory.newConnection();
        return conn;
    }
}
