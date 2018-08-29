package com.dx.dky.other.singleton;

/**
 * 注解：在Singleton1的情况下，添加了同步锁，当同时有两个线程想创建实例的情况下，
 *      只会有一个线程拿到锁，另外一个线程等待，直到第一个线程释放锁，此时实例已经创建。
 *
 * 缺点：在多线程的情况下，每次都有另外一个线程试图获取锁，加同步锁耗费性能，不好。
 */
public class Singleton2 {

    private static Singleton2 singleton2 = null;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance(){
        if(singleton2 == null){
            singleton2 = new Singleton2();
        }

        return singleton2;
    }


}
