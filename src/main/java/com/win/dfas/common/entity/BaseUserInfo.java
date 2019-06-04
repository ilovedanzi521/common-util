/****************************************************
 * 创建人：  @author zhoujinyin    
 * 创建时间: 2019/6/3/15:44
 * 项目名称：dfas-common-util
 * 文件名称: BaseUserInfo
 * 文件描述: @Description: 基本用户实体类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfas.common.entity;

/**
 * 包名称：com.win.dfas.common.entity
 * 类名称：BaseUserInfo
 * 类描述：基本用户实体类
 * 创建人：@author zhoujinyin
 * 创建时间：2019/6/3/15:44
 */
public class BaseUserInfo {
    private String userId;
    private String loginName;
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}