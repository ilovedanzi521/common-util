/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年7月15日/上午11:14:11
 * 项目名称：  dfas-common-util
 * 文件名称: IExceptionEnum.java
 * 文件描述: @Description: 异常枚举接口
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.exception;

/**   
 * 包名称： com.win.dfas.common.exception 
 * 类名称：IExceptionEnum 
 * 类描述：异常枚举接口
 * 创建人：@author hechengcheng 
 * 创建时间：2019年7月15日/上午11:14:11
 *     
 */
public interface IExceptionEnum {

	/**
	 * 
	 * 获取异常编码
	 * @Title: getCode
	 * @return   
	 * @return: String   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月15日/上午11:14:57
	 */
	String getCode();
	
	/**
	 * 
	 * 获取异常名称
	 * @Title: getMsg
	 * @return   
	 * @return: String   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月15日/上午11:15:14
	 */
	String getMsg();
}
