/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年7月31日/上午9:58:19
 * 项目名称：  dfas-common-util
 * 文件名称: SysRedisCache.java
 * 文件描述: @Description: 统Redis缓存实体
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.entity;

import lombok.Data;

/**   
 * 包名称： com.win.dfas.common.entity 
 * 类名称：SysRedisCache 
 * 类描述：系统Redis缓存实体
 * 创建人：@author hechengcheng 
 * 创建时间：2019年7月31日/上午9:58:19
 *     
 */
@Data
public class SysRedisCache extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 缓存类型
	 */
	private String cacheType;
	
	/**
	 * 缓存key字段, 该字段必须包含在cache_sql中
	 */
	private String cacheKeyField;
	
	/**
	 * 缓存SQL
	 */
	private String cacheSql;
	
	/**
	 * 缓存结果: 0-成功、1-失败
	 */
	private Integer cacheResult;

	/**
	 * 缓存时间
	 */
	private String cacheTime;

	/**
	 * 缓存条数
	 */
	private Integer cacheRow;

	/**
	 * 缓存耗时(毫秒)
	 */
	private Long cacheCostTime;
}
