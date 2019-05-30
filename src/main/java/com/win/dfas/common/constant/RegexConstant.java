/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年5月30日/下午2:49:26
 * 项目名称：  dfas-common-util
 * 文件名称: RegexConstant.java
 * 文件描述: @Description: 正则表达式常量
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.constant;

/**   
 * 包名称： com.win.dfas.common.constant 
 * 类名称：RegexConstant 
 * 类描述：正则表达式常量
 * 创建人：@author hechengcheng 
 * 创建时间：2019年5月30日/下午2:49:26
 *     
 */
public final class RegexConstant {

	// YYYY-MM-DD格式
	public static final String DATE = "^[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
	
	// YYYY-MM-DD HH:MM:SS格式
	public static final String DATE_TIME = "^[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])\\s+(20|21|22|23|[0-1]\\d):[0-5]\\d:[0-5]\\d$";
	
}
