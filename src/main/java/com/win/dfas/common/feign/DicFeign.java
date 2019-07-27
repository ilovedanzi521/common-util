/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年7月27日/下午2:23:03
 * 项目名称：  dfas-common-util
 * 文件名称: DicFeign.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.win.dfas.common.dto.DicDTO;
import com.win.dfas.common.vo.WinResponseData;

/**   
 * 包名称： com.win.dfas.common.feign 
 * 类名称：DicFeign 
 * 类描述：数据字典feign接口
 * 创建人：@author hechengcheng 
 * 创建时间：2019年7月27日/下午2:23:03
 *     
 */
@FeignClient(value = "dfbp-common-basicparameter", fallbackFactory = DicFeignHystrix.class)
public interface DicFeign {

	@PostMapping("/dics/code")
    WinResponseData selectDicByCode(@RequestBody DicDTO dto);
}
