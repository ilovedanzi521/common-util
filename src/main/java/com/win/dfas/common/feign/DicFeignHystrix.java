/****************************************************
 * 创建人: @author lixiuquan    
 * 创建时间: 2019-7-18/15:57
 * 项目名称: dfbp-common-basicparameter
 * 文件名称: BondFeignHystrix.java
 * 文件描述: @Description: 债券feign熔断处理
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/

package com.win.dfas.common.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.win.dfas.common.dto.DicDTO;
import com.win.dfas.common.vo.WinResponseData;

import feign.hystrix.FallbackFactory;

/**
 * 包名称：com.win.dfbp.inst.service.depand
 * 类名称：BondFeignHystrix
 * 类描述：债券feign熔断处理
 * 创建人：@author lixiuquan
 * 创建时间：2019-7-18/15:57
 */
@Component
public class DicFeignHystrix implements FallbackFactory<DicFeign> {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(DicFeignHystrix.class);

    
    @Override
	public DicFeign create(Throwable throwable) {
		return new DicFeign() {
			
			@Override
			public WinResponseData selectDicByCode(DicDTO dto) {
				return handHystrix(throwable);
			}
		};
	}

    /**
     * 熔断处理
     * @Title: handHystrix
     * @param throwable
     * @return: com.win.dfas.common.vo.WinResponseData
     * @throws
     * @author: lixiuquan
     * @Date:  2019-7-18/16:00
     */
    private WinResponseData handHystrix(Throwable throwable) {
        LOGGER.error("服务不存在或网络断开,错误原因:{}", throwable.getMessage());
        return WinResponseData.handleError("服务不存在或网络断开,错误原因:{}", throwable.getMessage());
    }


	
}
