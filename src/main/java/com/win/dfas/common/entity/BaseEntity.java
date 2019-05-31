/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年5月29日/上午10:59:19
 * 项目名称：  dfas-common-util
 * 文件名称: BaseEntity.java
 * 文件描述: @Description: 
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.entity;

import java.io.Serializable;

import lombok.Data;

/**   
 * 包名称： com.win.dfas.common.entity 
 * 类名称：BaseEntity 
 * 类描述：数据库对应的实体基础类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年5月29日/上午10:59:19
 *     
 */
@Data
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Integer deleteFlag; // 逻辑删除标志: 0-未删除、1-已删除
	
	private Long createUserId;
	
	private String createTime;
	
	private Long updateUserId;
	
	private String updateTime;

}
