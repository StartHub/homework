package com.dx.dky.other;

/**
 * 类循环依赖
 * Exception in thread "main" java.lang.StackOverflowError
 *
 * @author : dengxu
 * @create 2018-09-14 10:52
 **/
public class CyclicDep {

    public static void main(String[] args) {
        B testb = new B();
        A a = new A(testb);
    }

}

class A {
    public Bproxy b;

    public A(B b) {
        this.b = b;
    }

    public void printB() {
        System.out.println("Ab");
        b.printA();
    }

    public void printA() {
        System.out.println("AA");
    }
}

interface Bproxy{
    void printA();
}

class B implements Bproxy{
    public A a;

    public B() {
        a = new A(this);
    }

    public void printB() {
        System.out.println("BB");
        a.printA();
    }

    @Override
    public void printA() {
        a.printA();
    }
}

