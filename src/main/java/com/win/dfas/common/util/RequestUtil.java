/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年9月17日/下午7:53:14
 * 项目名称：  dfas-common-util
 * 文件名称: RequestUtil.java
 * 文件描述: @Description: HTTP请求工具类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.win.dfas.common.constant.CommonConstants;

import cn.hutool.core.util.ObjectUtil;

/**   
 * 包名称： com.win.dfas.common.util 
 * 类名称：RequestUtil 
 * 类描述：HTTP请求工具类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年9月17日/下午7:53:14
 *     
 */
public final class RequestUtil {
	
	/**
	 * 
	 * 获取头部用户信息JSON
	 * @Title: getUserJson
	 * @return   
	 * @return: String   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年9月18日/上午9:05:17
	 */
	public static String getUserJson() {
		
		if (ObjectUtil.isNotEmpty(getRequest())) {
			return getRequest().getHeader(CommonConstants.USER_KEY);
		}
		
		return null;
	}
	
	/**
	 * 
	 * 获取头部请求数据源
	 * @Title: getReqSource
	 * @return   
	 * @return: String   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年9月17日/下午8:01:18
	 */
	public static String getReqSource() {
		
		if (ObjectUtil.isNotEmpty(getRequest())) {
			return getRequest().getHeader(CommonConstants.REQ_SOURCE);
		}
		
		return null;
	}
	
	/**
	 * 
	 * 获取头部请求序列
	 * @Title: getReqSequence
	 * @return   
	 * @return: String   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年9月17日/下午8:01:35
	 */
	public static String getReqSequence() {
		
		if (ObjectUtil.isNotEmpty(getRequest())) {
			return getRequest().getHeader(CommonConstants.REQ_SEQUENCE);
		}
		
		return null;
	}

	/**
	 * 
	 * 获取请求信息
	 * @Title: getRequest
	 * @return   
	 * @return: HttpServletRequest   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年9月17日/下午7:55:18
	 */
	public static HttpServletRequest getRequest() {
		
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		
		if (ObjectUtil.isEmpty(requestAttributes)) {
			return null;
		}
		
		return ((ServletRequestAttributes) requestAttributes).getRequest();
	}
}
