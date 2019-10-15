/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年7月2日/上午11:45:16
 * 项目名称：  dfas-common-util
 * 文件名称: ExportEnum.java
 * 文件描述: @Description: 环境枚举
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.enumeration;

/**   
 * 包名称： com.win.dfas.common.enumeration 
 * 类名称：ExportEnum 
 * 类描述：导出枚举
 * 创建人：@author hechengcheng 
 * 创建时间：2019年7月2日/上午11:45:16
 *     
 */
public enum ExportEnum {

	ALL("ALL", "导出全部"), 
	CURRENT_PAGE("CURRENT_PAGE", "导出当前页"), 
	SELECTED("SELECTED", "导出选中"), 
	;
	private String type;
	private String name;

	ExportEnum(String type, String name) {
		this.type = type;
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}
}
