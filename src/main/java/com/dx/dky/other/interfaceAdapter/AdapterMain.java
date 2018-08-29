package com.dx.dky.other.interfaceAdapter;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-04-03 19:24
 **/
public class AdapterMain {

    public static void main(String[] args) {

        /**
         * 接口适配器大意：
         *   在IHandler里面定义了很多方法；
         *   Person、Dog需要实现IHandler中的部分方法，不想实现IHandler之后置空不需要的方法；
         *   此时就使用抽象类BaseAdapter去实现IHandler，override并置空所有方法；
         *   分别使用Person、Dog去继承抽象类BaseAdapter，并重写各自所需要的方法；
         *   此时便实现了最初的本意，Person、Dog实现IHandler中的部分方法。
         */
        IntefaceAdapter();
    }

    private static void IntefaceAdapter() {

        IHandler person = new Person();
        person.eat();
        person.drink();
        person.play();

        IHandler dog = new Dog();
        dog.eat();
        dog.play();
        dog.crawl();
    }

}
