/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年9月20日/上午10:45:36
 * 项目名称：  dfas-common-util
 * 文件名称: MarketEnum.java
 * 文件描述: @Description: 交易市场枚举
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.enumeration;

/**   
 * 包名称： com.win.dfas.common.enumeration 
 * 类名称：MarketEnum 
 * 类描述：交易市场枚举
 * 创建人：@author hechengcheng 
 * 创建时间：2019年9月20日/上午10:45:36
 *     
 */
public enum MarketEnum {

	SH("SH", "上交所", "上海交易所"),
	SZ("SZ", "深交所", "深圳交易所"),
	YH("YH", "银行间", "银行间"),
	CW("CW", "场外", "场外"),
	HG("HG", "沪港通", "沪港通"),
	SG("SG", "深港通", "深港通"), 
	;

	private String marketcode;
	
	private String marketName;
	
	private String marketFullName;

	private MarketEnum(String marketcode, String marketName, String marketFullName) {
		this.marketcode = marketcode;
		this.marketName = marketName;
		this.marketFullName = marketFullName;
	}

	public String getMarketcode() {
		return marketcode;
	}

	public String getMarketName() {
		return marketName;
	}

	public String getMarketFullName() {
		return marketFullName;
	}
}
