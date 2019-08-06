/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年8月6日/下午5:25:24
 * 项目名称：  dfas-common-util
 * 文件名称: ReflectUtil.java
 * 文件描述: @Description: 反射工具类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.util;

import java.lang.reflect.Field;

import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.enumeration.CommonExceptionEnum;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

/**   
 * 包名称： com.win.dfas.common.util 
 * 类名称：ReflectUtil 
 * 类描述：反射工具类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年8月6日/下午5:25:24
 *     
 */
public class ReflectUtil {

	/**
	 * 
	 * 根据属性名获取对象中的属性值
	 * @Title: getFieldObject
	 * @param object
	 * @param filedName
	 * @return
	 * @throws Exception   
	 * @return: Object   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年8月6日/下午7:17:27
	 */
	public static Object getFieldObject(Object object, String filedName) throws Exception {
		
		if (ObjectUtil.isEmpty(object) || StrUtil.isEmpty(filedName)) {
			return null;
		}
		
		Object resultObjct = null;
		
		// 属性字段拆分
		String[] filedArray = filedName.split("\\.");
		
		Class<?> clazz = object.getClass();
		
		if (filedArray.length > CommonConstants.FORMAT_MAX_LEVEL) {
			throw WinExceptionUtil.winException(CommonExceptionEnum.FORMAT_MAX_LEVEL_FIELD, CommonConstants.FORMAT_MAX_LEVEL);
		}
		
		String iFieldName = filedArray[0];
		Field field = clazz.getDeclaredField(iFieldName);
		
		if (ObjectUtil.isEmpty(field)) {
			return resultObjct;
		}
		
		field.setAccessible(true);
		
		resultObjct = field.get(object);
		
		// 递归调用
		if (filedArray.length > 1) {
			resultObjct = getFieldObject(resultObjct, filedName.substring(filedName.indexOf(".") + 1));
		} 
		
		return resultObjct;
	}
	
}

