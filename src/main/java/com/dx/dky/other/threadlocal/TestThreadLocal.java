package com.dx.dky.other.threadlocal;

public class TestThreadLocal {

    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
        ThreadLocal<String> threadLocal3 = new ThreadLocal<>();

        System.out.println(threadLocal);

        threadLocal.set("zhangsan");
        threadLocal2.set("lisi");
        threadLocal3.set("wangwu");

        System.out.println(threadLocal2.get());
        System.out.println(threadLocal.get());
        System.out.println(threadLocal3.get());

    }
}
