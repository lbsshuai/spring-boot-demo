package com.example.demo.controller.thred;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 线程MQ
 * @author lbs
 * @date 2019/12/5
 */
public class MqThred extends Thread{

    private Integer aa = 1;
    @Override
    public void run() {
        addOne(aa);
    }

    public void addOne(Integer aa) {
        while (aa <100){
            aa++;
            System.out.println(aa);
        }

    }
}
