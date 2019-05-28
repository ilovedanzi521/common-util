package com.win.dfas.common.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 包名称：com.win.dfas.common.service
 * 类名称：TokenService
 * 类描述：${TODO}
 * 创建人：@author wanglei
 * 创建时间：2019/5/28/13:37
 */
public interface TokenService {
    void checkToken(HttpServletRequest request) ;
}
