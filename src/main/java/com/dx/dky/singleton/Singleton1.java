package com.dx.dky.singleton;

/**
 * 只适合单线程环境（不好）
 * 注解：Singleton的静态属性singleton中，只有singleton为null的情况下才创建实例，
 *      构建函数私有，确保每次只创建一个，避免重复创建。
 * 缺点：适合在单线程下运行，多线程下如果两个线程同时判断if为null，则会创建两个实例。
 *
 */
public class Singleton1 {

    private static Singleton1 singleton = null;

    private Singleton1() {
    }

    public static Singleton1 getInstance(){
        if(singleton == null){
            singleton = new Singleton1();
        }

        return singleton;
    }

}
