/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年9月20日/上午10:50:57
 * 项目名称：  dfas-common-util
 * 文件名称: PlatformEnum.java
 * 文件描述: @Description: 交易平台枚举
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.enumeration;

/**   
 * 包名称： com.win.dfas.common.enumeration 
 * 类名称：PlatformEnum 
 * 类描述：交易平台枚举
 * 创建人：@author hechengcheng 
 * 创建时间：2019年9月20日/上午10:50:57
 *     
 */
public enum PlatformEnum {

	CW_C1("C1", "场外交易平台", "场外交易平台"),
	HG_H3("H3", "港股通平台（沪）", "港股通平台（沪）"),
	SG_5("5", "国际市场互联平台（深）", "国际市场互联平台（深）"),
	SH_H1("H1", "竞价撮合平台（沪）", "竞价撮合平台（沪）"),
	SH_H2("H2", "综合业务平台（沪）", "综合业务平台（沪）"),
	SH_H5("H5", "固定收益平台（沪）", "固定收益平台（沪）"),
	SZ_S1("S1", "固定收益平台（深）", "固定收益平台（深）"),
	SZ_1("1", "现货集中竞价交易平台（深）", "现货集中竞价交易平台（深）"),
	SZ_2("2", "综合金融服务平台（深）", "综合金融服务平台（深）"),
	SZ_3("3", "非交易处理平台（深）", "非交易处理平台（深）"),
	YH_Y1("Y1", "银行间本币交易平台", "银行间本币交易平台"),
	;
	
	private String platformCode;
	
	private String platformName;
	
	private String platformfullName;

	private PlatformEnum(String platformCode, String platformName, String platformfullName) {
		this.platformCode = platformCode;
		this.platformName = platformName;
		this.platformfullName = platformfullName;
	}

	public String getPlatformCode() {
		return platformCode;
	}

	public String getPlatformName() {
		return platformName;
	}

	public String getPlatformfullName() {
		return platformfullName;
	}
}
