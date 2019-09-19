/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年7月31日/下午5:12:50
 * 项目名称：  dfas-common-util
 * 文件名称: SysRedisCacheReqVO.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.vo;

import java.util.List;

import lombok.Data;

/**   
 * 包名称： com.win.dfas.common.vo 
 * 类名称：SysRedisCacheReqVO 
 * 类描述：TODO
 * 创建人：@author hechengcheng 
 * 创建时间：2019年7月31日/下午5:12:50
 *     
 */
@Data
public class SysRedisCacheReqVO extends BaseReqVO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 缓存类型
	 */
	private String cacheType;
	
	/**
	 * 缓存类型列表
	 */
	private List<String> cacheTypeList;

	/**
	 * 缓存关键字，模糊匹配缓存类型或者缓存名称
	 */
	private String key;
}
