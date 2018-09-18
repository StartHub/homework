package com.dx.dky.other.singleton;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-09-18 9:18
 **/
public class Singleton7Type {

    // 懒汉模式
    static class Singleton1{

        private static Singleton1 singleton1;

        private Singleton1(){}

        public static Singleton1 getInstance(){
            if(singleton1 == null){
                singleton1 = new Singleton1();
            }
            return singleton1;
        }
    }




}
