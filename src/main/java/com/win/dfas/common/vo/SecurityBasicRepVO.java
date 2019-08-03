package com.win.dfas.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SecurityBasicRepVO extends BaseRepVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2229057468088131770L;
	

	/**
	 * 证券名称
	 */
	@ApiModelProperty(value = "证券名称")
	private String securityName;
	/**
	 * 证券代码
	 */
	@ApiModelProperty(value = "证券代码")
	private String securityCodeKey;
	/**
	 * 证券全称
	 */
	@ApiModelProperty(value = "证券全称")
	private String securityFullName;
	
}
