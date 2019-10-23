/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年10月23日/下午6:14:39
 * 项目名称：  dfas-common-util
 * 文件名称: IRedisCacheParamService.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.service;

/**   
 * 包名称： com.win.dfas.common.service 
 * 类名称：IRedisCacheParamService 
 * 类描述：TODO
 * 创建人：@author hechengcheng 
 * 创建时间：2019年10月23日/下午6:14:39
 *     
 */
public interface IRedisCacheParamService {

	/**
	 * 
	 * 刷新缓存
	 * @Title: refreshCache
	 * @param message   
	 * @return: void   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年10月23日/下午6:17:21
	 */
	void refreshCache(String message);
}
