package com.dx.dky.other.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadSortPrint1 {

    public static void main(String[] args) throws InterruptedException {

        // todo join 有序打印ABC 1
//        Thread thread1 = new Thread(() -> System.out.println("A"));
//        Thread thread2 = new Thread(() -> System.out.println("B"));
//        Thread thread3 = new Thread(() -> System.out.println("C"));
//        thread1.start();
//        thread1.join();
//        thread2.start();
//        thread2.join();
//        thread3.start();
//        thread3.join();


        // todo sleep 有序打印ABC 1
//        Thread thread1 = new Thread(() -> {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("A");
//        });
//        Thread thread2 = new Thread(() -> {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("B");
//        });
//        Thread thread3 = new Thread(() -> {
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("C");
//        });
//        thread3.start();
//        thread1.start();
//        thread2.start();

        // todo newSingleThreadExcutor实现有序打印ABC
        Thread thread1 = new Thread(() -> System.out.println("A"));
        Thread thread2 = new Thread(() -> System.out.println("B"));
        Thread thread3 = new Thread(() -> System.out.println("C"));
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.submit(thread3);
        executorService.shutdown();

    }
}
