/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年8月15日/上午10:05:28
 * 项目名称：  dfas-common-util
 * 文件名称: BaseQryReqVO.java
 * 文件描述: @Description: 基础查询请求VO
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.vo;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.win.dfas.common.validation.ValidationGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**   
 * 包名称： com.win.dfas.common.vo 
 * 类名称：BaseQryReqVO 
 * 类描述：基础查询请求VO
 * 创建人：@author hechengcheng 
 * 创建时间：2019年8月15日/上午10:05:28
 *     
 */
@Data
public class BaseQryReqVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "请求当前页数", notes = "分页查询必传")
	@Min(message = "请求当前页数必须大于0", value = 1, groups = {ValidationGroup.PageQuery.class})
	@NotNull(message = "请求当前页数不能为空", groups = {ValidationGroup.PageQuery.class})
	private Integer reqPageNum;
	
	@ApiModelProperty(value = "请求每页大小", notes = "分页查询必传")
	@Min(message = "请求每页大小必须大于0", value = 1, groups = {ValidationGroup.PageQuery.class})
	@NotNull(message = "请求每页大小不能为空", groups = {ValidationGroup.PageQuery.class})
	private Integer reqPageSize;

}
