package com.dx.dky.annotation;



import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface RequestNum {

	/** 
     * 允许访问的次数，默认值MAX_VALUE 2147483647
     */  
    int count() default Integer.MAX_VALUE;  
  
    /**
     * 时间段，单位为毫秒，默认值一分钟 
     */  
    long time() default 60000;  
}
