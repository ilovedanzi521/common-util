/****************************************************
 * 创建人：  @author zhoujinyin    
 * 创建时间: 2019/6/3/14:00
 * 项目名称：dfas-common-util
 * 文件名称: DataEntity
 * 文件描述: @Description: 数据entity类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfas.common.entity;

import com.win.dfas.common.util.PrimaryKeyUtil;
import com.win.dfas.common.util.UserUtil;

import java.util.Date;

/**
 * 包名称：com.win.dfas.common.entity
 * 类名称：DataEntity
 * 类描述：数据entity类
 * 创建人：@author zhoujinyin
 * 创建时间：2019/6/3/14:00
 */
public class DataEntity extends BaseEntity {
    /**
     * 删除标记（0：未删除；1：已删除）
     */
    protected Boolean delFlag;

    public DataEntity() {
        super();
        this.delFlag = DEL_FLAG_NORMAL;
    }

    public DataEntity(Long id) {
        super(id);
    }

    @Override
    public void preInsert() {
        Long userId = UserUtil.getUserId();
        this.id = PrimaryKeyUtil.generateId();
        this.createUserId = userId;
        this.createTime = new Date();
        this.updateUserId =  userId;
        this.updateTime = new Date();
    }

    @Override
    public void preUpdate() {
        this.updateUserId = UserUtil.getUserId();
        this.updateTime = new Date();
    }
}
