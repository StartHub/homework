package com.dx.dky.other.testAbstract;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-09-27 11:29
 **/
public class MainTest {

    public static void main(String[] args) {

        AbstractPayMent payMent = new Payment();
        payMent.invoke("1");

    }
}
