package com.dx.dky.other.Thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLacthThread implements Runnable {

    private CountDownLatch countDownLatch;

    private Integer num;

    public CountDownLacthThread(CountDownLatch countDownLatch, Integer num){
        this.countDownLatch = countDownLatch;
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("我是第>" + num + "<个！！！");
        countDownLatch.countDown();
    }
}
