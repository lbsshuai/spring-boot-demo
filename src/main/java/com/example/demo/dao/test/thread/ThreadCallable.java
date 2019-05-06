package com.example.demo.dao.test.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Callable;

/**
 * @author lbs
 * @dete
 */
public class ThreadCallable implements Callable {

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable call()");

        return 1;
    }
}
