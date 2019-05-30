/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年5月30日/上午9:07:59
 * 项目名称：  dfas-common-util
 * 文件名称: ExceptionUtils.java
 * 文件描述: @Description: 通用异常工具类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**   
 * 包名称： com.win.dfas.common.util 
 * 类名称：ExceptionUtils 
 * 类描述：通用异常工具类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年5月30日/上午9:07:59
 *     
 */
public final class ExceptionUtils {

	/**
	 * 
	 * @Title: getStackTrace
	 * @Description: 在异常中捕获具体的异常信息
	 * @param throwable
	 * @return   
	 * @return: String 具体异常信息
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年5月30日/上午9:12:02
	 */
	public static String getStackTrace(Throwable throwable) {
		
		StringWriter stringWriter = null;
		
		PrintWriter printWriter = null;
		
		try {
			stringWriter = new StringWriter();

			printWriter = new PrintWriter(stringWriter);

			throwable.printStackTrace(printWriter);

			return stringWriter.toString();
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
}
