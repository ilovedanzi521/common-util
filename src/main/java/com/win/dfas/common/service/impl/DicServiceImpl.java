/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年7月27日/下午3:05:29
 * 项目名称：  dfas-common-util
 * 文件名称: DicServiceImpl.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.win.dfas.common.dto.DicDTO;
import com.win.dfas.common.enumeration.CommonExceptionEnum;
import com.win.dfas.common.feign.DicFeign;
import com.win.dfas.common.service.DicService;
import com.win.dfas.common.util.WinExceptionUtil;
import com.win.dfas.common.vo.DicRepVO;
import com.win.dfas.common.vo.WinResponseData;
import com.win.dfas.common.vo.WinResponseData.WinRspType;

import cn.hutool.core.util.ObjectUtil;

/**   
 * 包名称： com.win.dfas.common.service.impl 
 * 类名称：DicServiceImpl 
 * 类描述：TODO
 * 创建人：@author hechengcheng 
 * 创建时间：2019年7月27日/下午3:05:29
 *     
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DicServiceImpl implements DicService {
	
	@Autowired
	DicFeign dicFeigin;

	@Override
	public String getDicExplain(String parentDicCode, String dicCode) {
		DicDTO dto = new DicDTO();
		dto.setParentDicCode(parentDicCode);
		dto.setDicCode(dicCode);
		
		// 调用Feign接口
		WinResponseData winResponseData = call(dto);
		
		if (ObjectUtil.isEmpty(winResponseData.getData())) {
			return null;
		}
		
		DicRepVO repVO = JSON.parseObject(JSON.toJSONString(winResponseData.getData()), DicRepVO.class);
    	
    	if (ObjectUtil.isEmpty(repVO)) {
			return null;
		}
		
		return repVO.getDicExplain();
	}
	
	/**
	 * 
	 * Feign接口调用
	 * @Title: call
	 * @param dto
	 * @return   
	 * @return: WinResponseData   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月27日/下午3:34:52
	 */
	private WinResponseData call(DicDTO dto) {
		
		WinResponseData winResponseData = dicFeigin.selectDicByCode(dto);
		
		// 调用异常
		if (WinRspType.SUCC.getKey().equals(winResponseData.getWinRspType().getKey()) == false) {
			throw WinExceptionUtil.winException(CommonExceptionEnum.FEIGN_EXCEPTION, winResponseData.getMsg());
		}
		
		return winResponseData;
	}

}
