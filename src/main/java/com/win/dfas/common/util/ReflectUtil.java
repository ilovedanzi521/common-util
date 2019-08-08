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
import java.util.ArrayList;
import java.util.List;

import com.win.dfas.common.constant.CommonConstants;

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
	 * @param filedName 多个点号分隔
	 * @return
	 * @throws Exception   
	 * @return: Object   
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws NoSuchFieldException 
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年8月6日/下午7:17:27
	 */
	public static Object getFieldObject(Object object, String fieldName) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
		
		if (ObjectUtil.isEmpty(object) || StrUtil.isEmpty(fieldName)) {
			return null;
		}
		
		// 属性字段拆分
		String[] filedArray = fieldName.split(CommonConstants.TRANSFERRED_DOT);
		
		// 遍历的Object
		Object resultObjct = object;
		Field fField = null;
		
		for (String fFieldName: filedArray) {
			fField = getField(resultObjct.getClass(), fFieldName);
			
			if (ObjectUtil.isEmpty(fField)) {
				break;
			}
			
			fField.setAccessible(true);
			
			resultObjct = fField.get(resultObjct);
		}
		
		return resultObjct;
	}
	
	/**
	 * 
	 * 根据指定类和属性名获取属性字段
	 * @Title: getField
	 * @param clazz
	 * @param fieldName
	 * @return
	 * @throws NoSuchFieldException   
	 * @return: Field   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年8月8日/下午3:59:38
	 */
	public static Field getField(Class<?> clazz, String fieldName) throws NoSuchFieldException {
		
		Field field = null;
		
		if (ObjectUtil.isEmpty(clazz) || StrUtil.isEmpty(fieldName)) {
			return null;
		}
		
		field = clazz.getDeclaredField(fieldName);
		
		return field;
	}
	
	/**
	 * 
	 * 获取指定类所有属性
	 * @Title: getAllField
	 * @param clazz
	 * @return   
	 * @return: List<Field>   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年8月6日/下午4:48:03
	 */
	public static List<Field> getAllField(Class<?> clazz) {
		
		List<Field> fiedlList = new ArrayList<Field>();
		
		// 递归获取类(包含父类)属性
		while (clazz != null) {
			
			// 获取类的所有属性
			Field[] fieldArray = clazz.getDeclaredFields();
			
			// 获取属性
			for (Field field : fieldArray) {
				fiedlList.add(field);
			}
			
			clazz = clazz.getSuperclass();
		}
		
		return fiedlList;
	}
}

