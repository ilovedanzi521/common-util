/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年10月23日/下午5:59:08
 * 项目名称：  dfas-common-util
 * 文件名称: RedisTopicEnum.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.enumeration;

/**   
 * 包名称： com.win.dfas.common.enumeration 
 * 类名称：RedisTopicEnum 
 * 类描述：TODO
 * 创建人：@author hechengcheng 
 * 创建时间：2019年10月23日/下午5:59:08
 *     
 */
public enum RedisTopicEnum {

	TOPIC_CACHE_PARAM_DATA("TOPIC_CACHE_PARAM_DATA", "Redis缓存参数数据"), 
	;
	private String topic;
	private String name;

	RedisTopicEnum(String topic, String name) {
		this.topic = topic;
		this.name = name;
	}

	public String getTopic() {
		return topic;
	}

	public String getName() {
		return name;
	}
		
}
