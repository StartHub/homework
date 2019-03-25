package com.dx.dky.other.aboutextend;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2019-03-25 9:33
 **/
public abstract class Person {

    private String name;

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
