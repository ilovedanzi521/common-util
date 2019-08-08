/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年5月30日/下午4:18:37
 * 项目名称：  dfas-common-util
 * 文件名称: BaseRepVO.java
 * 文件描述: @Description: 基础返回VO类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.vo;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.win.dfas.common.annotation.WinFormat;
import com.win.dfas.common.enumeration.FormatEnum;
import com.win.dfas.common.util.LongJsonDeserializer;
import com.win.dfas.common.util.LongJsonSerializer;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**   
 * 包名称： com.win.dfas.common.vo 
 * 类名称：BaseRepVO 
 * 类描述：基础返回VO类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年5月30日/下午4:18:37
 *     
 */
@Data
public class BaseRepVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonSerialize(using = LongJsonSerializer.class)
	@JsonDeserialize(using = LongJsonDeserializer.class)
	@ApiModelProperty(value = "主键ID")
	private Long id;
	
	@ApiModelProperty(value = "创建用户ID")
	private String createUserId;
	
	@ApiModelProperty(value = "创建用户名")
	@WinFormat(value = FormatEnum.SYS_USER_ID_T_NAME, fromField = "createUserId")
	private String createUserName;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	@ApiModelProperty(value = "更新用户ID")
	private String updateUserId;
	
	@ApiModelProperty(value = "更新用户名")
	@WinFormat(value = FormatEnum.SYS_USER_ID_T_NAME, fromField = "updateUserId")
	private String updateUserName;
	
	@ApiModelProperty(value = "更新时间")
	private String updateTime;
}
