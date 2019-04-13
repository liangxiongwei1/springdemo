package com.example.springboot1.config;

import redis.clients.jedis.Jedis;

/**
 * Redis执行接口
 * @author daisha
 */
public interface RedisExecutor<T>{

	/**
	 * xxx
	 * @param jedis
	 * @return
	 * @throws Exception
	 */
	T execute(Jedis jedis) throws Exception;
}
