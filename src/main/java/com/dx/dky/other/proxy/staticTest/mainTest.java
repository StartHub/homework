package com.dx.dky.other.proxy.staticTest;

import com.dx.dky.other.proxy.Subject;

/**
 * @Descrintion: 静态代理测试类
 * @Author: dengxu
 * @Date: Created in 16:19 2017/12/2
 */
public class mainTest {

    public static void main(String[] args) {
        Subject subject = new ProxySubject();
        subject.doSomething();
    }
}
