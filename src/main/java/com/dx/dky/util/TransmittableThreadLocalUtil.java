//package com.dx.dky.util;
//
///**
// * @Author dx
// * @Date 2020/12/27 18:00
// * TransmittableThreadLocal：简称TTL，是阿里巴巴团队提供的一个框架。
// * 主要是解决InheritableThreadLocal在线程池情况，不能使用父线程中ThreadLocal中的值。
// */
//public class TransmittableThreadLocalUtil {
//
//    public static final TransmittableThreadLocal<String> THREAD_LOCAL = new TransmittableThreadLocal<>();
//
//    //设置线程需要保存的值
//    public static void setValue (String str) {
//        THREAD_LOCAL.set(str);
//    }
//
//    //获取线程中保存的值
//    public static String getValue() {
//        return THREAD_LOCAL.get();
//    }
//
//    //移除线程中保存的值
//    public static void remove() {
//        THREAD_LOCAL.remove();
//    }
//}
