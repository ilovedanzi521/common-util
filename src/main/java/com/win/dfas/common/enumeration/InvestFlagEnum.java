/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年9月19日/下午4:39:33
 * 项目名称：  dfas-common-util
 * 文件名称: InvestFlagEnum.java
 * 文件描述: @Description: 投资标志枚举
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.enumeration;

/**   
 * 包名称： com.win.dfas.common.enumeration 
 * 类名称：InvestFlagEnum 
 * 类描述：投资标志枚举
 * 创建人：@author hechengcheng 
 * 创建时间：2019年9月19日/下午4:39:33
 *     
 */
public enum InvestFlagEnum {

	J("J", "交易性金融资产"), 
	F("F", "可供出售类金融资产"), 
	C("C", "持有至到期投资"), 
	Y("Y", "贷款应收款"), 
	;

	private String investFlag;
	private String investFlagName;

	InvestFlagEnum(String investFlag, String investFlagName) {
		this.investFlag = investFlag;
		this.investFlagName = investFlagName;
	}

	public String getInvestFlag() {
		return investFlag;
	}

	public String getInvestFlagName() {
		return investFlagName;
	}

}
