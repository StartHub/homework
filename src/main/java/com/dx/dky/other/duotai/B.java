package com.dx.dky.other.duotai;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2019-03-20 10:59
 **/
public class B extends A{

    public String show(B obj){
        return ("B and B");
    }

    @Override
    public String show(A obj){
        return ("B and A");
    }
}
