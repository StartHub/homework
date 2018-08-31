package com.dx.dky.other.queue;

import java.time.LocalDateTime;
import java.util.concurrent.DelayQueue;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-08-31 15:57
 **/
public class OrderDelayWork {

    private Thread daemonThread;

    private volatile static DelayQueue<OrderDelay> delayQueue = new DelayQueue<>();

    long start = System.currentTimeMillis();

    public OrderDelayWork() {
        Runnable daemonTask = new Runnable() {
            @Override
            public void run() {
                orderDelaydelete();
            }
        };

        daemonThread = new Thread(daemonTask);
        daemonThread.setDaemon(true);
        daemonThread.setName("Order Delay delete Daemon");
        daemonThread.start();
    }

    private void orderDelaydelete() {

        System.out.println("Order Delay delete Daemon Start……");

        for (;;) {
            System.out.println("当前时间====>" + LocalDateTime.now());
            try {
                if (!delayQueue.isEmpty()) {
                    System.out.println(delayQueue.size());
                    delayQueue.take().print();
                    System.out.println("After " + (System.currentTimeMillis() - start) + " MilliSeconds");
                } else {
                    System.out.println("当前时间====>" + LocalDateTime.now() + "<====让我睡3秒……");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

        System.out.println("Order Delay delete Daemon End……");
    }

    public void put(OrderDelay orderDelay){

        if(orderDelay instanceof OrderDelay){
            delayQueue.put(orderDelay);
        }
    }

//    public static void main(String[] args) {
//
//        OrderDelay orderDelay = null;
//
//        if(orderDelay instanceof OrderDelay){
//            System.out.println(true);
//        }else {
//            System.out.println(false);
//        }
//    }

}
