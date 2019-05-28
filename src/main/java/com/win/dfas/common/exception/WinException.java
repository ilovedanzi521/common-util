/****************************************************
 * 创建人：  @author wangkai    
 * 创建时间: 2017-11-8/15:10:31
 * 项目名称: ycmp-api
 * 文件名称: YhException.java
 * 文件描述: @Description 自定义异常
 * 公司名称: 深圳市赢和信息技术有限公司
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2017
 * 
 ********************************************************/

package com.win.dfas.common.exception;


/**
 * 
 * 包名称： com.yhfin.ycmp.api.exception
 * 类名称：YhException
 * 类描述：自定义异常 创建人：@author
 * wangkai 创建时间：2017年11月8日/下午3:10:28
 *
 */
public class WinException extends RuntimeException {

	/**
	 * @Fields serialVersionUID
	 */
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

	public WinException() {
		super();
	}


	public WinException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public WinException(Exception e) {
		super(e);
		this.logMsg = e.getMessage();
	}

	public WinException(String msg, Exception e) {
		super(e);
		this.msg = msg;
		this.logMsg = e.getMessage();
	}

	public WinException(String msg, String logMsg, Exception e) {
		super(e);
		this.msg = msg;
		this.logMsg = logMsg;
	}

	public WinException(String code, String msg, String logMsg, Exception e) {
		super(e);
		this.code = code;
		this.msg = msg;
		this.logMsg = logMsg;
	}

	public WinException(String msg, Throwable cause) {
		super(cause);
		this.setStackTrace(cause.getStackTrace());
		this.msg = msg;
	}

	public WinException(String code, String msg) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}

	public YhException(String code, String msg, Throwable cause) {
		super(msg, cause);
		this.msg = msg;
		this.code = code;
	}

	public WinException(String code, String msg, String logMsg, Throwable cause) {
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
