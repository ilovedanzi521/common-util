/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年10月23日/下午5:51:42
 * 项目名称：  dfas-common-util
 * 文件名称: RedisMessageConfig.java
 * 文件描述: @Description: Redis消息监听器配置
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import com.win.dfas.common.enumeration.RedisTopicEnum;
import com.win.dfas.common.service.impl.RedisMessageReceive;

/**   
 * 包名称： com.win.dfas.common.config 
 * 类名称：RedisMessageConfig 
 * 类描述：Redis消息监听器配置
 * 创建人：@author hechengcheng 
 * 创建时间：2019年10月23日/下午5:51:42
 *     
 */
@Configuration
public class RedisMessageConfig {

	@Bean
	public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
			MessageListenerAdapter cacheParamAdapter) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		
		container.setConnectionFactory(connectionFactory);
		
		// Redis缓存参数数据
		container.addMessageListener(cacheParamAdapter, new PatternTopic(RedisTopicEnum.TOPIC_CACHE_PARAM_DATA.getTopic()));
		
		return container;
	}
	
	@Bean
    public MessageListenerAdapter cacheParamAdapter(RedisMessageReceive receive){
		
        return new MessageListenerAdapter(receive, "cacheParamReceive");
    }
}
