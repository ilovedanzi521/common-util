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
package com.dfas.common.config;

import org.springframework.context.annotation.Configuration;

/**
 * 
 * 包名称：com.yhfin.ycmp.api.config 
 * 类名称：WebConfigurer 
 * 类描述：web请求编码配置
 * 创建人：@author wangkai 
 * 创建时间：2018年3月3日/下午2:49:05
 *
 */
@Configuration
public class WebMvcConfig implements EmbeddedServletContainerCustomizer {

    /**
     * Customize the Servlet engine: Mime types, the document root, the cache.
     */
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
        mappings.add("html", "text/html;charset=utf-8");
        mappings.add("json", "text/html;charset=utf-8");
        container.setMimeMappings(mappings);
    }

}
