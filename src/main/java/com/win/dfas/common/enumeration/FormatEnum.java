/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年8月5日/下午5:11:52
 * 项目名称：  dfas-common-util
 * 文件名称: FormatEnum.java
 * 文件描述: @Description: 格式化枚举
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.enumeration;

/**   
 * 包名称： com.win.dfas.common.enumeration 
 * 类名称：FormatEnum 
 * 类描述：格式化枚举
 * 创建人：@author hechengcheng 
 * 创建时间：2019年8月5日/下午5:11:52
 *     
 */
public enum FormatEnum {

	// 格式化枚举
	DIC_CODE_T_EXPLAIN("SYS_DATA_DICTIONARY-%s-%s", "dicExplain", "根据字典编码转为字典描述"),
	SECURITY_CODE_T_NAME("PARAM_SECURINTY_BASIC_INFO-%s", "securityName", "根据证券代码转为证券名称"),
	;
	
	private String format;
	private String key;
	private String desc;

	FormatEnum(String format, String key, String desc) {
		this.format = format;
		this.key = key;
		this.desc = desc;
	}
	
	public String getFormat() {
		return format;
	}
	
	public String getKey() {
		return key;
	}

	public String getDesc() {
		return desc;
	}
	
}
