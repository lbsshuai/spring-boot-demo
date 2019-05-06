package com.example.demo.dao.test;

import org.apache.poi.ss.formula.functions.T;
import sun.nio.ch.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lbs
 * @dete
 */
public class ThreadTest {
    public static void main(String[] args) {
        //ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));
       //创建一个缓冲池 缓冲池大小为Integer.MAX_VALUE
        //ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        //创建一个容量为1的缓冲池
        //ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newSingleThreadExecutor();
        //创建一个固定大小的缓冲池
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            if(i ==10)
                try {
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.println("线程池中线程数目：" + executor.getPoolSize()+ ",队列中等待执行的任务数" +
                    executor.getQueue().size() + ",已执行完别的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();

    }
}
