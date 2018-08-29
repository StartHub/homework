package com.dx.dky.other.proxy;

/**
 * @Descrintion: 静态代理实现类（真实角色），业务真实实现类
 * @Author: dengxu
 * @Date: Created in 16:09 2017/12/2
 */
public class RealSubject implements Subject {

    @Override
    public void doSomething() {
        System.out.println("真实角色");
    }

    @Override
    public String printArgs(String uname) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "My name is " + uname;
    }
}
