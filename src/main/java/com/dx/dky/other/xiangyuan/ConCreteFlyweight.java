package com.dx.dky.other.xiangyuan;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2019-03-26 16:08
 **/
public class ConCreteFlyweight extends Flyweight {

    @Override
    public void Operation(int ext) {
        System.out.println("具体Flyweight:" + ext);
    }
}
