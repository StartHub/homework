package com.dx.dky.other.proxy;

/**
 * @Descrintion: 静态代理接口类（抽象角色）
 * @Author: dengxu
 * @Date: Created in 16:08 2017/12/2
 */
public interface Subject {
    public void doSomething();

    String printArgs(String uname);
}
