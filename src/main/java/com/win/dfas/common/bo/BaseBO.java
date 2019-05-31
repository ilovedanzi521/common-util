/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年5月29日/上午11:33:16
 * 项目名称：  dfas-common-util
 * 文件名称: BaseBO.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.bo;

import java.io.Serializable;

import lombok.Data;

/**   
 * 包名称： com.win.dfas.common 
 * 类名称：BaseBO 
 * 类描述：BO基础对象
 * 创建人：@author hechengcheng 
 * 创建时间：2019年5月29日/上午11:33:16
 *     
 */
@Data
public class BaseBO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	
	private String ip;
	
	private String mac;
	
	private String hostName;
	
	private Integer menuId;

	private Integer currentPage;
	
	private Integer pageSize;
	
}
