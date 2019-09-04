/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年8月15日/下午6:52:52
 * 项目名称：  dfas-common-util
 * 文件名称: BaseDelReqVO.java
 * 文件描述: @Description: 基础查询请求VO
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.vo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.win.dfas.common.validation.ValidationGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**   
 * 包名称： com.win.dfas.common.vo 
 * 类名称：BaseDelReqVO 
 * 类描述：基础删除请求VO
 * 创建人：@author hechengcheng 
 * 创建时间：2019年8月15日/下午6:52:52
 *     
 */
@Data
public class BaseDelReqVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "ID不能为空", groups = {ValidationGroup.Delete.class})
	@ApiModelProperty(value = "主键ID", example = "单条删除必传")
	private Long id;
	
	@NotEmpty(message = "IDS不能为空", groups = {ValidationGroup.BatchDelete.class})
	@ApiModelProperty(value = "主键ID", example = "批量删除必传")
	private List<Long> ids;

}
