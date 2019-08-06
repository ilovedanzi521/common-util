/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年5月29日/下午4:53:36
 * 项目名称：  dfas-common-util
 * 文件名称: ListUtil.java
 * 文件描述: @Description: 对象拷贝或转换工具类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.win.dfas.common.annotation.WinFormat;
import com.win.dfas.common.enumeration.CommonExceptionEnum;
import com.win.dfas.common.enumeration.FormatEnum;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.ObjectUtil;

/**   
 * 包名称： com.win.dfas.common.util 
 * 类名称：ListUtil 
 * 类描述：对象拷贝或转换工具类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年5月29日/下午4:53:36
 *     
 */
public class ObjectUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ObjectUtils.class);
	
	/**
	 * List对象转换
	 * @Title: copyPropertiesList
	 * @param sourceList 源对象
	 * @param clazz 新对象类型
	 * @return   
	 * @return: List<?>  转换后List对象 
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年5月29日/下午5:41:06
	 */
	public static <T> List<T> copyPropertiesList(List<?> sourceList, Class<T> clazz) {

		List<T> resultList = new ArrayList<T>();;

		resultList = copyPropertiesList(sourceList, clazz, false);

		return (List<T>)resultList;
	}
	
	/**
	 * 
	 * List对象转换
	 * @Title: copyPropertiesList
	 * @param sourceList 源对象
	 * @param clazz	新对象类型
	 * @param format 是否格式化
	 * @return   
	 * @return: List<T>   转换后List对象 
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年8月6日/上午10:51:24
	 */
	public static <T> List<T> copyPropertiesList(List<?> sourceList, Class<T> clazz, boolean format) {

		List<T> resultList = new ArrayList<T>();;

		try {
			if (sourceList == null || sourceList.size() == 0) {
				return resultList;
			}

			for (Object source : sourceList) {
				T target = clazz.newInstance();
				BeanUtils.copyProperties(source, target);
				resultList.add(target);
			}
			
			// 格式化数据
			if (format) {
				formatList(sourceList, clazz);
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return (List<T>)resultList;
	}
	
	/**
	 * 
	 * 分页对象拷贝
	 * @Title: copyPageInfo
	 * @param sourcePageInfo 源分页对象
	 * @param clazz 目标分页对象中List的对象类型
	 * @return   
	 * @return: PageInfo<T>  转换后的分页对象 
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年6月6日/下午1:17:29
	 */
	public static <T> PageInfo<T> copyPageInfo(PageInfo<?> sourcePageInfo, Class<T> clazz) {
		
		PageInfo<T> resultPageInfo = new PageInfo<T>();
				
		// 分页对象拷贝
		resultPageInfo = copyPageInfo(sourcePageInfo, clazz, false);
		
		return (PageInfo<T>)resultPageInfo;
		
	}
	
	/**
	 * 
	 * 分页对象拷贝
	 * @Title: copyPageInfo
	 * @param sourcePageInfo 源分页对象
	 * @param clazz 目标分页对象中List的对象类型
	 * @param format 是否格式化
	 * @return   
	 * @return: PageInfo<T>   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年8月6日/上午10:54:20
	 */
	public static <T> PageInfo<T> copyPageInfo(PageInfo<?> sourcePageInfo, Class<T> clazz, boolean format) {
		
		PageInfo<T> resultPageInfo = new PageInfo<T>();
				
		try {
			if (sourcePageInfo == null) {
				return resultPageInfo;
			}
			
			// 拷贝PageInfo对象(排除list)
			BeanUtils.copyProperties(sourcePageInfo, resultPageInfo, "list");
			
			List<?> sourceList = sourcePageInfo.getList();
			
			// 拷贝PageInfo对象中的list
			List<T> targetLsit = copyPropertiesList(sourceList, clazz);
			
			// 数据格式化
			formatList(sourceList, clazz);
			
			resultPageInfo.setList(targetLsit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (PageInfo<T>)resultPageInfo;
		
	}
	
	/**
	 * 
	 * @Title: clone
	 * @Description: 对象深度克隆
	 * @param srcObj 源对象
	 * @return   
	 * @return: Object 克隆对象
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年5月29日/下午5:52:49
	 */
	public static Object clone(Object srcObj) {
		
		Object cloneObj = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(srcObj);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ois = new ObjectInputStream(bais);
            cloneObj = ois.readObject();

            baos.close();
            bais.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try {
				oos.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }

        return cloneObj;
    }

	/**
	 * 
	 * 根据自定义规则格式化列表数据
	 * @Title: formatList
	 * @param sourceList
	 * @param clazz   
	 * @return: void   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年8月5日/下午8:11:33
	 */
	public static void formatList(List<?> sourceList, Class<?> clazz) {
		
		List<Field> annoFiedlList  = getWinFormatField(clazz);
		
		if (CollectionUtil.isEmpty(annoFiedlList)) {
			return;
		}
		
		// 遍历格式化数据
		for (Object sourceObject : sourceList) {
			formatObjectByAnnotation(sourceObject, clazz, annoFiedlList);
		}
	}
	
	
	/**
	 * 
	 * 根据自定义规则格式化数据
	 * @Title: formatObject
	 * @param sourceObject
	 * @param clazz   
	 * @return: void   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年8月6日/上午10:42:13
	 */
	public static void formatObject(Object sourceObject, Class<?> clazz) {
		
		List<Field> annoFiedlList  = getWinFormatField(clazz);
		
		if (CollectionUtil.isEmpty(annoFiedlList)) {
			return;
		}
		
		// 格式化数据
		formatObjectByAnnotation(sourceObject, clazz, annoFiedlList);
	}
	
	/**
	 * 
	 * 根据自定义规则格式化数据
	 * @Title: formatObjectByAnnotation
	 * @param sourceObject 格式化对象
	 * @param clazz 格式化对象类
	 * @param annoFiedlList  注解列表 
	 * @return: void   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年8月6日/上午10:42:39
	 */
	private static void formatObjectByAnnotation(Object sourceObject, Class<?> clazz, List<Field> annoFiedlList) {
		
		try {
			
			if (CollectionUtil.isEmpty(annoFiedlList)) {
				return;
			}
			
			for (Field field : annoFiedlList) {
				
				try {
					field.setAccessible(true);
					
					WinFormat winFormat = field.getAnnotation(WinFormat.class);
					
					// 获取注解枚举
					FormatEnum formatEnum = winFormat.value();
					
					// 获取数据来源属性名称
					String fromFieldName = winFormat.fromField();
					
					// 获取数据来源属性值
					Object fromFieldValue = ReflectUtil.getFieldObject(sourceObject, fromFieldName);
					
					if (ObjectUtil.isEmpty(fromFieldValue)) {
						continue;
					}
					
					// 参数对象处理
					Object[] paramObjects = new Object[winFormat.prefixParam().length + 1];
					
					if (winFormat.prefixParam().length > 0) {
						System.arraycopy(winFormat.prefixParam(), 0, paramObjects, 0, paramObjects.length - 1);
					} 
					
					paramObjects[paramObjects.length - 1] = fromFieldValue;
					
					// 获取REDIS对应的值
					String formatKey = formatEnum.getFormat();
					Object redisObject = RedisUtil.get(String.format(formatKey, paramObjects));
					
					if (ObjectUtil.isEmpty(redisObject)) {
						continue;
					}
					
					// REDIS值转换
					@SuppressWarnings("unchecked")
					Map<String, Object> redisMap = JSON.parseObject(JSON.toJSONString(redisObject), Map.class);
					
					// 获取解析值
					Object redisMapValue = redisMap.get(String.format(formatEnum.getKey()));
					
					if (ObjectUtil.isEmpty(redisMapValue)) {
						continue;
					}
					
					// 设置属性值
					field.set(sourceObject, redisMapValue);
					
				} catch (Exception e) {
					LOGGER.error(ExceptionUtil.getMessage(e));
					throw WinExceptionUtil.winException(CommonExceptionEnum.FORMAT_EXCEPTION);
				}
			}
		} catch (Exception e) {
			LOGGER.error(ExceptionUtil.getMessage(e));
			throw WinExceptionUtil.winException(CommonExceptionEnum.FORMAT_EXCEPTION);
		}
	}
	
	/**
	 * 
	 * 获取WinFormat注解属性
	 * @Title: getWinFormatField
	 * @param clazz
	 * @return   
	 * @return: List<Field>   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年8月6日/下午4:48:03
	 */
	private static List<Field> getWinFormatField(Class<?> clazz) {
		
		List<Field> annoFiedlList = new ArrayList<Field>();
		
		// 获取类的所有属性
		Field[] fieldArray = clazz.getDeclaredFields();
		
		// 获取有WinFormat注解的属性
		for (Field field : fieldArray) {
			
			if (field.isAnnotationPresent(WinFormat.class)) {
				annoFiedlList.add(field);
			}
		}
		
		return annoFiedlList;
	}
	
}
