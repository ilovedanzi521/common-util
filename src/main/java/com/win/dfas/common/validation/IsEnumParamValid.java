package com.win.dfas.common.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.win.dfas.common.enumeration.EmunParam;


/**
 * 
 * 包名称： com.win.dfas.common.validation 
 * 类名称：IsEnumParamValid 
 * 类描述：枚举类参数校验
 * 创建人：@author tandun 
 * 创建时间：2019年8月14日/上午11:02:25
 *
 */
@Target({ ElementType.FIELD })
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { IsEnumParamValidator.class })
@Documented
public @interface IsEnumParamValid {
	String message() default "";	
    //分组进行校验
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	//业务传入枚举类型需进行检验的参数
	EmunParam emunType();
}
