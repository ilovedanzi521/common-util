/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年7月31日/上午9:47:39
 * 项目名称：  dfas-common-util
 * 文件名称: ICache.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.service;

import com.win.dfas.common.vo.SysRedisCacheReqVO;

/**   
 * 包名称： com.win.dfas.common.service 
 * 类名称：ICache 
 * 类描述：公用缓存接口
 * 创建人：@author hechengcheng 
 * 创建时间：2019年7月31日/上午9:47:39
 *     
 */
public interface IRedisCacheService {

	/**
	 * 
	 * 加载缓存
	 * @Title: loadCache
	 * @param reqVO   
	 * @return: void   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月31日/下午5:14:46
	 */
	void loadCache(SysRedisCacheReqVO reqVO);
	
	/**
	 * 
	 * 刷新缓存
	 * @Title: refreshCache
	 * @param reqVO   
	 * @return: void   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月31日/下午5:16:23
	 */
	void refreshCache(SysRedisCacheReqVO reqVO);
	
	/**
	 * 
	 * 清空缓存
	 * @Title: clearCache
	 * @param reqVO   
	 * @return: void   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月31日/下午5:16:34
	 */
	void clearCache(SysRedisCacheReqVO reqVO);
}
