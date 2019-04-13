package com.example.springboot1.config;

import redis.clients.jedis.ShardedJedis;

/**
 * Redis集群执行接口
 * @author daisha
 */
public interface ShardedRedisExecutor<T> {

	/**
	 * xxx
	 * @param shardedJedis
	 * @return
	 * @throws Exception
	 */
	T execute(ShardedJedis shardedJedis) throws Exception;
}
