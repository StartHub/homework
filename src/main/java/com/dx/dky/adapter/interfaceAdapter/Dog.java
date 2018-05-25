package com.dx.dky.adapter.interfaceAdapter;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-04-03 19:22
 **/
public class Dog extends BaseHandler {

    @Override
    public void eat() {
        System.out.println("狗需要人去喂吃饭！！！");;
    }

    @Override
    public void play() {
        System.out.println("狗需要人带着溜圈！！！");;
    }

    @Override
    public void crawl() {
        System.out.println("狗会在地上趴着玩！！！");;
    }
}
