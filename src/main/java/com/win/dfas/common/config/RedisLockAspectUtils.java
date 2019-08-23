/****************************************************
 * 创建人: @author wanglei
 * 创建时间: 2019/8/23/11:01
 * 项目名称: dfas-common-util
 * 文件名称: a.java
 * 文件描述: @Description: 拦截分布式注解
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfas.common.config;

import com.win.dfas.common.annotation.RedisLockAnnotation;
import com.win.dfas.common.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 包名称：com.win.dfas.common.config
 * 类名称：RedisLockAspectUtils
 * 类描述：拦截分布式注解
 * 创建人：@author wanglei
 * 创建时间：2019/8/23/11:01
 */

@Aspect
@Component
@Slf4j
public class RedisLockAspectUtils {

    @Around("@annotation(redisLock)")
    public Object redisLockTest(ProceedingJoinPoint point, RedisLockAnnotation redisLock) {
        String key = redisLock.redisKey();
        boolean flag = false;
        String uuid = UUID.randomUUID().toString();
        try {
            //set到redis
            while(true){
                flag = RedisUtil.lock(key, uuid);
                if(flag) {
                    log.info("获取锁成功");
                    break;
                }else{
                    log.info("获取锁失败,重新获得锁");
                    Thread.sleep(4);
                }
            }
            Object result = point.proceed();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            //最后在finally中删除
            if (flag) {
                RedisUtil.delete(key,uuid);
                log.info("释放锁成功");
            }
        }
        return null;
    }
}
