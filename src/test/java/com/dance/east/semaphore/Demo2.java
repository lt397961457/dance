package com.dance.east.semaphore;

/**
 * Copyright  2018IPTV.
 *
 * @Title: com.dance.east.semaphore.Demo2
 * @Project:
 * @Date: 2018-10-15 15:59
 * @Author: Dave.Luo
 * @Description:
 */
public class Demo2 {

    static {
        System.out.println("父 static代码块=====");
    }

    {
        System.out.println("父 普通代码块====");
    }
    public Demo2() {
        System.out.println("父 构造");
    }

    public static void main(String[] args) {
        new Sub();
    }
}
class Sub extends Demo2{
    static {
        System.out.println("子 sub static 代码块");
    }
    {
        System.out.println("子 sub 普通代码块");
    }

    public Sub() {
        System.out.println("子 sub 构造");
    }
}
