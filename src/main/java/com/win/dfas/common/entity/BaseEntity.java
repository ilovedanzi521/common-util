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
import java.util.Date;

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
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Long id;

	protected Long createUserId;

	protected Date createTime;

	protected Long updateUserId;

	protected Date updateTime;

	public static final Boolean DEL_FLAG_NORMAL = false;
	public static final Boolean DEL_FLAG_DELETE = true;

	public BaseEntity() {

	}

	public BaseEntity(Long id) {
		this();
		this.id = id;
	}

	/**
	 * 插入之前执行方法，子类实现
	 */
	public abstract void preInsert();

	/**
	 * 更新之前执行方法，子类实现
	 */
	public abstract void preUpdate();

}
