/****************************************************
 * 创建人：  @author xiep
 * 创建时间: 2017-11-7/16:03:27
 * 项目名称: ycmp-api
 * 文件名称: SwaggerConfig.java
 * 文件描述: @Description Swagger基础配置
 * 公司名称: 深圳市赢和信息技术有限公司
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2017
 *
 ********************************************************/
package com.win.dfas.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * 包名称：com.yhfin.ycmp.api.config
 * 类名称：SwaggerConfig
 * 类描述：Swagger基础配置
 * 创建人：@author wangkai
 * 创建时间：2018年8月6日/下午4:36:14
 *
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = { "com.*"})
public class SwaggerConfig {

	@Bean
    public Docket createRestApi() {
		/**函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现*/
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.*"))
                .paths(PathSelectors.any())
                .build();
    }

	/**
	 *
	 * @Title: apiInfo
	 * @Description: apiInfo()用来创建该Api的基本信息(这些基本信息会展现在文档页面中)
	 * @return
	 * @return: ApiInfo
	 * @throws
	 * @author: wangkai
	 * @Date:  2018年8月6日/下午4:37:16
	 */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("深圳市赢和信息技术有限公司API接口文档")
                .description("")
                .termsOfServiceUrl("http://www.yhfin.com")
                .contact(new Contact("赢和信息", "http://www.yhfin.com", ""))
                .version("1.0")
                .build();
    }
}
