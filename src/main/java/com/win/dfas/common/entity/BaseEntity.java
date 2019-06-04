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

import com.win.dfas.common.util.PrimaryKeyUtil;
import com.win.dfas.common.util.UserUtil;

import cn.hutool.core.date.DateUtil;
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
	
	private Integer deleteFlag;

	private String createUserId;

	private String createTime;

	private String updateUserId;

	private String updateTime;
	
	/**
	 * 
	 * @Title: preInsert
	 * @Description: 预插入实体公用参数处理  
	 * @return: void   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年6月3日/下午7:01:51
	 */
	public void preInsert() {
        this.id = PrimaryKeyUtil.generateId();
        this.deleteFlag = 0;
        this.createUserId = UserUtil.getUserId();
        this.createTime = DateUtil.now();
    }
	
	/**
	 * 
	 * @Title: preUpdate
	 * @Description: 预修改实体公用参数处理
	 * @return   
	 * @return: void   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年6月3日/下午6:53:18
	 */
    public void preUpdate() {
        this.updateUserId = UserUtil.getUserId();
        this.updateTime = DateUtil.now();
    }
    
    /**
     * 
     * @Title: preDelete
     * @Description: 预删除实体公用参数处理
     * @return   
     * @return: void   
     * @throws
     * @author: hechengcheng 
     * @Date:  2019年6月3日/下午6:55:19
     */
    public void preDelete() {
    	this.preUpdate();
        this.deleteFlag = 1;
    }
}
