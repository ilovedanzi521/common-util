/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年9月10日/下午8:37:18
 * 项目名称：  dfas-common-util
 * 文件名称: FeignInterceptor.java
 * 文件描述: @Description: Feign接口请求拦截器
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**   
 * 包名称： com.win.dfas.common.interceptor 
 * 类名称：FeignInterceptor 
 * 类描述：Feign接口请求拦截器
 * 创建人：@author hechengcheng 
 * 创建时间：2019年9月10日/下午8:37:18
 *     
 */
@Configuration
public class FeignInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate requestTemplate) {
		
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		
		if (requestAttributes == null) {
			return;
		}
		
		HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

		Enumeration<String> headerNames = request.getHeaderNames();
		
		if (headerNames != null) {
			while (headerNames.hasMoreElements()) {
				
				String key = headerNames.nextElement();
				Enumeration<String> values = request.getHeaders(key);
				
				while (values.hasMoreElements()) {
					String value = values.nextElement();
					requestTemplate.header(key, value);
				}
			}
		}
	}

}
