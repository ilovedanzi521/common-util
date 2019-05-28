/**
 * 创建人：     @author wangkai
 * 创建时间: 2017年12月21日/下午2:23:51
 * 项目名称：  ycmp-api
 * 文件名称: RollbackException.java
 * 文件描述: @Description: 自定义回滚异常
 * 公司名称: 深圳市赢和信息技术有限公司
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2017
 *
 */
package com.win.dfas.common.exception;

/**
 * 包名称： com.yhfin.ycmp.api.exception
 * 类名称：RollbackException
 * 类描述：自定义回滚异常,如需数据回滚，可抛出此异常
 * 创建人：@author wangkai
 * 创建时间：2017年12月21日/下午2:23:51
 *
 */
public class RollbackException extends RuntimeException {

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
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the logMsg
	 */
	public String getLogMsg() {
		return logMsg;
	}
	/**
	 * @param logMsg the logMsg to set
	 */
	public void setLogMsg(String logMsg) {
		this.logMsg = logMsg;
	}
	/**
	 * @param code
	 * @param msg
	 * @param logMsg
	 */
	public RollbackException(String code, String msg, String logMsg) {
		super();
		this.code = code;
		this.msg = msg;
		this.logMsg = logMsg;
	}
	/**
	 * @param code
	 * @param msg
	 */
	public RollbackException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

}
