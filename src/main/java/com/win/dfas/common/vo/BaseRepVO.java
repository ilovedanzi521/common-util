/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年5月30日/下午4:18:37
 * 项目名称：  dfas-common-util
 * 文件名称: BaseRepVO.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**   
 * 包名称： com.win.dfas.common.vo 
 * 类名称：BaseRepVO 
 * 类描述：TODO
 * 创建人：@author hechengcheng 
 * 创建时间：2019年5月30日/下午4:18:37
 *     
 */
@Getter
@Setter
@ToString
public class BaseRepVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "主键ID")
	private Long id;
	
	@ApiModelProperty(value = "创建用户ID")
	private Long createUserId;
	
	@ApiModelProperty(value = "创建用户名")
	private String createUserName;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	@ApiModelProperty(value = "更新用户ID")
	private Long updateUserId;
	
	@ApiModelProperty(value = "更新用户名")
	private String updateUserName;
	
	@ApiModelProperty(value = "更新时间")
	private String updateTime;
}
