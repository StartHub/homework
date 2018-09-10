package com.dx.dky.other.constructorForThisSuper;

/**
 * @Descrintion:
 * @Author: dengxu
 * @Date: Created in 12:16 2018/9/8
 */
public class TestExtend {

    public static void main(String[] args) {
        B b = new B("111");
        System.out.println(b.name);
        b.say();
        b.eat();

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        A a = new B("222");
        System.out.println(a.name);
        a.say();
        a.eat();
    }

}
