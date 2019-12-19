package com.example.demo.controller.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import javax.swing.event.ChangeEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lbs
 * @date 2019/12/5
 */
public class MyProducerTopic {
    private final static String QUEUE_NAME = "Topic_ONE";
    private final static String ROUTING_KEY = "Topic-Routing-One";
    private final static String EXCHANGE_NAME = "Topic-Exchange-One";

    public static void main(String[] args) throws Exception{
        // 创建连接
        Connection conn = ConnectionFac.getConnectionFactory();
        //创建消息通道
        Channel channel = conn.createChannel();

        String msg = "我是主题交换机（Topic-Exchange-One）+   路由键：Topic-Routing-One + 队列（Topic_ONE），返回信息";

        /**
         * 创建一个type=topic 持久化的非自动删除的交换器
         */
        channel.exchangeDeclare(EXCHANGE_NAME, "topic", true, false, null);

        /**
         * 创建一个队列
         */
        // 队列持久化  为true时，mq重启不丢失
        boolean durable = true;
        // 是否排外
        boolean exclusive = false;
        //是否自动删除  当最后一个消费者断开连接之后队列是否自动被删除
        boolean autoDelete = false;

        /**
         * 设置队列基本属性
         */
        // 通过队列属性 设置消息过期时间
        Map<String, Object> argss = new HashMap<>();
        //argss.put("x-message-ttl", 16000);
        // 设置队列个数
        argss.put("x-max-length", 10);
        // 指定时间内队列没有被访问，就被清除
        // argss.put("x-expires", 10000);

        //通过信道 创建新队列 并设置队列基本属性
        channel.queueDeclare(QUEUE_NAME, durable, exclusive, autoDelete, argss);

        /**
         * 将交换器和队列通过路由键绑定
         */
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);

        // MessageProperties 中设置deliveryMode值，当值为1：非持久化；2：持久化
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.TEXT_PLAIN, msg.getBytes());
        channel.close();
        conn.close();
    }
}
