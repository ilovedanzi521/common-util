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
    SYS_USER_ID_T_NAME("SYS_USER-%s", "userName", "根据用户ID转为用户名称"),
	SECURITY_CODE_T_NAME("PARAM_SECURINTY_BASIC_INFO-%s", "securityName", "根据证券代码转为证券名称"),
	SECURITY_CODE_T_MARKETNAME("PARAM_SECURINTY_BASIC_INFO-%s", "marketName", "根据证券代码转为交易市场名称"),
    SECURITY_CODE_T_TYPE("PARAM_SECURINTY_BASIC_INFO-%s", "securityType", "根据证券代码转为证券类型"),
    SECURITY_CODE_T_TYPENAME("PARAM_SECURINTY_BASIC_INFO-%s", "securityTypeName", "根据证券代码转为证券类别名称"),
    SECURITY_CODE_T_ASSETTYPENAME("PARAM_SECURINTY_BASIC_INFO-%s", "assetTypeName", "根据证券代码转为证券大类名称"),
	SECURITY_CODE_T_ASSETTYPE("PARAM_SECURINTY_BASIC_INFO-%s", "assetType", "根据证券代码转为证券大类"),
	FUND_NO_T_NAME("PROD_FUND_INFO-%s", "fundName", "根据产品序号转为产品名称"),
	FUND_NO_T_CODE("PROD_FUND_INFO-%s", "fundCode", "根据产品序号转为产品代码"),
	PORTFOLIO_NO_T_NAME("PROD_PORTFOLIO-%s", "portfolioName", "根据组合序号转为组合名称"),
	TRADEDIRECTION_CODE_T_NAME("PARAM_TRANSACTION_DIRECTION-%s", "transactionDirectionName", "根据交易方向代码转为交易方向名称"),
	TRADEDIRECTION_CODE_T_MARKETCODENAME("PARAM_TRANSACTION_DIRECTION-%s", "marketCodeName", "根据交易方向代码转为交易市场名称"),
	TRADEDIRECTION_CODE_T_DECLAREPATHNAME("PARAM_TRANSACTION_DIRECTION-%s", "declarePathName", "根据交易方向代码转为申报方向名称"),
	STOCKHOLDER_CODE_T_NAME("PROD_STOCKHOLDER-%s", "stockholderName", "根据股东代码转为股东名称"),
	SEAT_CODE_T_NAME("PROD_SEAT-%s", "seatName", "根据席位代码转为席位名称"),
	PROD_ASSET_UNIT("PROD_ASSET_UNIT-%s", "assetUnitName", "根据资产单元No获取资产名称Name"),
	CASH_ACCOUNT_NO_T_NAME("PROD_CASH_ACCOUNT-%s", "accountName", "根据现金账户序号转为账户名称"),
	CASH_ACCOUNT_NO_T_CODE("PROD_CASH_ACCOUNT-%s", "accountCode", "根据现金账户序号转为账户账号"),
	CURRENCY_CODE_T_NAME("PARAM_CURRENCY-%s", "currencyName", "根据币种代码转为币种名称"),
	FUND_NO_T_ESCROW_ACCOUNT_CODE("PROD_ESCROW_ACCOUNT-%s", "escrowAccountCode", "根据产品代码转为托管账户账号"),
	FUND_NO_T_ESCROW_ACCOUNT_OPEN_BANK("PROD_ESCROW_ACCOUNT-%s", "escrowOpenBank", "根据产品代码转为托管账户开户行"),
	FUND_NO_T_ESCROW_ACCOUNT_NAME("PROD_ESCROW_ACCOUNT-%s", "escrowAccountName", "根据产品代码转为托管账户名称"),
	FARE_CODE_T_TYPE("PARAM_STANDARD_FARE-%s", "fareType", "根据费用代码转为费用类别"),
	RIVAL_NO_T_NAME("PARAM_RIVAL_INFO-%s", "rivalName", "根据对手方序号转为对手方名称"),
	SECURITY_TYPE_T_NAME("PARAM_SECURINTY_TYPE_INFO-%s", "securityTypeName", "根据证券类型转为证券类型name"),
	SYS_TRADE_DAY("SYS_TRADE_DAY-%s", "marketCode", "根据证券类型转为证券类型name"),
	MARKET_CODE_NAME("PARAM_MARKET-%s","marketCode","根据交易市场代码转换为交易市场名称"),
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
