/**
<<<<<<< HEAD
 * 创建人：     @author xiepan
=======
 * 创建人：     @author xiepan    
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
 * 创建时间: 2018年3月20日/下午1:43:40
 * 项目名称：  ycmp-api
 * 文件名称: FeignSessionConfig.java
 * 文件描述: @Description:
 *
 * All rights Reserved, Designed By
 * @Copyright:2016-2018
<<<<<<< HEAD
 *
 */
package com.win.dfas.common.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import feign.RequestInterceptor;
import feign.RequestTemplate;
=======
 * 
 */
package com.dfas.common.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

<<<<<<< HEAD
/**
 * 包名称： com.yhfin.ycmp.api.config
 * 类名称：FeignSessionConfig
 * 类描述：解决session在feign接口间共享，解决feign接口丢失session问题
 * 创建人：@author xiepan
 * 创建时间：2018年3月20日/下午1:43:40
 *
=======
/**   
 * 包名称： com.yhfin.ycmp.api.config 
 * 类名称：FeignSessionConfig 
 * 类描述：解决session在feign接口间共享，解决feign接口丢失session问题
 * 创建人：@author xiepan 
 * 创建时间：2018年3月20日/下午1:43:40
 *     
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
 */
@Configuration
public class FeignSessionConfig implements RequestInterceptor {

<<<<<<< HEAD
  /*  @Bean
    public FeignHystrixConcurrencyStrategy feignHystrixConcurrencyStrategy() {
      return new FeignHystrixConcurrencyStrategy();
    }*/

    @Override
    public void apply(RequestTemplate template) {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
          return;
        }

        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
=======
    @Bean  
    public FeignHystrixConcurrencyStrategy feignHystrixConcurrencyStrategy() {  
      return new FeignHystrixConcurrencyStrategy();  
    }
  
    @Override
    public void apply(RequestTemplate template) {    
      
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();    
        if (requestAttributes == null) {    
          return;    
        }    
      
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();         
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
        String clientSessionID = "";
        Cookie[] cookies= request.getCookies();
        if (cookies == null ) {
            return;
        }
<<<<<<< HEAD
        for (Cookie c : cookies) {
            if (c.getName().equals("SESSION")) {
                clientSessionID = c.getValue();
                template.header("Cookie", "SESSION=" + clientSessionID);
            }
        }
      }
=======
        for (Cookie c : cookies) {    
            if (c.getName().equals("SESSION")) {  
                clientSessionID = c.getValue();  
                template.header("Cookie", "SESSION=" + clientSessionID); 
            }  
        }
      }    
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
}
