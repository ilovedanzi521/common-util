package com.win.dfas.common.annotation;

/**
 * 包名称：com.win.dfas.common.anno
 * 类名称：ApiI
 * 类描述：${TODO}
 * 创建人：@author wanglei
 * 创建时间：2019/5/28/13:34
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 分布式锁
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisLockAnnotation {
    String redisKey();
}
