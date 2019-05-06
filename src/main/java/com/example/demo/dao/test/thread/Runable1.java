package com.example.demo.dao.test.thread;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * @author lbs
 * @dete
 */
public class Runable1 implements Runnable{

    @Override
    public void run() {
        System.out.println("Runnable run()");
        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName());
    }
}
