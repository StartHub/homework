package com.dx.dky.other.aboutabstract;

/**
 * ${DESCRIPTION}
 *  具体类继承抽象类
 *      必须实现其抽象方法；
 *
 * @author : dengxu
 * @create 2018-04-04 14:58
 **/
public class Dog extends Animal {

    Integer age = 30;

    @Override
    void eat() {
        System.out.println("开始吃大餐了……");
    }

    @Override
    void drink() {
        System.out.println("开始喝饮料了……");
    }

    @Override
    void jump() {
        super.jump();
    }
}
