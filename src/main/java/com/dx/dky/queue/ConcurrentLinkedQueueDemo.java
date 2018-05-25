package com.dx.dky.queue;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-01-18 15:56
 **/
public class ConcurrentLinkedQueueDemo {

    private static Queue<String> queue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {

        new MyThread("dx1").start();
        new MyThread("dx2").start();
    }

    private static class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {

            int i = 0 ;
            while (i++ < 6) {
                String val = Thread.currentThread().getName() + "-" + i;
                queue.offer(val);
                printAll();
            }
        }

        private void printAll() {
            String value;
            Iterator iterator = queue.iterator();
            while (iterator.hasNext()) {
                value = (String) iterator.next();
                System.out.print(value + ", ");
            }

            System.out.println();
        }
    }
}
