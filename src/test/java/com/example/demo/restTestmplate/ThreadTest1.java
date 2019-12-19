package com.example.demo.restTestmplate;

/**
 * @author lbs
 * @date 2019/12/17
 */
public class ThreadTest1 implements Runnable {

    private Integer aa = 0;

    @Override
    public void run() {
        while (true) {
            try {
                aa++;
                System.out.println(aa);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
