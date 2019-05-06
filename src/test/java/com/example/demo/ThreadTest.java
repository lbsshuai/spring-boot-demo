package com.example.demo;

import com.example.demo.dao.test.MyBean;
import com.example.demo.dao.test.MyTask;
import com.example.demo.dao.test.ThreadTestClass;
import com.example.demo.dao.test.thread.Runable1;
import com.example.demo.dao.test.thread.Thread1;
import com.example.demo.dao.test.thread.ThreadCallable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.core.env.Environment;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lbs
 * @dete
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class ThreadTest {

    @Autowired
    private Environment  environment;

    @Value("${spring.thymeleaf.mode}")
    private String mode;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    public void thread1(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));
        for (int i = 0; i < 20; i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目：" + executor.getPoolSize()+ ",队列中等待执行的任务数" +
            executor.getQueue().size() + ",已执行完别的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

    @Test
    public void thread2() {
        //获取当前cpu核数
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);

        //获取本地配置
        System.out.println(mode);
        String port =  environment.getProperty("server.port");
        String mode =  environment.getProperty("spring.thymeleaf.mode");
        System.out.println(port);
        System.out.println(mode);
    }

    @Test
    public void classTest1() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<ThreadTestClass>[] constructors = (Constructor<ThreadTestClass>[]) ThreadTestClass.class.getConstructors();
        Constructor<ThreadTestClass> constructor = constructors[0];
        ThreadTestClass threadTestClass = constructor.newInstance(1, "菲菲", "啦啦");
        System.out.println(threadTestClass);

    }

    @Test
    public void Thread11(){
        Thread1 thread1 = new Thread1();
        Thread1 thread2 = new Thread1();

        thread1.start();
        thread2.start();

    }
    @Test
    public void Runnable11(){
        Runable1 runable1 = new Runable1();
        Thread thread = new Thread(runable1);
        Thread thread1 = new Thread(runable1);
        thread.start();
        thread1.start();
    }

    @Test
    public void Callable11(){
        ThreadCallable threadCallable = new ThreadCallable();
        FutureTask futureTask = new FutureTask(threadCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
    }
}
