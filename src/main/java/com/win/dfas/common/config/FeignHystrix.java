/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年9月12日/下午12:29:01
 * 项目名称：  dfas-common-util
 * 文件名称: FeignHystrix.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.config;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariable;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableLifecycle;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisher;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;
import com.netflix.hystrix.strategy.properties.HystrixProperty;

/**
 * 包名称： com.win.dfas.common.config 
 * 类名称：FeignHystrix 
 * 类描述：自定义Feign的隔离策略, 解决熔断请求头数据丢失问题
 * 创建人：@author hechengcheng 
 * 创建时间：2019年9月12日/下午12:29:01
 * 
 */
@Component
public class FeignHystrix extends HystrixConcurrencyStrategy {

	private static final Logger LOGGER = LoggerFactory.getLogger(FeignHystrix.class);

	private HystrixConcurrencyStrategy delegate;

	public FeignHystrix() {
		try {
			this.delegate = HystrixPlugins.getInstance().getConcurrencyStrategy();
			if (this.delegate instanceof FeignHystrix) {
				// Welcome to singleton hell...
				return;
			}
			HystrixCommandExecutionHook commandExecutionHook = HystrixPlugins.getInstance().getCommandExecutionHook();
			HystrixEventNotifier eventNotifier = HystrixPlugins.getInstance().getEventNotifier();
			HystrixMetricsPublisher metricsPublisher = HystrixPlugins.getInstance().getMetricsPublisher();
			HystrixPropertiesStrategy propertiesStrategy = HystrixPlugins.getInstance().getPropertiesStrategy();
			this.logCurrentStateOfHystrixPlugins(eventNotifier, metricsPublisher, propertiesStrategy);
			HystrixPlugins.reset();
			HystrixPlugins.getInstance().registerConcurrencyStrategy(this);
			HystrixPlugins.getInstance().registerCommandExecutionHook(commandExecutionHook);
			HystrixPlugins.getInstance().registerEventNotifier(eventNotifier);
			HystrixPlugins.getInstance().registerMetricsPublisher(metricsPublisher);
			HystrixPlugins.getInstance().registerPropertiesStrategy(propertiesStrategy);
		} catch (Exception e) {
			LOGGER.error("Failed to register Sleuth Hystrix Concurrency Strategy", e);
		}
	}

	private void logCurrentStateOfHystrixPlugins(HystrixEventNotifier eventNotifier,
			HystrixMetricsPublisher metricsPublisher, HystrixPropertiesStrategy propertiesStrategy) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Current Hystrix plugins configuration is [" + "concurrencyStrategy [" + this.delegate + "],"
					+ "eventNotifier [" + eventNotifier + "]," + "metricPublisher [" + metricsPublisher + "],"
					+ "propertiesStrategy [" + propertiesStrategy + "]," + "]");
			LOGGER.debug("Registering Sleuth Hystrix Concurrency Strategy.");
		}
	}

	@Override
	public <T> Callable<T> wrapCallable(Callable<T> callable) {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		return new WrappedCallable<>(callable, requestAttributes);
	}

	@Override
	public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey, HystrixProperty<Integer> corePoolSize,
			HystrixProperty<Integer> maximumPoolSize, HystrixProperty<Integer> keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		return this.delegate.getThreadPool(threadPoolKey, corePoolSize, maximumPoolSize, keepAliveTime, unit,
				workQueue);
	}

	@Override
	public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey,
			HystrixThreadPoolProperties threadPoolProperties) {
		return this.delegate.getThreadPool(threadPoolKey, threadPoolProperties);
	}

	@Override
	public BlockingQueue<Runnable> getBlockingQueue(int maxQueueSize) {
		return this.delegate.getBlockingQueue(maxQueueSize);
	}

	@Override
	public <T> HystrixRequestVariable<T> getRequestVariable(HystrixRequestVariableLifecycle<T> rv) {
		return this.delegate.getRequestVariable(rv);
	}

	static class WrappedCallable<T> implements Callable<T> {
		private final Callable<T> target;
		private final RequestAttributes requestAttributes;

		public WrappedCallable(Callable<T> target, RequestAttributes requestAttributes) {
			this.target = target;
			this.requestAttributes = requestAttributes;
		}

		@Override
		public T call() throws Exception {
			try {
				RequestContextHolder.setRequestAttributes(requestAttributes);
				return target.call();
			} finally {
				RequestContextHolder.resetRequestAttributes();
			}
		}
	}
}
