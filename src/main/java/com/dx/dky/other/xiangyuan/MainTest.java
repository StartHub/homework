package com.dx.dky.other.xiangyuan;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2019-03-26 16:18
 **/
public class MainTest {

    public static void main(String[] args) {

        int ext = 22;

        FlyweightFactory factory = new FlyweightFactory();

        Flyweight fa = factory.getFlyweight("A");
        fa.Operation(--ext);

        Flyweight fb = factory.getFlyweight("B");
        fb.Operation(--ext);

        Flyweight fc = factory.getFlyweight("C");
        fc.Operation(--ext);

        UnShareConCreteFlyweight unShareConCreteFlyweight = new UnShareConCreteFlyweight();
        unShareConCreteFlyweight.Operation(--ext);
    }

}
