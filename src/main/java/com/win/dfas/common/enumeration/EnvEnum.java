/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年7月2日/上午11:45:16
 * 项目名称：  dfas-common-util
 * 文件名称: EnvEnum.java
 * 文件描述: @Description: 环境枚举
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.enumeration;

/**   
 * 包名称： com.win.dfas.common.enumeration 
 * 类名称：EnvEnum 
 * 类描述：环境枚举
 * 创建人：@author hechengcheng 
 * 创建时间：2019年7月2日/上午11:45:16
 *     
 */
public enum EnvEnum {

	// 环境定义
	DEV("dev", "dev环境"), 
	TEST("test", "test环境"), 
	SIT("sit", "sit环境"), 
	UAT("uat", "uat环境"), ;

	private String env;
	private String value;

	EnvEnum(String env, String value) {
		this.env = env;
		this.value = value;
	}

	public String getEnv() {
		return env;
	}

	public String getValue() {
		return value;
	}

	public static String envValue(String env) {

		String value = null;

		for (EnvEnum envEnum : EnvEnum.values()) {
			if (envEnum.env.equals(env)) {
				value = envEnum.getValue();
				break;
			}
		}

		return value;
	}
}
