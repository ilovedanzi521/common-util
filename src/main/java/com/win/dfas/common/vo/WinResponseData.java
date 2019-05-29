/****************************************************
<<<<<<< HEAD
 * 创建人：  @author wangkai
=======
 * 创建人：  @author wangkai    
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
 * 创建时间: 2017-11-8/16:19:52
 * 项目名称: ycmp-auth-center
 * 文件名称: RspBase.java
 * 文件描述: @Description
 * 公司名称: 深圳市赢和信息技术有限公司
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2017
<<<<<<< HEAD
 *
=======
 * 
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
 ********************************************************/
package com.win.dfas.common.vo;

import java.io.Serializable;

/**
<<<<<<< HEAD
 *
 * 包名称： com.dfas.common.vo
 * 类名称：RspBase
 * 类描述：返回响应结果
 * 创建人：@author wangkai
=======
 * 
 * 包名称： com.yhfin.ycmp.authcenter.vo 
 * 类名称：RspBase 
 * 类描述：返回响应结果
 * 创建人：@author wangkai 
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
 * 创建时间：2017年11月8日/下午4:19:48
 *
 */
public class WinResponseData implements Serializable {

	private static final long serialVersionUID = 1L;
<<<<<<< HEAD

	private static final String OPERATION_SUCC = "操作成功";

=======
	
	private static final String OPERATION_SUCC = "操作成功";
	
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	/**
	 * 类型
	 */
	public enum WinRspType {
		/** 成功 */
		SUCC("SUCC", "成功"),
		/** 警告 */
		WARN("WARN", "警告"),
		/** 错误 */
		ERROR("ERROR", "错误"),
		/** 鉴权失败*/
		AUTH_ERROR("AUTH_ERROR", "鉴权失败"),
		/** 唯一性 */
		UNIQUE("UNIQUE", "唯一性");

		private String key;
		private String value;

		WinRspType(String winRspKey, String value) {
			this.key = winRspKey;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}

	}
<<<<<<< HEAD

=======
	
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	/**
	 * 返回状态码(根据不同状态码处理不同业务结果)
	 */
	private String code;
<<<<<<< HEAD

=======
	
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	/**
	 * 返回信息
	 */
	private String msg;
<<<<<<< HEAD

=======
	
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	/**
	 * 返回类型
	 */
	private WinRspType winRspType;

<<<<<<< HEAD

=======
	
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	/***
	 * 数据
	 */
	private transient Object data;

	/**
	 * 初始化一个新创建的 Message 对象，使其表示一个空消息。
	 */
	private WinResponseData() {
<<<<<<< HEAD

	}

	private WinResponseData(WinRspType winRspType) {
		this.winRspType = winRspType;
	}


=======
		
	}
	
	private WinResponseData(WinRspType winRspType) {
		this.winRspType = winRspType;
	}
	
	
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	private WinResponseData(WinRspType winRspType,String msg) {
		this.winRspType = winRspType;
		this.msg = msg;
	}
<<<<<<< HEAD

	/**
	 * 初始化一个新创建的 Message 对象
	 * @param winRspType    类型
=======
	
	/**
	 * 初始化一个新创建的 Message 对象
	 * @param type    类型
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	 * @param msg 内容
	 * @param data    对象
	 */
	private WinResponseData(WinRspType winRspType, String msg, Object data) {
		this.winRspType = winRspType;
		this.msg = msg;
		this.data = data;
	}
<<<<<<< HEAD

=======
	
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	private WinResponseData(String code,Object data) {
		this.code = code;
		this.data = data;
	}
<<<<<<< HEAD

	/**
	 *
=======
	 
	/**
	 * 
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	 * @Title: handleSuccess
	 * @Description: 返回成功消息
	 * @param: @param successMsg 内容
	 * @param: @param args    参数
<<<<<<< HEAD
	 * @param: @return
=======
	 * @param: @return   
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	 * @return: RspData       成功消息
	 * @throws
	 */
	public static WinResponseData handleSuccess(String successMsg, Object args) {
		return new WinResponseData(WinRspType.SUCC, successMsg, args);
	}
<<<<<<< HEAD

	/**
	 *
	 * @Title: handleSuccess
	 * @Description: 返回成功消息
	 * @param: @param successMsg 内容
	 * @param: @return
	 * @return: RspData      成功消息
=======
	
	/**
	 * 
	 * @Title: handleSuccess
	 * @Description: 返回成功消息
	 * @param: @param successMsg 内容
	 * @param: @return   
	 * @return: RspData      成功消息 
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	 * @throws
	 */
	public static WinResponseData handleSuccess(String successMsg) {
		return new WinResponseData(WinRspType.SUCC, successMsg, null);
	}
