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
public class UserAuthException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 异常对应的返回码
	 */
	private String code;

	/**
	 * 异常对应的描述信息
	 */
	private String msg;
	
	/**
	 * 日志信息
	 */
	private String logMsg;
	
	public UserAuthException() {
		super();
	}


	public UserAuthException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public UserAuthException(Exception e) {
		super(e);
		this.logMsg = e.getMessage();
	}

	public UserAuthException(String msg, Exception e) {
		super(e);
		this.msg = msg;
		this.logMsg = e.getMessage();
	}

	public UserAuthException(String msg, String logMsg, Exception e) {
		super(e);
		this.msg = msg;
		this.logMsg = logMsg;
	}

	public UserAuthException(String code, String msg, String logMsg, Exception e) {
		super(e);
		this.code = code;
		this.msg = msg;
		this.logMsg = logMsg;
	}

	public UserAuthException(String msg, Throwable cause) {
		super(cause);
		this.setStackTrace(cause.getStackTrace());
		this.msg = msg;
	}

	public UserAuthException(String code, String msg) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	public UserAuthException(String code, String msg, String logMsg, Throwable cause) {
		super(msg, cause);
		this.msg = msg;
		this.code = code;
		this.logMsg = logMsg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public String getLogMsg() {
		return logMsg;
	}
   
}
