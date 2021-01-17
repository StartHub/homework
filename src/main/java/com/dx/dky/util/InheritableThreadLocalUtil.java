package com.dx.dky.util;

/**
 * @Author dx
 * @Date 2020/12/27 17:59
 * InheritableThreadLocal：同样是JDK rt.jar包中的类，包为java.lang。
 * 它是ThreadLocal的升级类，ThreadLocal在父子线程之间存在传递值的问题。
 * 在多线程和高并发流行的时代，ThreadLocal已经不能胜任线程的本地变量这个工作了。
 */
public class InheritableThreadLocalUtil {

    public static final InheritableThreadLocal<String> THREAD_LOCAL = new InheritableThreadLocal<>();

    //设置线程需要保存的值
    public static void setValue (String str) {
        THREAD_LOCAL.set(str);
    }

    //获取线程中保存的值
    public static String getValue() {
        return THREAD_LOCAL.get();
    }

    //移除线程中保存的值
    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
