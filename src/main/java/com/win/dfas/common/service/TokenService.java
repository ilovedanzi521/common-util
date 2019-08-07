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
	
	/**
	 * 
	 * token校验
	 * @Title: checkToken
	 * @param request   
	 * @return: void   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年8月7日/上午11:31:21
	 */
    void checkToken(HttpServletRequest request) ;

    /**
     * 
     * 设置基本用户信息
     * @Title: getUserToken
     * @param request
     * @return
     * @throws
     * @author: zhoujinyin
     * @Date:  2019/6/3/15:17
     */
    void setBaseUserInfoByToken(HttpServletRequest request);
}
