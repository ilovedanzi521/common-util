/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年7月15日/上午10:19:11
 * 项目名称：  dfas-common-util
 * 文件名称: WinExceptionUtil.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.util;

import com.win.dfas.common.exception.IExceptionEnum;
import com.win.dfas.common.exception.UserAuthException;
import com.win.dfas.common.exception.WinException;

/**   
 * 包名称： com.win.dfas.common.util 
 * 类名称：WinExceptionUtil 
 * 类描述：Win异常处理工具类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年7月15日/上午10:19:11
 *     
 */
public final class WinExceptionUtil {

	/**
	 * 
	 * 根据枚举值和枚举值参数返回WinException
	 * @Title: winException
	 * @param exceptionEnum
	 * @param enumArgs 枚举中的参数
	 * @return   
	 * @return: WinException   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月15日/下午12:10:01
	 */
	public static WinException winException(IExceptionEnum exceptionEnum, Object... enumArgs){
        return new WinException(exceptionEnum.getCode(), String.format(exceptionEnum.getMsg(), enumArgs));
    }
	
	/**
	 * 
	 * 根据枚举值和枚举值参数返回WinException
	 * @Title: authException
	 * @param exceptionEnum
	 * @param enumArgs
	 * @return   
	 * @return: UserAuthException   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月15日/下午2:59:09
	 */
	public static UserAuthException authException(IExceptionEnum exceptionEnum, Object... enumArgs){
        return new UserAuthException(exceptionEnum.getCode(), String.format(exceptionEnum.getMsg(), enumArgs));
    }
}
