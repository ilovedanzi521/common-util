/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年6月24日/上午9:51:58
 * 项目名称：  dfas-common-util
 * 文件名称: CommonExceptionEnum.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.enumeration;

import com.win.dfas.common.exception.IExceptionEnum;

/**   
 * 包名称： com.win.dfas.auth.common.enumeration 
 * 类名称：CommonExceptionEnum 
 * 类描述：通用异常枚举
 * 创建人：@author hechengcheng 
 * 创建时间：2019年6月24日/上午9:51:58
 *     
 */
public enum CommonExceptionEnum implements IExceptionEnum {

	// 指令管理异常枚举
	FEIGN_EXCEPTION("100100", "Feign调用异常[%s]"),
	FORMAT_EXCEPTION("100101", "数据转换异常"),
	FORMAT_MAX_LEVEL_FIELD("100102", "数据转换最大支持[%s]级属性"),
	SERVICE_NOT_DEFINED("100103", "服务未定义"),
	;

	private String code;
	private String msg;

	CommonExceptionEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMsg() {
		return msg;
	}
	
}
