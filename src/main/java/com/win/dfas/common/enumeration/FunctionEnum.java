/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年6月25日/下午6:09:53
 * 项目名称：  dfas-common-util
 * 文件名称: FunctionEnum.java
 * 文件描述: @Description: 功能枚举
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.enumeration;

/**   
 * 包名称： com.win.dfas.common.enumeration 
 * 类名称：FunctionEnum 
 * 类描述：功能枚举
 * 创建人：@author hechengcheng 
 * 创建时间：2019年6月25日/下午6:09:53
 *     
 */
public enum FunctionEnum {

	ADD(0, "新增"),
	UPDATE(1, "修改"),
	DELETE(2, "删除"),
	IMPORT(3, "导入"),
	EXPORT(4, "导出"),
    ;

    private Integer status;
    private String value;

    FunctionEnum(Integer status, String value) {
        this.status = status;
        this.value = value;
    }

    public Integer getStatus() {
		return status;
	}

	public String getValue() {
        return value;
    }
	
	public static String valueOf(Integer status) {
		
		String value = null;
		
		for(FunctionEnum functionEnum : FunctionEnum.values()) {
			if (functionEnum.status == status) {
				value = functionEnum.getValue();
				break;
			}
		}
		
		return value;
	}
}
