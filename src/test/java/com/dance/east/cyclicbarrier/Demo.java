package com.dance.east.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Copyright  2018IPTV.
 *
 * @Title: com.dance.east.cyclicbarrier.Demo
 * @Project:
 * @Date: 2018-10-15 15:07
 * @Author: Dave.Luo
 * @Description:
 */
public class Demo {
    public void meeting(CyclicBarrier cyclicBarrier) throws InterruptedException, BrokenBarrierException {
        Random random = new Random();
        System.out.println(Thread.currentThread().getName()+"开始出发，准备到会议室。。。");
        Thread.sleep(random.nextInt(5000));
        System.out.println(Thread.currentThread().getName()+"到达会议室。");
        cyclicBarrier.await();
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10,() ->{
            System.out.println("人员到齐可以开会了");
        });

        for (int i =0;i<10;i++){
            new Thread(() -> {
                try {
                    demo.meeting(cyclicBarrier);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        new Thread(() -> {
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("当前等待的线程数："+cyclicBarrier.getNumberWaiting());
                    System.out.println("isBroken:"+cyclicBarrier.isBroken());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
