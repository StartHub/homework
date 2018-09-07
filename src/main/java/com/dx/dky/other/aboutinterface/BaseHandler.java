package com.dx.dky.other.aboutinterface;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 * 接口实现类
 *  必须实现其接口中的所有方法，成员方法以及抽象方法；
 *
 * @author : dengxu
 * @create 2018-04-04 15:56
 **/
public class BaseHandler implements Ihandler {

    @Override
    public void eat() {
        System.out.println("【成员方法】我吃的太多了！！！");
    }

    @Override
    public void drink() {
        System.out.println("【抽象方法】我喝的太多了！！！");
    }

    @Override
    public void play() {

    }

    @Override
    public void eat(String name, int age) {

        String a = "";

        List list = new ArrayList();
    }

    @Override
    public void eat(int age, String name) {

    }
}
