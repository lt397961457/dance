package com.dance.east.automic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright  2018IPTV.
 *
 * @Title: com.dance.east.automic.Demo
 * @Project:
 * @Date: 2018-10-15 17:32
 * @Author: Dave.Luo
 * @Description:
 */
public class Demo {
    private ThreadLocal<Integer>  index = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    public Integer getIndex() {
        int cuurent = index.get();
        int result = cuurent +1;
        index.set(result);
        return result;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        for (int i =0 ;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(demo.getIndex());
                }
            }).start();

        }
    }



}
