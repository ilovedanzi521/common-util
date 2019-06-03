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
 * 在需要保证 接口幂等性 的Controller的方法上使用此注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiIdempotent {

}
