/****************************************************
 * 创建人：  @author xiep
 * 创建时间: 2017-11-22/13:41:08
 * 项目名称: ycmp-api
 * 文件名称: FeignConfiguration.java
 * 文件描述: @Description
 * 公司名称: 深圳市赢和信息技术有限公司
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2017
 *
 ********************************************************/

package com.win.dfas.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import feign.Feign;



/**
 * 包名称： com.yh.ycbp.ipoms.config
 * 类名称：FeignConfiguration
 * 类描述：解决@FeignClient中的@RequestMapping也被SpringMVC加载的问题解决
 * http://blog.didispace.com/spring-cloud-feignclient-problem/?utm_source=tuicool&utm_medium=referral
 * 创建人：@author xiep
 * 创建时间：2017年9月14日/上午10:30:28
 *
 */

@Configuration
@ConditionalOnClass({ Feign.class })
public class FeignConfig {

	@SuppressWarnings("unused")
	private static class FeignRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
		@Override
		protected boolean isHandler(Class<?> beanType) {
			return super.isHandler(beanType) && !AnnotatedElementUtils.hasAnnotation(beanType, FeignClient.class);
		}
	}

}
