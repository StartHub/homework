package com.dx.dky.singleton;

/**
 * 静态内部类
 * 定义一个私有的内部类，在第一次用这个嵌套类时，会创建一个实例。
 */
public class Singleton5 {

    public Singleton5() {

    }

    private static class SingletonHolder {
        private final static Singleton5 instance = new Singleton5();
        static {
            System.out.println("静态内部类实例化");
        }
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.instance;
    }
}