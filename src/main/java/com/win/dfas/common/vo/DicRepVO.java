/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年7月27日/下午3:28:35
 * 项目名称：  dfas-common-util
 * 文件名称: DicRepVO.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.vo;

import lombok.Data;

/**   
 * 包名称： com.win.dfas.common.vo 
 * 类名称：DicRepVO 
 * 类描述：TODO
 * 创建人：@author hechengcheng 
 * 创建时间：2019年7月27日/下午3:28:35
 *     
 */
@Data
public class DicRepVO extends BaseRepVO {

	private static final long serialVersionUID = 1L;

	/**
	 * 数据字典项父编码
	 */
	private String parentDicCode;
	
	/**
	 * 数据字典项编码
	 */
	private String dicCode;
	
	/**
	 * 字典项描述
	 */
	private String dicExplain;
}
