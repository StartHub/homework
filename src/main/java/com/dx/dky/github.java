package com.dx.dky;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Descrintion:
 * @Author: dengxu
 * @Date: Created in 23:55 2017/12/4
 */
public class github {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 1.创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //*****************************Callable Start***********************************************
        List<Future<Integer>> futureList = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            Future<Integer> future = executorService.submit(new Callable<Integer>() {

                int sum = 0;

                @Override
                public Integer call() throws Exception {

                    for (int i = 0; i <= 100; i++) {
                        sum += i;
                    }

                    return sum;
                }
            });

            futureList.add(future);
        }

        //*****************************Callable Start***********************************************

        //*****************************Runnable Start***********************************************
        // 2.为线程池中的线程分配任务
//        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
//
//        // 2.1 以下是线程池中的一个线程执行
////        executorService.submit(threadPoolDemo);
//
//        // 2.2 以下是线程池中的10个线程执行
//        for (int i = 0; i <= 10; i++) {
//            executorService.submit(threadPoolDemo);
//        }
        //******************************Runnable End**********************************************

        // 3.关闭线程池
        executorService.shutdown();

        for (Future f : futureList){
            System.out.println(f.get());
        }

    }
}

class ThreadPoolDemo implements Runnable {

    private int i = 0;

    @Override
    public void run() {

        while (i < 30) {
            System.out.println(Thread.currentThread().getName() + ":" + i++);
        }
    }
}
