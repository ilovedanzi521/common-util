package com.win.dfas.common.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.win.dfas.common.enumeration.FormatEnum;

/**
 * 
 * 包名称： com.win.dfas.common.validation 
 * 类名称：IsAParamValid 
 * 类描述：缓存中数据校验
 * 创建人：@author tandun 
 * 创建时间：2019年8月13日/下午5:20:17
 *
 */
@Target({ ElementType.FIELD })
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { IsAParamValidValidator.class })
@Documented
public @interface IsAParamValid {
	/**
	 * 
	 * @Title: message
	 * @Description: 校验后返回的错误信息 
	 * @return: String   
	 * @throws
	 * @author: tandun 
	 * @Date:  2019年8月13日/下午5:20:43
	 */
	String message() default "";
     //分组进行校验
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
    //字典对应缓存的项
	FormatEnum enumValue();
    //字典对应缓存项+prefixParam
	String prefixParam();

}
