package com.dx.dky.other.proxy.dynamicTest;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Descrintion: 调用处理器
 * @Author: dengxu
 * @Date: Created in 16:51 2017/12/2
 */
public class DynamicSubject2 implements InvocationHandler {

    Object target;

    public DynamicSubject2(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行前，打印入参：" + JSON.toJSONString(args));
        Long time1 = System.currentTimeMillis();
        Object obj = method.invoke(target, args);
        Long time2 = System.currentTimeMillis();
        System.out.println("方法执行后，打印输出：" + JSON.toJSONString(obj));
        System.out.println("方法执行时间：" + (time2 - time1));
        return null;
    }
}
