package com.dx.dky.other.interfaceAdapter;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-04-03 19:20
 **/
public class Person extends BaseHandler {

    @Override
    public void eat() {
        System.out.println("人会坐着吃饭！！！");;
    }

    @Override
    public void drink() {
        System.out.println("人会自己倒水！！！");;
    }

    @Override
    public void play() {
        System.out.println("人会打篮球呀！！！");;
    }
}
