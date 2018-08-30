package com.dx.dky.config.redis.conf;

import redis.clients.jedis.JedisCluster;

/**
 * RedisCallback
 */
public interface RedisCallback<T> {

    T doInRedis(JedisCluster cluster) throws DataAccessException;
}
