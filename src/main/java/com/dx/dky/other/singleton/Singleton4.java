package com.dx.dky.other.singleton;

/**
 * 饿汉模式，初始化就创建实例，耗费内存。
 */
public class Singleton4 {

    private static Singleton4 singleton4 = new Singleton4();

    private Singleton4(){}

    public static Singleton4 getInstance(){
        return singleton4;
    }
}
