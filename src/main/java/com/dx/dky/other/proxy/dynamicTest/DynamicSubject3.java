package com.dx.dky.other.proxy.dynamicTest;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Descrintion: 调用处理器
 * @Author: dengxu
 * @Date: Created in 16:51 2017/12/2
 */
public class DynamicSubject3 implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行前，打印入参：" + JSON.toJSONString(args));
        Long time1 = System.currentTimeMillis();
//        Object obj = method.invoke(target, args);
        System.out.println("No Invoke Method, cannt find would execute method？ do you konw?");
        Long time2 = System.currentTimeMillis();
//        System.out.println("方法执行后，打印输出：" + JSON.toJSONString(obj));
        System.out.println("方法执行后，打印输出：" + JSON.toJSONString(""));
        System.out.println("方法执行时间：" + (time2 - time1));
        return null;
    }

    public static <T> T newMapperProxy(Class<T> mapperInterface) {
        ClassLoader classLoader = mapperInterface.getClassLoader();
        Class<?>[] interfaces = new Class[]{mapperInterface};
        DynamicSubject3 proxy = new DynamicSubject3();
        return (T) Proxy.newProxyInstance(classLoader, interfaces, proxy);
    }
}
