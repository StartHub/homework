package com.dx.dky.aboutabstract;

/**
 * ${DESCRIPTION}
 *  抽象类
 *      可以定义成员变量；
 *      可以定义成员方法（非抽象方法），但必须要有方法体{}；
 *      可以定义抽象方法；
 *      不能实例化，
 *
 * @author : dengxu
 * @create 2018-04-04 14:56
 **/
public abstract class Animal {

    String name = "Animal";

    Integer age = 20;

    abstract void eat();

    abstract void drink();

    void jump() {
        System.out.println("赶紧跳起来！！！");
    }

}
