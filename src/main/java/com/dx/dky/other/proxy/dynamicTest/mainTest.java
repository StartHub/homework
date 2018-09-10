package com.dx.dky.other.proxy.dynamicTest;

import com.dx.dky.other.proxy.RealSubject;
import com.dx.dky.other.proxy.Subject;

import java.lang.reflect.Proxy;

/**
 * @Descrintion:
 * @Author: dengxu
 * @Date: Created in 16:35 2017/12/2
 */
public class mainTest {

    public static void main(String[] args) {

//        Subject subject = (Subject) new DynamicSubject().getInstance(new RealSubject());
//        subject.doSomething();

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

//        RealSubject realSubject = new RealSubject();
//        Subject sub = (Subject) Proxy.newProxyInstance(
//                realSubject.getClass().getClassLoader(),
//                realSubject.getClass().getInterfaces(),
//                new DynamicSubject2(realSubject));
//        sub.printArgs("张飞");

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        Subject sub2 = DynamicSubject3.newMapperProxy(Subject.class);
        sub2.printArgs("lisi");

    }
}