<<<<<<< HEAD

	/**
	 *
	 * @Title: handleSuccess
	 * @Description: 返回成功消息
	 * @param: @param obj 返回数据
	 * @param: @return
	 * @return: RspData
	 * @throws
	 * @author: wangkai
=======
	
	/**
	 * 
	 * @Title: handleSuccess
	 * @Description: 返回成功消息
	 * @param: @param obj 返回数据
	 * @param: @return   
	 * @return: RspData   
	 * @throws
	 * @author: wangkai 
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	 * @Date:  2017年11月10日/下午1:26:05
	 */
	public static WinResponseData handleSuccess(Object obj) {
		return new WinResponseData(WinRspType.SUCC, OPERATION_SUCC, obj);
	}

	/**
<<<<<<< HEAD
	 *
=======
	 * 
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	 * @Title: handleWarn
	 * @Description: 返回警告消息
	 * @param: @param warnMsg 内容
	 * @param: @param args    参数
<<<<<<< HEAD
	 * @param: @return
	 * @return: RspData       警告消息
	 * @throws
	 * @author: wangkai
	 * @Date:  2017年11月10日/下午1:26:25
	 */
	public static WinResponseData handleWarn(String warnMsg, Object... args) {
		return new WinResponseData(WinRspType.WARN, warnMsg, args);
	}

	/**
	 *
=======
	 * @param: @return   
	 * @return: RspData       警告消息
	 * @throws
	 * @author: wangkai 
	 * @Date:  2017年11月10日/下午1:26:25
	 */
	public static YhResponseData handleWarn(String warnMsg, Object... args) {
		return new YhResponseData(YHRspType.WARN, warnMsg, args);
	}

	/**
	 * 
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	 * @Title: handleError
	 * @Description: 返回错误消息
	 * @param: @param errorMsg 内容
	 * @param: @param args    参数
<<<<<<< HEAD
	 * @param: @return
	 * @return: RspData       错误消息
	 * @throws
	 * @author: wangkai
	 * @Date:  2017年11月10日/下午1:26:49
	 */
	public static WinResponseData handleError(String errorMsg, Object... args) {
		return new WinResponseData(WinRspType.ERROR, errorMsg, args);
	}

	/**
	 *
	 * @Title: handleError
	 * @Description: 返回错误消息
	 * @param: @param errorMsg 出错内容
	 * @param: @return
	 * @return: RspData       返回错误消息
	 * @throws
	 */
	public static WinResponseData handleError(String errorMsg) {
		return new WinResponseData(WinRspType.ERROR, errorMsg, null);
	}

	/**
	 *
	 * @Title: handleAuth
	 * @Description: 返回鉴权错误消息
	 * @param: @param authMsg 内容
	 * @param: @return
	 * @return: RspData
	 * @throws
	 */
	public static WinResponseData handleAuth(String authMsg) {
		return new WinResponseData(WinRspType.AUTH_ERROR, authMsg, null);
	}

=======
	 * @param: @return   
	 * @return: RspData       错误消息
	 * @throws
	 * @author: wangkai 
	 * @Date:  2017年11月10日/下午1:26:49
	 */
	public static YhResponseData handleError(String errorMsg, Object... args) {
		return new YhResponseData(YHRspType.ERROR, errorMsg, args);
	}
	
	/**
	 * 
	 * @Title: handleError
	 * @Description: 返回错误消息
	 * @param: @param errorMsg 出错内容
	 * @param: @return   
	 * @return: RspData       返回错误消息
	 * @throws
	 */
	public static YhResponseData handleError(String errorMsg) {
		return new YhResponseData(YHRspType.ERROR, errorMsg, null);
	}
	
	/**
	 * 
	 * @Title: handleAuth
	 * @Description: 返回鉴权错误消息
	 * @param: @param authMsg 内容
	 * @param: @return   
	 * @return: RspData   
	 * @throws
	 */
	public static YhResponseData handleAuth(String authMsg) {
		return new YhResponseData(YHRspType.AUTH_ERROR, authMsg, null);
	}
	
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	/**
	 * 唯一性校验返回专用
	 * @Title: handleUnique
	 * @Description: 唯一性校验返回专用
<<<<<<< HEAD
	 * @return
	 * @return: YhResponseData
	 * @throws
	 * @author: wangkai
=======
	 * @return   
	 * @return: YhResponseData   
	 * @throws
	 * @author: wangkai 
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	 * @Date:  2017年11月29日/下午1:52:16
	 */
	public static WinResponseData handleUnique(String msg) {
		return new WinResponseData(WinRspType.UNIQUE,msg);
	}

	/**
	 * 获取类型
<<<<<<< HEAD
	 *
=======
	 * 
>>>>>>> 831cd649ecbb7ec7407eabd156bb7909fdefe066
	 * @return 类型
	 */
	public WinRspType getWinRspType() {
		return winRspType;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}


	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

    @Override
    public String toString() {
        return "WinResponseData [code=" + code + ", msg=" + msg + ", winRspType=" + winRspType + ", data=" + data + "]";
    }

}
