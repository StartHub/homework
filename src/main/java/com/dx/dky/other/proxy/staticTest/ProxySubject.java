package com.dx.dky.other.proxy.staticTest;

import com.dx.dky.other.proxy.RealSubject;
import com.dx.dky.other.proxy.Subject;

/**
 * @Descrintion: 代理角色实现类，持有真实角色的引用
 * @Author: dengxu
 * @Date: Created in 16:17 2017/12/2
 */
public class ProxySubject implements Subject {

    Subject subject = new RealSubject();

    @Override
    public void doSomething() {
        subject.doSomething();
    }

    @Override
    public String printArgs(String uname) {
        return null;
    }
}
