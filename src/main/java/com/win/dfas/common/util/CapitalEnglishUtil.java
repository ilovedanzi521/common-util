/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年6月24日/下午8:01:16
 * 项目名称：  dfas-common-util
 * 文件名称: CapitalEnglishUtil.java
 * 文件描述: @Description: 大写英文字母工具类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.util;

/**   
 * 包名称： com.win.dfas.common.util 
 * 类名称：CapitalEnglishUtil 
 * 类描述：大写英文字母工具类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年6月24日/下午8:01:16
 *     
 */
public class CapitalEnglishUtil {

	/**
	 * 大写英文字母A-Z
	 */
    private static final String[] ATZ = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    
    /**
     * 大写英文字母长度
     */
    private static final int ATZ_LENGTH = 26;
    
    /**
     * 
     * @Title: toCapital
     * @Description: 根据数字转换为大写字母
     * @param num
     * @return   
     * @return: String   
     * @throws
     * @author: hechengcheng 
     * @Date:  2019年6月24日/下午8:06:26
     */
    public static String toCapital(Integer num) {
    	
    	StringBuffer buffer = new StringBuffer();
    	
    	if (num == null) {
			return null;
		}
    	
    	// 高位
    	int heightPosition = (int)(num / Math.pow(ATZ_LENGTH, 1));
    	
    	// 低位
    	int lowPosition = (int)(num % Math.pow(ATZ_LENGTH, 1));
    	
    	if (heightPosition > 0) {
    		buffer.append(ATZ[heightPosition - 1]);
		}
    	
    	buffer.append(ATZ[lowPosition]);
    	
    	return buffer.toString();
    }
}
