package com.dx.dky.config.redis;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Descrintion:
 * @Author: dengxu
 * @Date: Created in 13:50 2018/9/1
 */
public class JedisUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    private static JedisPool jedisPool = null;

    private static volatile Jedis jedis = null;

    public JedisUtil() {
    }

    public static Jedis getJedis() {
        if (jedis == null) {
            synchronized (Jedis.class) {
                if (jedis == null) {
                    jedis = getJedisPool().getResource();
                }
            }
        }
        return jedis;
    }

    public static JedisPool getJedisPool() {
        if (jedisPool == null) {
            synchronized (JedisPool.class) {
                if (jedisPool == null) {
                    jedisPool = applicationContext.getBean(JedisPool.class);
                }
            }
        }
        return jedisPool;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (JedisUtil.applicationContext == null) {
            JedisUtil.applicationContext = applicationContext; //初始化 spring applicationContext
        }
    }
}
