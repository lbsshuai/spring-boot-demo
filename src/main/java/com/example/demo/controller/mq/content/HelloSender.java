package com.example.demo.controller.mq.content;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送信息
 * @author lbs
 * @date 2019/9/23
 */
@Component
public class HelloSender {

    private static final Logger logger = LoggerFactory.getLogger(HelloSender.class);

    @Autowired
    private AmqpTemplate template;

    /**
     * 发送mq消息
     * @param key 队列名
     * @param value 队列信息
     */
    public void send(String key, String value) {
        logger.info("存入消息队列:  key：[{}]  value：[{}]", key, value);
        template.convertAndSend(key, value);
    }
}
