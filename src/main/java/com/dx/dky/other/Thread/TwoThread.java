package com.dx.dky.other.Thread;

/**
 * @Descrintion:
 * @Author: dengxu
 * @Date: Created in 21:31 2018/8/23
 */
public class TwoThread {

    private static boolean flag = false;

    private static int n = 0;

    public static void main(String[] args) {

        final TwoThread t = new TwoThread();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (n < 100){
                    synchronized(t){
                        if(flag){
                            try {
                                t.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                            n++;
                            System.out.println("线程1正在打印：" + n);
                            flag = true;
                            t.notifyAll();

                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (n < 100){
                    synchronized (t){
                        if(!flag){
                            try {
                                t.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                            n += 1;
                            System.out.println("线程2正在打印：" + n);
                            flag = false;
                            t.notifyAll();

                    }
                }
            }
        }).start();
    }

}
