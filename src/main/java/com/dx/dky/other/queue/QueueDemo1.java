package com.dx.dky.other.queue;

import com.alibaba.fastjson.JSON;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-01-18 10:43
 **/
public class QueueDemo1 {

    public static void main(String[] args) {

        // 有界阻塞队列
        queueForArrayBlockingQueue();

        // 无界安全队列
        queueForConcurrentLinkedQueue();

    }

    private static void queueForConcurrentLinkedQueue() {

        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        Queue<Integer> queue1 = new LinkedBlockingQueue<>(10);


    }

    private static void queueForArrayBlockingQueue() {

        // 有界阻塞队列
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);

        queue.offer(1);
        queue.offer(1);
        queue.offer(1);
        queue.offer(1);
        queue.offer(1);
//        queue.offer(2);
//        queue.offer(3);
//        queue.offer(4);
//        queue.offer(5);
//        queue.offer(7);
//        queue.add(7);
//        queue.add(6);
//        System.out.println(queue.remove());
//        System.out.println(queue.poll());

////        for (Integer integer : queue) {
        System.out.println(JSON.toJSONString(queue));
////        }
//
//        System.out.println(queue.peek());
//        System.out.println(JSON.toJSONString(queue));
//        queue.offer(5);
//        System.out.println(queue.poll());
//        System.out.println(JSON.toJSONString(queue));

    }
}
