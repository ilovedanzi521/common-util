/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年9月25日/上午9:56:00
 * 项目名称：  dfas-common-util
 * 文件名称: ResponseUtil.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.util;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.hutool.core.util.ObjectUtil;

/**   
 * 包名称： com.win.dfas.common.util 
 * 类名称：ResponseUtil 
 * 类描述：TODO
 * 创建人：@author hechengcheng 
 * 创建时间：2019年9月25日/上午9:56:00
 *     
 */
public class ResponseUtil {

	/**
	 * 
	 * 获取返回信息
	 * @Title: getResponse
	 * @return   
	 * @return: HttpServletResponse   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年9月17日/下午7:55:18
	 */
	public static HttpServletResponse getResponse() {
		
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		
		if (ObjectUtil.isEmpty(requestAttributes)) {
			return null;
		}
		
		return ((ServletRequestAttributes) requestAttributes).getResponse();
	}
}
