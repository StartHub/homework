package com.dx.dky.util;

/**
 * @Author dx
 * @Date 2020/12/27 17:59
 * ThreadLocal：是JDK rt.jar包中的类，包为java.lang。
 * 它的作用是给线程提供一个本地变量，当线程消失的时候，所有的本地示例都会被回收。
 */
public class ThreadLocalUtil {

    public static final ThreadLocal<Object> THREAD_LOCAL = new ThreadLocal<>();

    //设置线程需要保存的值
    public static void setValue (Object str) {
        THREAD_LOCAL.set(str);
    }

    //获取线程中保存的值
    public static Object getValue() {
        return THREAD_LOCAL.get();
    }

    //移除线程中保存的值
    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
