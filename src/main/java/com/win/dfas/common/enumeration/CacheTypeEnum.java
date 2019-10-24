/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年10月23日/下午7:33:17
 * 项目名称：  dfas-common-util
 * 文件名称: CacheTypeEnum.java
 * 文件描述: @Description: 缓存类型枚举
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.enumeration;

/**   
 * 包名称： com.win.dfas.common.enumeration 
 * 类名称：CacheTypeEnum 
 * 类描述：缓存类型枚举
 * 创建人：@author hechengcheng 
 * 创建时间：2019年10月23日/下午7:33:17
 *     
 */
public enum CacheTypeEnum {

	SYS_USER("SYS_USER", "用户缓存"),
	SYS_TRADE_DAY("SYS_TRADE_DAY","系统交易日缓存"),
	;
	private String cacheType;
	private String cacheName;

	CacheTypeEnum(String cacheType, String cacheName) {
		this.cacheType = cacheType;
		this.cacheName = cacheName;
	}

	public String getCacheType() {
		return cacheType;
	}

	public String getCacheName() {
		return cacheName;
	}
}
