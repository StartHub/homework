package com.dx.dky.aboutextend;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-04-04 17:49
 **/
public class ClassB extends ClassA {

    @Override
    public String whoAmi(){
        return "I am ClassB";
    }

    public String ClassBMethod(){
        return "ClassA Only Method";
    }
}
