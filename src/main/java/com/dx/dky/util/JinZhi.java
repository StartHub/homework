package com.dx.dky.util;

import java.util.Random;

/**
 * @author : dengxu
 * @create 2019-08-06 16:29
 **/
public class JinZhi {

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(63));
        System.out.println(Integer.toBinaryString(31));
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.toBinaryString(7));

        for (int i = 0; i < 5; i++) {

            int finalI = i;
            new Thread(()->{
                int n = new Random().nextInt(10);
                System.out.println(Thread.currentThread().getName() + ": ==> " + n);
                ThreadLocalUtil.setValue(n);
                System.out.println(Thread.currentThread().getName() + ": setValue ==> " + n);
                try {
                    Thread.sleep(finalI * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int m = (int) ThreadLocalUtil.getValue();
                System.out.println(Thread.currentThread().getName() + ": getValue ==> " + m);
            }).start();
        }

    }
}
