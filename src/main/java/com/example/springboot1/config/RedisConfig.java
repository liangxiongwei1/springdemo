package com.example.springboot1.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.Collections;

/**
 * @author Lihao
 * @version V1.0
 * @Title: RedisConfig.java
 * @Package com.intellif.community.redis
 * @Description
 * @date 2018 08-30 14:06.
 */
@Configuration
@ConfigurationProperties(prefix = RedisConfig.JEDIS_PREFIX)
public class RedisConfig {

	public static final String JEDIS_PREFIX = "redis";

	private String host;
	private String password;
	private int port;
	private int maxTotal;
	private int maxIdle;
	private boolean testOnBorrow;
	private boolean testOnReturn;
	private int expireSeconds;
	private int timeout = 0;

	@Bean(name="redisClient")
	@ConditionalOnMissingBean(RedisClient.class)
	public RedisClient redisClient() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(maxTotal);
		config.setMaxIdle(maxIdle);
		config.setTestOnBorrow(testOnBorrow);
		config.setTestOnReturn(testOnReturn);

		JedisPool writeJedisPool = new JedisPool(config, host, port, timeout, password);
		JedisShardInfo jedisShardInfo = new JedisShardInfo(host, port);
		jedisShardInfo.setPassword(password);
		ShardedJedisPool readShardedJedisPool = new ShardedJedisPool(config, Collections.singletonList(jedisShardInfo));

		return new RedisClient(readShardedJedisPool, writeJedisPool, expireSeconds);
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public boolean isTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	public int getExpireSeconds() {
		return expireSeconds;
	}

	public void setExpireSeconds(int expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
}
