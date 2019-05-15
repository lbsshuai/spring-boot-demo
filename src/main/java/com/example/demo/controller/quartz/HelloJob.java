package com.example.demo.controller.quartz;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 定义Job任务
 * @author lbs
 * @date 2019/5/9
 */
public class HelloJob implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("执行job任务 hello word");
    }

}
