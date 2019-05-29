/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年5月29日/上午11:21:47
 * 项目名称：  dfas-common-util
 * 文件名称: BaseVO.java
 * 文件描述: @Description: 
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**   
 * 包名称： com.win.dfas.common.vo 
 * 类名称：BaseVO 
 * 类描述：与展示层交互的基础类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年5月29日/上午11:21:47
 *     
 */
@Getter
@Setter
@ToString
public class BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	
	private String ip;
	
	private String mac;
	
	private String hostName;
	
	private Integer menuId;

	private Integer currentPage;
	
	private Integer pageSize;
	
	
}
