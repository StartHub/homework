package com.dx.dky.proxy.dynamicTest;

import com.dx.dky.proxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Descrintion: 动态代理实现类，需要实现invocationhandle 创建调用处理器
 * @Author: dengxu
 * @Date: Created in 16:27 2017/12/2
 */
public class DynamicSubject implements InvocationHandler {

    Subject subject;

    public Object getInstance (Subject subject) {
        this.subject = subject;
        Class clazz = subject.getClass();
        Object object = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        return object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("我是链家，我帮别人找房子..");
        //第一个参数是target,也就是被代理类的对象；第二个参数是方法中的参数
        method.invoke(subject, args);
        System.out.println("我是链家，已经找完了..");
        return null;
    }
}
