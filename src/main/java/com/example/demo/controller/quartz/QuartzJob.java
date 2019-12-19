package com.example.demo.controller.quartz;

import com.example.demo.controller.mq.content.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 注解类 定时操作
 * @author lbs
 * @date 2019/9/24
 */
@Component
public class QuartzJob {

    @Autowired
    private HelloSender helloSender;

    /*@Scheduled(cron = "0 0/1 * * * ?")*/
    @Scheduled(cron = "${MQ_QUARTZ_JOB}")
    public void MqQuartzJob() {
        helloSender.send("shuai", "MQ定时任务JOB");
    }
}
