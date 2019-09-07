/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年9月6日/下午3:11:34
 * 项目名称：  dfas-common-util
 * 文件名称: WinValidateUtil.java
 * 文件描述: @Description: 对象校验工具类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.util;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.exception.WinException;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;

/**   
 * 包名称： com.win.dfas.common.util 
 * 类名称：WinValidateUtil 
 * 类描述：对象校验工具类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年9月6日/下午3:11:34
 *     
 */
public final class WinValidateUtil {

	private static Validator validator = SpringContextUtil.getBean(Validator.class);
	
	/**
	 * 
	 * 对象校验并抛出异常
	 * @Title: validate
	 * @param object 校验对象
	 * @param groups 校验分组
	 * @return: void   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年9月7日/上午10:41:30
	 */
	public static void validate(Object object, Class<?>... groups) {
		
		String errorMsg = validateMsg(object);
		
		if (StrUtil.isNotEmpty(errorMsg)) {
			throw new WinException(errorMsg);
		}
	}
	
	/**
	 * 
	 * 对象校验并返回异常信息
	 * @Title: validateMsg
	 * @param object 校验对象
	 * @param groups 校验分组
	 * @return   
	 * @return: String   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年9月7日/上午10:42:21
	 */
	public static String validateMsg(Object object, Class<?>... groups) {
		
		Set<ConstraintViolation<Object>> set = validator.validate(object);
		
		if (CollectionUtil.isEmpty(set)) {
			return null;
		}
		
		// 获取错误信息(多个错误信息分号分隔)
		String errorMsg = set.stream().map(ConstraintViolation<Object>::getMessage).collect(Collectors.joining(CommonConstants.SEMICOLON));
		
		return errorMsg;
	}
}
