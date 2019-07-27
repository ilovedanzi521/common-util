/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年7月27日/下午3:03:27
 * 项目名称：  dfas-common-util
 * 文件名称: DicService.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.service;

/**   
 * 包名称： com.win.dfas.common.service 
 * 类名称：DicService 
 * 类描述：公用字典服务
 * 创建人：@author hechengcheng 
 * 创建时间：2019年7月27日/下午3:03:27
 *     
 */
public interface DicService {

	/**
	 * 
	 * 根据父字典项编码和字典项编码查询字典项信息
	 * @Title: getDicExplain
	 * @param parentDicCode
	 * @param dicCode
	 * @return   
	 * @return: String   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月27日/下午3:04:55
	 */
	String getDicExplain(String parentDicCode, String dicCode);
}
