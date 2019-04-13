package com.example.springboot1.config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 推荐使用该客户端
 * Redis Template 客户端基础操作模版<br/>
 * @author Administrator
 */
@SuppressWarnings("unused")
public class RedisClient {

	final private static int DEFAULT_TIME_OUT = 300;

	private ShardedJedisPool readShardedJedisPool;

	private JedisPool writeJedisPool;

	private int seconds;

	public RedisClient(ShardedJedisPool readShardedJedisPool, JedisPool writeJedisPool, int seconds) {
		this.readShardedJedisPool = readShardedJedisPool;
		this.writeJedisPool = writeJedisPool;
		this.seconds = seconds;
	}

	public RedisClient(ShardedJedisPool readShardedJedisPool, JedisPool writeJedisPool) {
		this(readShardedJedisPool, writeJedisPool, 300);
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public void setReadShardedJedisPool(ShardedJedisPool readShardedJedisPool) {
		this.readShardedJedisPool = readShardedJedisPool;
	}

	public void setWriteJedisPool(JedisPool writeJedisPool) {
		this.writeJedisPool = writeJedisPool;
	}

	private <T> T getResult(ShardedRedisExecutor<T> executor){
		T result ;
		if(readShardedJedisPool==null){
			throw new IllegalArgumentException("RedisTemplate getResult exception，shardedJedisPool can not empty or null...");
		}
		ShardedJedis shardedJedis=null;
		try {
			shardedJedis=this.readShardedJedisPool.getResource();
			result = executor.execute(shardedJedis);
		} catch (Throwable e) {
			throw new IllegalStateException("RedisTemplate getResult exception,"+e.getMessage(), e);
		} finally {
			if (shardedJedis != null) {
				shardedJedis.close();
			}
		}
		return result;
	}

	private <T> T getResult(RedisExecutor<T> executor){
		T result;
		if(writeJedisPool==null){
			throw new IllegalArgumentException("RedisTemplate getResult exception ,jedisPool can not empty or null...");
		}
		Jedis jedis=null;
		try {
			jedis=this.writeJedisPool.getResource();
			result = executor.execute(jedis);
		} catch (Throwable e) {
			throw new IllegalStateException("RedisTemplate getResult exception ,"+e.getMessage(), e);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return result;
	}

	public Long del(final String... keys){
		return getResult((RedisExecutor<Long>) jedis -> jedis.del(keys));
	}

	public Long del(final byte[] key){
		return getResult((RedisExecutor<Long>) jedis -> jedis.del(key));
	}

	public Set<String> keys(final String pattern){
		return getResult((RedisExecutor<Set<String>>) jedis -> jedis.keys(pattern));
	}

	public String set(final String key, final String value) {
		return getResult((RedisExecutor<String>) jedis -> jedis.set(key, value));
	}

	public Long setnx(final String key,final String value) {
		return setnx(key, value, true);
	}

	public Long setnx(final String key,final String value,final boolean flushExpire) {
		return getResult((RedisExecutor<Long>) jedis -> {
			long result = jedis.setnx(key, value);
			if (result == 1 && flushExpire) {
				jedis.expire(key, seconds);
			}
			return result;
		});
	}

	/**
	 * 加入新的key-value键值对（Set if Not exists，只在key值不存在的情况下才设置）
	 * @param key key
	 * @param value value
	 * @param secondsNew secondsNew
	 * @return Long
	 */
	public Long setnx(final String key, final String value,final int secondsNew) {
		return getResult((RedisExecutor<Long>) jedis -> {
			long result = jedis.setnx(key, value);
			if (result == 1) {
				jedis.expire(key, secondsNew);
			}
			return result;
		});
	}

	public Long setnx(final byte[] key, final byte[] value,final int secondsNew) {
		return getResult((RedisExecutor<Long>) jedis -> {
			Long result = jedis.setnx(key, value);
			if (result == 1) {
				jedis.expire(key, secondsNew);
			}
			return result;
		});
	}

	public String set(final String key, final String value,final String nxxx) {
		return getResult((RedisExecutor<String>) jedis -> jedis.set(key, value,nxxx));
	}

	public String set(final String key, final String value,final String nxxx, final int secondsNew) {
		return getResult((RedisExecutor<String>) jedis -> {
			String result = jedis.set(key, value,nxxx);
			if ("OK".equalsIgnoreCase(result)) {
				jedis.expire(key, secondsNew);
			}
			return result;
		});
	}

    /**
     * 向指定key的set集合中加入新成员
     * @param key key
     * @param members members
     * @return Boolean
     */
	public Boolean sadd(final String key, final Iterable<String> members) {
		return sadd(key, members, true);
	}

	/**
	 * 向指定key的set集合中加入新成员
	 * @param key key
	 * @param members members
	 * @param flushExpire flushExpire
	 * @return Boolean
	 */
	public Boolean sadd(final String key, final Iterable<String> members,boolean flushExpire) {
		return getResult((RedisExecutor<Boolean>) jedis -> {
			for (String member : members) {
				jedis.sadd(key, member);
			}
			if (flushExpire){
				jedis.expire(key, seconds);
			}
			return true;
		});
	}

	/**
	 * 从指定key的set集合中删除成员
	 * @param key key
	 * @param members members
	 * @return Boolean
	 */
	public Boolean srem(final String key, final Iterable<String> members) {
		return getResult((RedisExecutor<Boolean>) jedis -> {
			for (String member : members) {
				jedis.srem(key, member);
			}
			return true;
		});
	}

    /**
     * 判断某个成员是否属于指定key的set集合
     * @param key key
     * @param member member
     * @return boolean
     */
    public Boolean sismember(final String key, final String member) {
		return getResult((RedisExecutor<Boolean>) jedis -> jedis.sismember(key, member));
	}

	/**
	 * 重置缓存过期时间（默认时间）
	 * @param key key
	 * @return Long
	 */
	public Long expire(final String key) {
		return getResult((RedisExecutor<Long>) jedis -> jedis.expire(key, seconds));
	}

	public Boolean expire(final String[] keys) {
		return getResult((RedisExecutor<Boolean>) jedis -> {
			boolean flag =true;
			for(final String key : keys){
				flag = flag && jedis.expire(key, seconds)>0;
			}
			return flag;
		});
	}

	/**
	 * 重置缓存过期时间（自定义时间）
	 * @param key key
	 * @return Long
	 */
	public Long expire(final String key,final int seconds) {
		return getResult((RedisExecutor<Long>) jedis -> jedis.expire(key,seconds));
	}

	public Boolean exists(final byte[] key) {
		return getResult((RedisExecutor<Boolean>) jedis -> jedis.exists(key));
	}

	public Boolean exists(final String key) {
		return getResult((RedisExecutor<Boolean>) jedis -> jedis.exists(key));
	}

	public Long hset(final byte[] key, final byte[] field, final byte[] value){
		return getResult((RedisExecutor<Long>) jedis -> jedis.hset(key, field, value));
	}

	public Long hset(final String key, final String field, final String value){
		return getResult((RedisExecutor<Long>) jedis -> jedis.hset(key, field, value));
	}

	public String hmset(final String key, final Map<String,String> hash){
		return getResult((RedisExecutor<String>) jedis -> jedis.hmset(key, hash));
	}

	public byte[] hget(final byte[] key, final byte[] field){
		return getResult((ShardedRedisExecutor<byte[]>) shardedJedis -> shardedJedis.hget(key, field));
	}

	public String hget(final String key, final String field){
		return getResult((ShardedRedisExecutor<String>) shardedJedis -> shardedJedis.hget(key, field));
	}

    public String get(final String key){
        return getResult((ShardedRedisExecutor<String>) shardedJedis -> shardedJedis.get(key));
    }

	public byte[] get(final byte[] key){
		return getResult((ShardedRedisExecutor<byte[]>) shardedJedis -> shardedJedis.get(key));
	}

	public Map<String, String> hgetAll(final String key){
		return getResult((ShardedRedisExecutor<Map<String, String>>) shardedJedis -> shardedJedis.hgetAll(key));
	}

	public Map<String, Map<String,String>> hgetAllKeys(final String[] keys){
		return getResult((ShardedRedisExecutor<Map<String, Map<String, String>>>) shardedJedis -> {
			Map<String,Map<String,String>> allKeysMap=new HashMap<>();
			for (String key:keys){
				allKeysMap.put(key, shardedJedis.hgetAll(key));
			}
			return allKeysMap;
		});
	}

	public Long hdel(final byte[] key, final byte[] field){
		return getResult((RedisExecutor<Long>) jedis -> jedis.hdel(key, field));
	}

	public Long hdel(final String key, final String field){
		return getResult((RedisExecutor<Long>) jedis -> jedis.hdel(key, field));
	}
	
	public Long hlen(final String key){
		return getResult((ShardedRedisExecutor<Long>) shardedJedis -> shardedJedis.hlen(key));
	}
	
	public Set<String> hkeys(final String key){
		return getResult((ShardedRedisExecutor<Set<String>>) shardedJedis -> shardedJedis.hkeys(key));
	}
	
	public List<String> hmget(final String key, final String[] fields){
		return getResult((ShardedRedisExecutor<List<String>>) shardedJedis -> shardedJedis.hmget(key, fields));
	}

	public Long lpush(final byte[] key, final byte[] value){
		return getResult((RedisExecutor<Long>) jedis -> jedis.lpush(key, value));
	}

	public List<byte[]> brpop(final int timeout,final byte[] key){
		return getResult((RedisExecutor<List<byte[]>>) jedis -> jedis.brpop(timeout, key));
	}

	public Long incr(final String key){
		return getResult((RedisExecutor<Long>) jedis -> jedis.incr(key));
	}

	/**
	 * 自增
	 * @param key
	 * @param expireSecond
	 * @return
	 */
	public Long autoIncrement(final String key,final int expireSecond) {
		return getResult((RedisExecutor<Long>) jedis -> {
			if (setnx(key,"1") > 0){
				if (expireSecond > 0){
					jedis.expire(key, expireSecond);
				}else {
					jedis.expire(key, DEFAULT_TIME_OUT);
				}
				return 1L;
			}else{
				return jedis.incr(key);
			}
		});
	}
}
