package com.dance.east.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Copyright  2018IPTV.
 *
 * @Title: com.dance.east.semaphore.Demo
 * @Project:
 * @Date: 2018-10-15 15:37
 * @Author: Dave.Luo
 * @Description:
 */
public class Demo {

    public void method(Semaphore semaphore) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() +"开始获取进入许可");
        semaphore.acquire();
        System.out.println(Thread.currentThread().getName()+"开始执行------------");
        TimeUnit.SECONDS.sleep(5);
        semaphore.release();
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        Demo demo = new Demo();
        for (int i = 0;i<100;i++){
            new Thread(() -> {
                try {
                    demo.method(semaphore);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
