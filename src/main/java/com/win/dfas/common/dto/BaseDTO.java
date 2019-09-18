/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年5月29日/上午11:32:17
 * 项目名称：  dfas-common-util
 * 文件名称: BaseDTO.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.dto;

import java.io.Serializable;

import lombok.Data;

/**   
 * 包名称： com.win.dfas.common.dto 
 * 类名称：BaseDTO 
 * 类描述：服务之间的数据转换基础类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年5月29日/上午11:32:17
 *     
 */
@Data
public class BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String userId;
}
