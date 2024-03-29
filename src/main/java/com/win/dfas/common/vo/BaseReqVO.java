/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年5月30日/下午4:16:10
 * 项目名称：  dfas-common-util
 * 文件名称: BaseReqVO.java
 * 文件描述: @Description: 基础请求VO类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.vo;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.win.dfas.common.util.LongJsonDeserializer;
import com.win.dfas.common.util.LongJsonSerializer;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**   
 * 包名称： com.win.dfas.common.vo 
 * 类名称： BaseReqVO
 * 类描述：基础请求VO类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年5月30日/下午4:16:10
 *     
 */
@Data
public class BaseReqVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonSerialize(using = LongJsonSerializer.class)
	@JsonDeserialize(using = LongJsonDeserializer.class)
	@ApiModelProperty(value = "主键ID")
	private Long id;
	
	@JsonSerialize(using = LongJsonSerializer.class)
	@JsonDeserialize(using = LongJsonDeserializer.class)
	@ApiModelProperty(value = "请求菜单ID")
	private Long reqMenuId;

	@ApiModelProperty(value = "请求当前页数")
	private Integer reqPageNum;
	
	@ApiModelProperty(value = "请求每页大小")
	private Integer reqPageSize;
}
