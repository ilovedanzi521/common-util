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
	
	/**
	 * 
	 * 包名称： com.win.dfas.common.enumeration 
	 * 类名称：FundPathEnum 
	 * 类描述：交易方向-资金方向枚举
	 * 创建人：@author hechengcheng 
	 * 创建时间：2019年8月20日/下午12:08:35
	 *
	 */
	public enum FundPathEnum {

		NOTHING("0", "无"),
		INCREASE("1", "资金增加"),
		REDUCE("2", "资金减少"),
	    ;

	    private String path;
	    private String pathName;

		private FundPathEnum(String path, String pathName) {
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
			
			for(FundPathEnum pathEnum : FundPathEnum.values()) {
				if (pathEnum.path.equals(path)) {
					pathName = pathEnum.getPathName();
					break;
				}
			}
			
			return pathName;
		}
	}
	
	/**
	 * 
	 * 包名称： com.win.dfas.common.enumeration 
	 * 类名称：SecurityPathEnum 
	 * 类描述：交易方向-证券方向枚举
	 * 创建人：@author hechengcheng 
	 * 创建时间：2019年8月20日/下午12:08:35
	 *
	 */
	public enum SecurityPathEnum {

		NOTHING("0", "无"),
		INCREASE("1", "证券增加"),
		REDUCE("2", "证券减少"),
		FROZEN("3", "证券冻结"),
		THAW("4", "证券解冻"),
		PLEDGE("5", "证券质押"),
		RELEASE("6", "证券解押"),
	    ;

	    private String path;
	    private String pathName;

		private SecurityPathEnum(String path, String pathName) {
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
			
			for(SecurityPathEnum pathEnum : SecurityPathEnum.values()) {
				if (pathEnum.path.equals(path)) {
					pathName = pathEnum.getPathName();
					break;
				}
			}
			
			return pathName;
		}
	}
}
