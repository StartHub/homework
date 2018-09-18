package com.dx.dky.other.Thread;

import java.util.concurrent.CountDownLatch;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-09-16 14:12
 **/
public class CountDownLatchTest{


    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 1; i<= 4; i++){
            CountDownLacthThread countDownLacthThread = new CountDownLacthThread(countDownLatch, i);
            Thread thread = new Thread(countDownLacthThread);
            thread.start();
        }
        countDownLatch.await();
        System.out.println("我已经完成了！！！");
    }

}

