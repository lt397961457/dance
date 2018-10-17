package com.dance.east.Exchenger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * Copyright  2018IPTV.
 *
 * @Title: com.dance.east.Exchenger.Demo
 * @Project:
 * @Date: 2018-10-15 16:08
 * @Author: Dave.Luo
 * @Description:
 */
public class Demo {
    public void a(Exchanger<Integer> exchanger) throws InterruptedException {
        System.out.println("a 线程开始获取数据");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("a 线程获取到数据");

        Integer result = 1111;

        System.out.println("a 等待对比结果");
        Integer otherValue = exchanger.exchange(result);
        System.out.println("a 其他线程的值:"+otherValue);

    }

    public void b(Exchanger<Integer> exchanger) throws InterruptedException {
        System.out.println("b 线程开始获取数据");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("b 线程获取到数据");

        Integer result = 2222;

        System.out.println("b 等待对比结果");
        Integer otherValue = exchanger.exchange(result);
        System.out.println("b 其他线程的值:"+otherValue);

    }

    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();
        Demo demo = new Demo();

        new Thread(() ->{
            try {
                demo.a(exchanger);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                demo.b(exchanger);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}

