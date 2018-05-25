package com.dx.dky.proxy.dynamicTest;

import com.dx.dky.proxy.RealSubject;
import com.dx.dky.proxy.Subject;

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

        RealSubject realSubject = new RealSubject();
        Subject sub = (Subject) Proxy.newProxyInstance(
                realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(),
                new DynamicSubject2(realSubject));
        sub.printArgs("张飞");
    }
}
