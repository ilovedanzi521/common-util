/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年8月7日/上午10:31:53
 * 项目名称：  dfas-common-util
 * 文件名称: ExecutorConfig.java
 * 文件描述: @Description: 线程池配置类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**   
 * 包名称： com.win.dfas.common.config 
 * 类名称：ExecutorConfig 
 * 类描述：线程池配置类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年8月7日/上午10:31:53
 *     
 */
@Component
@ConditionalOnProperty(value="executor.enable")
public class ExecutorConfig {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorConfig.class);

	@Autowired
    private Environment env;
	
	@Bean
	public Executor executor() {
		
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		
		Integer corePoolSize = env.getProperty("executor.corePoolSize", Integer.class);
		Integer maxPoolSize = env.getProperty("executor.maxPoolSize", Integer.class);
		Integer keepAliveTime = env.getProperty("executor.keepAliveTime", Integer.class);
		Integer queueCapacity = env.getProperty("executor.queueCapacity", Integer.class);
		
		LOGGER.info("corePoolSize = {}, maxPoolSize = {}, keepAliveTime = {}, queueCapacity = {}", corePoolSize, maxPoolSize, keepAliveTime, queueCapacity);
		
		executor.setCorePoolSize(corePoolSize);
		executor.setMaxPoolSize(maxPoolSize);
		executor.setKeepAliveSeconds(keepAliveTime);
		executor.setQueueCapacity(queueCapacity);
		executor.setThreadNamePrefix("winExecutor-");
		
		// CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		
		executor.initialize();
		
		return executor;
	}
	
}
