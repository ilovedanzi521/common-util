/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年10月23日/下午6:11:27
 * 项目名称：  dfas-common-util
 * 文件名称: RedisMessageReceive.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.win.dfas.common.service.IRedisCacheParamService;

/**   
 * 包名称： com.win.dfas.common.service.impl 
 * 类名称：RedisMessageReceive
 * 类描述：TODO
 * 创建人：@author hechengcheng 
 * 创建时间：2019年10月23日/下午6:11:27
 *     
 */
@Service
public final class RedisMessageReceive {

	@Autowired(required = false)
	private IRedisCacheParamService redisCacheParamService;
	
	/**
	 * 
	 * 缓存接收消息
	 * @Title: cacheParamReceive
	 * @param message   
	 * @return: void   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年10月23日/下午7:02:18
	 */
	public void cacheParamReceive(String message) {
		
		if (redisCacheParamService != null) {
			redisCacheParamService.refreshCache(message);
		}
	}
	
}
