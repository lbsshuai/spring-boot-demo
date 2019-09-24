package com.example.demo.controller.mq;

import com.rabbitmq.client.AMQP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * MQ 生产者
 * @author lbs
 * @date 2019/9/23
 */
@Configuration
public class SenderConf {

    @Bean
    public AMQP.Queue queue() {
        return  new AMQP.Queue();
    }
}
