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

import org.springframework.beans.BeanUtils;

import com.github.pagehelper.PageInfo;

/**   
 * 包名称： com.win.dfas.common.util 
 * 类名称：ListUtil 
 * 类描述：对象拷贝或转换工具类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年5月29日/下午4:53:36
 *     
 */
public class ObjectUtils {
	
	/**
	 * 
	 * @Title: copyPropertiesList
	 * @Description: List对象转换
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

		try {
			if (sourceList == null || sourceList.size() == 0) {
				return resultList;
			}

			for (Object source : sourceList) {
				T target = clazz.newInstance();
				BeanUtils.copyProperties(source, target);
				resultList.add(target);
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
	 * @Title: copyPageInfo
	 * @Description: 分页对象拷贝
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
				
		try {
			if (sourcePageInfo == null) {
				return resultPageInfo;
			}
			
			// 拷贝PageInfo对象(排除list)
			BeanUtils.copyProperties(sourcePageInfo, resultPageInfo, "list");
			
			List<?> sourceList = sourcePageInfo.getList();
			
			// 拷贝PageInfo对象中的list
			List<T> targetLsit = copyPropertiesList(sourceList, clazz);
			
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

	public static void getFiled(Class clazz){
		Field[] fields = clazz.getDeclaredFields();
		for(Field field:fields){
			String type =field.getType().getSimpleName();
			if("Integer".equals(type)||"int".equals(type)){
				type ="number";
			}else {
				if(!"Date".equals(type)){
					type =  type.toLowerCase();
				}
			}
			System.out.println("public "+field.getName()+": "+type);
		}
	}

}
