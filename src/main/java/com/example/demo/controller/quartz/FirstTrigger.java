package com.example.demo.controller.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 无注解定时任务
 * @author lbs
 * @date 2019/5/9
 */
public class FirstTrigger {

    public static void main(String[] args) throws SchedulerException {
        System.out.println("执行触发器程序");
        //创建Job对象
        JobDetail job1 = JobBuilder.newJob(HelloJob.class)
                .withIdentity("我的第一个任务", "group1").build();

        //创建触发器
        Trigger trigger1 = TriggerBuilder
                .newTrigger()
                .withIdentity("我的第一个触发器")
                .withSchedule(
                        /*SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5).repeatForever()*/
                        CronScheduleBuilder.cronSchedule("0 23 15 * * ?")
                ).build();

        //创建调度：调度类将“工作”和“触发器”结合到一起，并执行它。
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.scheduleJob(job1, trigger1);
        scheduler.start();
    }
}
