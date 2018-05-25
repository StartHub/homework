package com.dx.dky.aboutinterface;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-04-04 16:00
 **/
public class InterfaceMain {

    public static void main(String[] args) {

        Ihandler ihandler = new BaseHandler();

        ihandler.eat();
        ihandler.drink();
        System.out.println(Ihandler.age);
    }
}
