package com.dx.dky.other.aboutinterface;

/**
 * ${DESCRIPTION}
 * 接口
 *  可以定义普通方法，抽象方法, 方法不可以有方法体；
 *  可以定义成员变量；
 *  成员变量可作为静态常量类使用；
 *
 *
 * @author : dengxu
 * @create 2018-04-04 15:52
 **/
public interface Ihandler extends I2Handler{

    String name = "zhangfei";

    Integer age = 22;

    void eat();

    abstract void drink();

//    void jump(){
//
//    }
}
