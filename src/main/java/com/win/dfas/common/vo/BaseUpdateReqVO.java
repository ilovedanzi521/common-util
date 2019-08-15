/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年8月15日/下午6:51:30
 * 项目名称：  dfas-common-util
 * 文件名称: BaseUpdateReqVO.java
 * 文件描述: @Description: 基础更新请求VO
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**   
 * 包名称： com.win.dfas.common.vo 
 * 类名称：BaseUpdateReqVO 
 * 类描述：基础更新请求VO
 * 创建人：@author hechengcheng 
 * 创建时间：2019年8月15日/下午6:51:30
 *     
 */
public class BaseUpdateReqVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "主键ID")
	private Long id;

}
