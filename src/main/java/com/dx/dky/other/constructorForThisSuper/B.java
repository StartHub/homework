package com.dx.dky.other.constructorForThisSuper;

/**
 * @Descrintion:
 * @Author: dengxu
 * @Date: Created in 12:19 2018/9/8
 */
public class B extends A {

    public String name;

    public int age = 10;

    B(){
        System.out.println("B 无参构造器、");
    }

    public void say(){
        System.out.println("say: B know!");
    }

    B(String name){
//        super(name);
        System.out.println("B 无参构造器、");
    }

    public static void eat(){
        System.out.println("eat: B 吃屎吧!");
    }

}
