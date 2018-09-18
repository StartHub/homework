package com.dx.dky.other.singleton;

/**
 * 当实例为null的时候，需要获取同步锁，去创建实例，当实例存在，无需试图加锁。
 *  第一个null判断，如果有实例直接返回，提升效率；
 *  第二个null判断，如果实例不存在，再去实例化；
 * 缺点：双重判断，复杂，容易出错。
 */
public class Singleton3 {

    private static Singleton3 singleton3 = null;

    private Singleton3(){}

    public static Singleton3 getInstance(){

        if(singleton3 == null){
            synchronized (Singleton3.class){
                if(singleton3 == null){
                    singleton3 = new Singleton3();
                }
            }
        }

        return singleton3;
    }
}
