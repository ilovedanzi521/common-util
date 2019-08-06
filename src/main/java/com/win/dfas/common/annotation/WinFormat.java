/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年8月5日/下午4:30:57
 * 项目名称：  dfas-common-util
 * 文件名称: WinFormat.java
 * 文件描述: @Description: 转义格式化注解
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.win.dfas.common.enumeration.FormatEnum;

/**   
 * 包名称： com.win.dfas.common.annotation 
 * 类名称：WinFormat 
 * 类描述：转义格式化注解
 * 创建人：@author hechengcheng 
 * 创建时间：2019年8月5日/下午4:30:57
 *     
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface WinFormat {

	FormatEnum value();
	
	String fromField();
	
	String[] prefixParam() default {};
}
