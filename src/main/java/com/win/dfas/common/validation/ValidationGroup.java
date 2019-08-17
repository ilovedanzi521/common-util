/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年8月12日/上午10:59:26
 * 项目名称：  dfas-common-util
 * 文件名称: Add.java
 * 文件描述: @Description: 分组校验类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.validation;

/**
 * 
 * 包名称： com.win.dfas.common.validation 
 * 类名称：ValidationGroup 
 * 类描述：分组校验接口
 * 创建人：@author hechengcheng 
 * 创建时间：2019年8月12日/上午11:10:20
 *
 */
public interface ValidationGroup {
	
	public interface Default {}
	
	public interface Query {}
	
	public interface PageQuery {}

	public interface Add {}
	
	public interface Update {}
	
	public interface Delete {}
	
	public interface BatchAdd {}
	
	public interface BatchUpdate {}
	
	public interface BatchDelete {}
	
	public interface Import {}
	
	public interface Export {}
}
