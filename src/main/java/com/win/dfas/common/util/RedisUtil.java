package com.win.dfas.common.util;

import java.util.Collections;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * 包名称：com.example.redis
 * 类名称：RedisUtil
 * 类描述：redis操作工具类
 * 创建人：@author wanglei
 * 创建时间：2019/5/28/16:01
 */
@Component
public final class RedisUtil {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 删除缓存
     * @param key 可以传一个值 或多个
     */
    public long del(String... key) {
        if ((key != null) && (key.length > 0)) {
            if (key.length == 1) {
                if(redisTemplate.delete(key[0])){
                    return 1;
                }else{
                    return 0;
                }
            } else {
                return  redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
        return 0;
    }

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    public Boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 指定缓存失效时间
     * @param key 键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(String key, long time) {
        if (time > 0) {
            redisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
        return true;
    }

    /**
     * 普通缓存获取
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        return (key == null) ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入并设置时间
     * @param key 键
     * @param value 值
     * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public boolean set(String key, Object value, long time) {
        if (time > 0) {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        } else {
            redisTemplate.opsForValue().set(key, value, 10, TimeUnit.SECONDS);
        }
        return true;
    }

    public static final String LOCK_PREFIX = "redis_lock";
    public static final int LOCK_EXPIRE = 1000*10; // ms
    private static final Long RELEASE_SUCCESS = 1L;
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "EX";
    private static final String RELEASE_LOCK_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

    /**
     *  最终加强分布式锁
     *
     * @param key key值
     * @return 是否获取到
     */
    public boolean lock(String key){
        String lock = LOCK_PREFIX + key;
        String uuid = UUID.randomUUID().toString();
        // 利用lambda表达式
        return redisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
            Jedis jedis = (Jedis) redisConnection.getNativeConnection();
            String result = jedis.set(lock, uuid, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, LOCK_EXPIRE);
            if (LOCK_SUCCESS.equals(result)) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        });
    }

    /**
     * 删除锁
     *
     * @param key
     */
    public boolean delete(String key) {
        String lock = LOCK_PREFIX + key;
        String uuid = UUID.randomUUID().toString();
        return redisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
            Jedis jedis = (Jedis) redisConnection.getNativeConnection();
            Object result = jedis.eval(RELEASE_LOCK_SCRIPT, Collections.singletonList(lock),
                    Collections.singletonList(uuid));
            if (RELEASE_SUCCESS.equals(result)) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        });
    }
}


