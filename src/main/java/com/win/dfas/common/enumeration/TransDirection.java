/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年8月20日/下午12:04:53
 * 项目名称：  dfas-common-util
 * 文件名称: TransDirection.java
 * 文件描述: @Description: 交易方向枚举类接口
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.enumeration;

/**   
 * 包名称： com.win.dfas.common.enumeration 
 * 类名称：TransDirection 
 * 类描述：交易方向枚举
 * 创建人：@author hechengcheng 
 * 创建时间：2019年8月20日/下午12:04:53
 *     
 */
public interface TransDirection {

	/**
	 * 
	 * 包名称： com.win.dfas.common.enumeration 
	 * 类名称：DeclarePathEnum 
	 * 类描述：交易方向-申报方向枚举
	 * 创建人：@author hechengcheng 
	 * 创建时间：2019年8月20日/下午12:08:35
	 *
	 */
	public enum DeclarePathEnum {

		NOTHING("0", "无"),
		BUY("1", "买入"),
		SALE("2", "卖出"),
	    ;

	    private String path;
	    private String pathName;

		private DeclarePathEnum(String path, String pathName) {
			this.path = path;
			this.pathName = pathName;
		}
		
		public String getPath() {
			return path;
		}

		public String getPathName() {
			return pathName;
		}

		public static String getPathName(String path) {
			
			String pathName = null;
			
			for(DeclarePathEnum pathEnum : DeclarePathEnum.values()) {
				if (pathEnum.path.equals(path)) {
					pathName = pathEnum.getPathName();
					break;
				}
			}
			
			return pathName;
		}
	}
}
