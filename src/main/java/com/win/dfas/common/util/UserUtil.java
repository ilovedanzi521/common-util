/****************************************************
 * 创建人：  @author zhoujinyin    
 * 创建时间: 2019/6/3/15:54
 * 项目名称：dfas-common-util
 * 文件名称: UserUtil
 * 文件描述: @Description: 用户工具类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfas.common.util;

import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.entity.BaseUserInfo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * 包名称：com.win.dfas.common.util
 * 类名称：UserUtil
 * 类描述：用户工具类
 * 创建人：@author zhoujinyin
 * 创建时间：2019/6/3/15:54
 */
public class UserUtil {
    @Autowired
    private static HttpServletRequest request;

    public static BaseUserInfo getUser() {
        return (BaseUserInfo) request.getAttribute(CommonConstants.USER_KEY);
    }

    public static String getUserId() {
        BaseUserInfo baseUserInfo = (BaseUserInfo) request.getAttribute(CommonConstants.USER_KEY);
        return baseUserInfo.getUserId();
    }
}
