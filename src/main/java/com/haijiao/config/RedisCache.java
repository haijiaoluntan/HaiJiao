/*
package com.haijiao.config;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

*/
/**
 * 将 Redis 作为 mybatis 的二级缓存
 *
 *//*

public class RedisCache implements Cache {
  private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

  private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  private final String id; // cache instance id
  private RedisTemplate redisTemplate;

  private static final long EXPIRE_TIME_IN_MINUTES = 30; // redis过期时间

  public RedisCache(String id) {
    if (id == null) {
      throw new IllegalArgumentException("缓存实例需要一个id");
    }
    this.id = id;
  }

  @Override
  public String getId() {
    return id;
  }

  */
/**
   * Put query result to redis
   *
   * @param key
   * @param value
   *//*

  @Override
  public void putObject(Object key, Object value) {
    try {
      RedisTemplate redisTemplate = getRedisTemplate();
      ValueOperations opsForValue = redisTemplate.opsForValue();
      opsForValue.set(key, value, EXPIRE_TIME_IN_MINUTES, TimeUnit.MINUTES);
      logger.debug("放查询结果到redis");
    } catch (Throwable t) {
      logger.error("reids 放入失败", t);
    }
  }

  */
/**
   * Get cached query result from redis
   *
   * @param key
   * @return
   *//*

  @Override
  public Object getObject(Object key) {
    try {
      RedisTemplate redisTemplate = getRedisTemplate();
      ValueOperations opsForValue = redisTemplate.opsForValue();
      logger.debug("从redis缓存查询结果");
      return opsForValue.get(key);
    } catch (Throwable t) {
      logger.error("redis查询失败，失败转移到db", t);
      return null;
    }
  }

  */
/**
   * Remove cached query result from redis
   *
   * @param key
   * @return
   *//*

  @Override
  @SuppressWarnings("unchecked")
  public Object removeObject(Object key) {
    try {
      RedisTemplate redisTemplate = getRedisTemplate();
      redisTemplate.delete(key);
      logger.debug("删除redis缓存");
    } catch (Throwable t) {
      logger.error("redis删除失败", t);
    }
    return null;
  }

  */
/**
   * Clears this cache instance
   *//*

  @Override
  public void clear() {
    RedisTemplate redisTemplate = getRedisTemplate();
    redisTemplate.execute((RedisCallback) connection -> {
      connection.flushDb();
      return null;
    });
    logger.debug("清除所有redis缓存查询的结果");
  }

  */
/**
   * This method is not used
   *
   * @return
   *//*

  @Override
  public int getSize() {
    return 0;
  }

  @Override
  public ReadWriteLock getReadWriteLock() {
    return readWriteLock;
  }

  private RedisTemplate getRedisTemplate() {
    if (redisTemplate == null) {
      redisTemplate = ApplicationContextHolder.getBean("redisTemplate");
    }
    return redisTemplate;
  }

}
*/
