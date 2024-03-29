package com.win.dfas.common.enumeration;
/**
 * 
 * 包名称： com.win.dfas.common.constant 
 * 类名称：CommonEmun 
 * 类描述：把枚举类型的数据都放到该类
 * 创建人：@author tandun 
 * 创建时间：2019年8月14日/上午10:40:58
 *
 */
	
public enum EmunParam implements IEmunParam {
	
	PROD_CONSIGNOR_TYPE_NO("1", "产品管理委托人目录一级委托人类别");

    /**
     * 枚举对应的编号
     */
	private String emunValue;
	
	/**
	 * 枚举对应的描述
	 */
	private String emunDec;

	public String getEmunValue() {
		return emunValue;
	}

	public void setEmunValue(String emunValue) {
		this.emunValue = emunValue;
	}

	public String getEmunDec() {
		return emunDec;
	}

	public void setEmunDec(String emunDec) {
		this.emunDec = emunDec;
	}

	private EmunParam(String emunValue, String emunDec) {
		this.emunValue = emunValue;
		this.emunDec = emunDec;
	}
	

	/**
     * 
     * @Title: emunIsValid
     * @Description: 进行名称校验及值的校验
     * @param name
     * @param value
     * @return: boolean   
     * @throws
     * @author: tandun 
     * @Date:  2019年8月16日/上午11:42:31
     */
	public boolean emunIsValid(String name, String value) {
		for (EmunParam emunParam : EmunParam.values()) {
			if (emunParam.name().equals(name) && emunParam.getEmunValue().equals(value)) {
				return true;
			}
		}
		return false;
	}

}
