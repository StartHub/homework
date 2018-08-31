package com.dx.dky.other.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-08-31 15:14
 **/
public class DelayQueueDemo {

//    private volatile static DelayQueue<OrderDelay> queue;

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("00000001");
        list.add("00000002");
        list.add("00000003");
        list.add("00000004");
        list.add("00000005");

//        queue = new DelayQueue<OrderDelay>();
        long start = System.currentTimeMillis();

        OrderDelayWork orderDelayWork = new OrderDelayWork();


//        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();

        new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                orderDelayWork.put(new OrderDelay(list.get(i), TimeUnit.NANOSECONDS.convert(new Random().nextInt(10) + i, TimeUnit.SECONDS)));
            }
        }

        ).start();

//        new Thread(() -> {
//            for (; ; ) {
//
//                System.out.println("当前时间====>" + LocalDateTime.now());
//                try {
//                    if (!queue.isEmpty()) {
//                        System.out.println(queue.size());
//                        queue.take().print();
//                        System.out.println("After " + (System.currentTimeMillis() - start) + " MilliSeconds");
//                    } else {
//                        Thread.sleep(3000);
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();


    }
}
