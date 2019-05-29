/****************************************************
 * 创建人：  @author wangkai
 * 创建时间: 2018-3-3/14:48:59
 * 项目名称: ycmp-api
 * 文件名称: WebConfigurer.java
 * 文件描述: @Description web请求编码配置
 * 公司名称: 深圳市赢和信息技术有限公司
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2018
 *
 ********************************************************/
package com.win.dfas.common.config;

import com.win.dfas.common.interceptor.ApiIdempotentInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 *
 * 包名称：com.dfas.common.config
 * 类名称：WebConfigurer
 * 类描述：web请求编码配置
 * 创建人：@author wangkai
 * 创建时间：2018年3月3日/下午2:49:05
 *
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


  /*  @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
        mappings.add("html", "text/html;charset=utf-8");
        mappings.add("json", "text/html;charset=utf-8");
        container.setMimeMappings(mappings);
    }*/
    @Resource
    private ApiIdempotentInterceptor apiIdempotentInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration registration = registry.addInterceptor(apiIdempotentInterceptor);
        // 拦截配置
        registration.addPathPatterns("/**");
        // 排除配置
//        registration.excludePathPatterns("/api/word");
    }

}
