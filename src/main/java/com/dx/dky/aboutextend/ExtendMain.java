package com.dx.dky.aboutextend;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-04-04 17:50
 **/
public class ExtendMain {

    public static void main(String[] args) {

        ClassA obj1 = new ClassA();
        ClassB obj2 = new ClassB();
        ClassA obj3 = new ClassB();

        System.out.println(obj1.whoAmi());
        System.out.println(obj2.whoAmi());
        System.out.println(obj3.whoAmi());


    }
}

class A {

    public String show(D obj) {
        return ("A adn D");
    }

    public String show(A obj) {
        return ("A and A");
    }

    public final void aVoid() {
        System.out.println("A");
    }
}

class B extends A {

    public String show(B obj) {
        return ("B and B");
    }

    @Override
    public String show(A obj) {
        return ("B and A");
    }

    public static void main(String[] args) {
        B b = new B();
        b.aVoid();
    }
}

class C extends B {
}

class D extends B {
}

class Test {
    public static void main(String[] args) {

        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println(a1.show(b));
        System.out.println(a1.show(c));
        System.out.println(a1.show(d));

        System.out.println(a2.show(b));
        System.out.println(a2.show(c));
        System.out.println(a2.show(d));

        System.out.println(b.show(b));
        System.out.println(b.show(c));
        System.out.println(b.show(d));
    }
}
