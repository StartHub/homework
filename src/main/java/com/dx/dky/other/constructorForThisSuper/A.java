package com.dx.dky.other.constructorForThisSuper;

/**
 * @Descrintion:
 * @Author: dengxu
 * @Date: Created in 12:19 2018/9/8
 */
public class A {

    public String name = "name: aaa";

    A(){
        System.out.println("A 无参构造器、");
    }

    A(String name){
        this.name = name;
        System.out.println("A 有参构造器、");
    }

    public void say(){
        System.out.println("say: A know!");
    }

    public static void eat(){
        System.out.println("eat: A 吃屎吧!");
    }

}
