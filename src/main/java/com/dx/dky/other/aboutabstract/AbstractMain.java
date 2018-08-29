package com.dx.dky.other.aboutabstract;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-04-04 15:18
 **/
public class AbstractMain {


    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.eat();
//
//        dog.jump();
//
//        System.out.println(dog.age);
//        System.out.println();
//
//        BigDog bigDog = new BigDog();
//        bigDog.jump();


        int a = 128;
        Integer b = 128;
        Integer c = 128;

        Integer d = new Integer(124);
        Integer e = new Integer(124);
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(d == e);
    }
}
