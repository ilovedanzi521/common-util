/****************************************************
 * 创建人：  @author zhoujinyin    
 * 创建时间: 2019/5/31/18:48
 * 项目名称：dfas-common-util
 * 文件名称: UserAuthException
 * 文件描述: @Description: 用户鉴权异常
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfas.common.exception;

/**
 * 包名称：com.win.dfas.auth.common.exception.auth
 * 类名称：UserAuthException
 * 类描述：用户鉴权异常
 * 创建人：@author zhoujinyin
 * 创建时间：2019/5/31/18:48
 */
public class UserAuthException extends WinException {

	private static final long serialVersionUID = 1L;
	
	public UserAuthException() {
		super();
	}
	public UserAuthException(String msg) {
		super(msg);
	}

	public UserAuthException(Exception e) {
		super(e);
	}

	public UserAuthException(String msg, Exception e) {
		super(msg, e);
	}

	public UserAuthException(String msg, String logMsg, Exception e) {
		super(msg, logMsg, e);
	}

	public UserAuthException(String code, String msg, String logMsg, Exception e) {
		super(code, msg, logMsg, e);
	}

	public UserAuthException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UserAuthException(String code, String msg) {
		super(code, msg);
	}
	
	public UserAuthException(String code, String msg, String logMsg, Throwable cause) {
		super(code, msg, logMsg, cause);
	}
}
