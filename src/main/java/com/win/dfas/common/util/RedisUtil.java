package com.win.dfas.common.util;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.fastjson.JSON;
import com.win.dfas.common.constant.CommonConstants;

import cn.hutool.core.util.ObjectUtil;
import redis.clients.jedis.Jedis;

/**
 * 包名称：com.example.redis
 * 类名称：RedisUtil
 * 类描述：REDIS操作工具类
 * 创建人：@author wanglei
 * 创建时间：2019/5/28/16:01
 */
public final class RedisUtil {

	@SuppressWarnings("unchecked")
	private static RedisTemplate<String, Object> redisTemplate = SpringContextUtil.getBean("redisTemplate", RedisTemplate.class);

	/**
     *
     * 指定缓存失效时间
     * @Title: expire
     * @param key 键
     * @param time 时间(秒)
     * @return
     * @return: boolean
     * @throws
     * @author: hechengcheng
     * @Date:  2019年7月31日/下午1:40:17
     */
    public static boolean expire(String key, long time) {
        if (time > 0) {
        	redisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
        return true;
    }

    /**
     *
     * 根据key获取过期日期
     * @Title: getExpire
     * @param key
     * @return
     * @return: Long  时间(秒) 返回0代表为永久有效
     * @throws
     * @author: hechengcheng
     * @Date:  2019年7月31日/下午1:41:33
     */
    public static long getExpire(String key) {

    	return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     *
     * 判断key是否存在
     * @Title: hasKey
     * @param key
     * @return
     * @return: Boolean
     * @throws
     * @author: hechengcheng
     * @Date:  2019年7月31日/下午1:43:16
     */
    public static boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     *
     * 删除缓存
     * @Title: del
     * @param key
     * @return
     * @return: long
     * @throws
     * @author: wanglei
     * @Date:  2019年7月31日/下午8:18:23
     */
    public static long del(String... key) {
        if ((key != null) && (key.length > 0)) {
            if (key.length == 1) {
                if(redisTemplate.delete(key[0])){
                    return 1;
                }else{
                    return 0;
                }
            } else {
                return  redisTemplate.delete(Arrays.asList(key));
            }
        }
        return 0;
    }

    /**
     *
     * 根据指定的前缀删除数据
     * @Title: delByPrefix
     * @param prefix
     * @return: void
     * @throws
     * @author: hechengcheng
     * @Date:  2019年7月31日/下午4:59:24
     */
    public static void delByPrefix(String prefix) {

    	Set<String> keySet = redisTemplate.keys(prefix + CommonConstants.ASTERISK);

    	redisTemplate.delete(keySet);
    }


    /**
     * 普通缓存获取
     * @param key 键
     * @return 值
     */
    public static Object get(String key) {
        return (key == null) ? null : redisTemplate.opsForValue().get(key);
    }


    /**
     * 普通缓存放入并设置时间
     * @param key 键
     * @param value 值
     * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public static boolean set(String key, Object value, long time) {
        if (time > 0) {
        	redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        } else {
        	redisTemplate.opsForValue().set(key, value, 10, TimeUnit.SECONDS);
        }
        return true;
    }

    /**
     *
     * 通过管道设置数据
     * @Title: setByPipelined
     * @param map
     * @param expire
     * @return: void
     * @throws
     * @author: hechengcheng
     * @Date:  2019年7月31日/下午2:08:08
     */
    public static void setByPipelined(Map<String, Object> map, long expire) {

    	redisTemplate.executePipelined(new RedisCallback<Object>() {

			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {

				for (Map.Entry<String, Object> entry : map.entrySet()) {

					if (ObjectUtil.isEmpty(entry.getValue())) {
						continue;
					}

					connection.set(entry.getKey().getBytes(), JSON.toJSONBytes(entry.getValue()));

					if (expire > 0) {
						connection.expire(entry.getKey().getBytes(), expire);
					}
				}

				return null;
			}
		});
    }

    public static final String LOCK_PREFIX = "redis_lock";
    public static final int LOCK_EXPIRE = 10;
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
    public static boolean lock(String key,String uuid){
        String lock = LOCK_PREFIX + key;
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
    public static boolean delete(String key,String uuid) {
        String lock = LOCK_PREFIX + key;
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
    /**
     * @Title: matchGet
     * @Description 模糊匹配获取key对应的列表
     * @param pattern
     * @return java.util.List<java.lang.Object>
     * @throws
     * @author wanglei
     * @Date 2019/8/20/9:42
     */
    public static List<Object> matchGet(String pattern){
        Set<String> keys = redisTemplate.keys(pattern);
        List<Object> list = redisTemplate.opsForValue().multiGet(keys);
        return list;
    }
    /**
     * @Title: multiGet
     * @Description 批量查询
     * @param keys
     * @return java.util.List<java.lang.Object>
     * @throws
     * @author wanglei
     * @Date 2019/8/20/10:05
     */
    public static List<Object> multiGet(Set<String> keys){
        List<Object> list = redisTemplate.opsForValue().multiGet(keys);
        return list;
    }
    public static Long incr(String key){
        Long value = redisTemplate.opsForValue().increment(key);
        return value;
    }
}


