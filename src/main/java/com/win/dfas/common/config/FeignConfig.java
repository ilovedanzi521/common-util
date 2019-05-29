/****************************************************
<<<<<<< HEAD
 * 创建人：  @author xiep
=======
 * 创建人：  @author xiep    
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
 * 创建时间: 2017-11-22/13:41:08
 * 项目名称: ycmp-api
 * 文件名称: FeignConfiguration.java
 * 文件描述: @Description
 * 公司名称: 深圳市赢和信息技术有限公司
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2017
<<<<<<< HEAD
 *
 ********************************************************/

package com.win.dfas.common.config;

import feign.Feign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.cloud.openfeign.FeignClient;
=======
 * 
 ********************************************************/

package com.dfas.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;



<<<<<<< HEAD
/**
 * 包名称： com.yh.ycbp.ipoms.config
 * 类名称：FeignConfiguration
 * 类描述：解决@FeignClient中的@RequestMapping也被SpringMVC加载的问题解决
 * http://blog.didispace.com/spring-cloud-feignclient-problem/?utm_source=tuicool&utm_medium=referral
 * 创建人：@author xiep
 * 创建时间：2017年9月14日/上午10:30:28
 *
=======
/**   
 * 包名称： com.yh.ycbp.ipoms.config 
 * 类名称：FeignConfiguration 
 * 类描述：解决@FeignClient中的@RequestMapping也被SpringMVC加载的问题解决
 * http://blog.didispace.com/spring-cloud-feignclient-problem/?utm_source=tuicool&utm_medium=referral
 * 创建人：@author xiep 
 * 创建时间：2017年9月14日/上午10:30:28
 *     
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
 */

@Configuration
@ConditionalOnClass({ Feign.class })
public class FeignConfig {
<<<<<<< HEAD
	//TODO
	/*@Bean
=======
	
	@Bean
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	public WebMvcRegistrations feignWebRegistrations() {
		return new WebMvcRegistrationsAdapter() {
			@Override
			public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
				return new FeignRequestMappingHandlerMapping();
			}
		};
<<<<<<< HEAD
	}*/
=======
	}
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066

	private static class FeignRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
		@Override
		protected boolean isHandler(Class<?> beanType) {
			return super.isHandler(beanType) && !AnnotatedElementUtils.hasAnnotation(beanType, FeignClient.class);
		}
	}
<<<<<<< HEAD

=======
 
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
}
