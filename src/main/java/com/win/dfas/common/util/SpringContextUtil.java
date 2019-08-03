/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年7月2日/上午11:26:15
 * 项目名称：  dfas-common-util
 * 文件名称: WinApplicationContextAware.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**   
 * 包名称： com.win.dfas.common.util 
 * 类名称：WinApplicationContextAware 
 * 类描述：TODO
 * 创建人：@author hechengcheng 
 * 创建时间：2019年7月2日/上午11:26:15
 *     
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext = null;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}
	
	/**
	 * 
	 * 根据名称和类型获取Bean
	 * @Title: getBean
	 * @param name
	 * @param clazz
	 * @return   
	 * @return: T   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月2日/上午11:44:32
	 */
	public static <T> T getBean(String name, Class<T> clazz) {
		return applicationContext.getBean(name, clazz);
	}
	
	/**
	 * 
	 * 根据类型获取Bean
	 * @Title: getBean
	 * @param clazz
	 * @return   
	 * @return: T   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月10日/下午6:03:10
	 */
	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
	
	/**
	 * 
	 * 根据名称获取Bean
	 * @Title: getBean
	 * @param name
	 * @return   
	 * @return: Object   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年8月3日/上午11:39:04
	 */
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}
	
	
	
	/**
	 * 
	 * 获取当前环境
	 * @Title: getActiveProfile
	 * @return   
	 * @return: String   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月2日/上午11:42:51
	 */
	public static String getActiveProfile() {
        return applicationContext.getEnvironment().getActiveProfiles()[0];
    }

}
