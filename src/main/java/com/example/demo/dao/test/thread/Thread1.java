package com.example.demo.dao.test.thread;

/**
 * @author lbs
 * @dete
 */
public class Thread1 extends Thread{

    public void run(){
        System.out.println("Thread1 run()");
        System.out.println(Thread.currentThread().getId());
    }

}
