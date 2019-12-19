package com.example.demo.controller.thred;

/**
 * @author lbs
 * @date 2019/12/5
 */
public class ThredTestMq {

    public static void main(String[] args) {
        MqThred mqThred1 = null;
        for(int i = 0; i < 100; i++) {
            mqThred1 = new MqThred();
            mqThred1.start();
        }

    }
}
