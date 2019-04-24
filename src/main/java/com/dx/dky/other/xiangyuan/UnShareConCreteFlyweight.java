package com.dx.dky.other.xiangyuan;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2019-03-26 16:10
 **/
public class UnShareConCreteFlyweight extends Flyweight{

    @Override
    public void Operation(int ext) {
        System.out.println("不共享的具体Flyweight:" + ext);
    }
}
