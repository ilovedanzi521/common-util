/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年7月31日/下午5:49:14
 * 项目名称：  dfas-common-util
 * 文件名称: DicUtil.java
 * 文件描述: @Description: 数据字典工具类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.util;

import com.alibaba.fastjson.JSON;
import com.win.dfas.common.vo.DicRepVO;

import cn.hutool.core.util.ObjectUtil;

/**   
 * 包名称： com.win.dfas.common.util 
 * 类名称：DicUtil 
 * 类描述：数据字典工具类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年7月31日/下午5:49:14
 *     
 */
public class DicUtil {
	
	private static String keyFormat = "SYS_DATA_DICTIONARY-%s-%s";

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
	 * @Date:  2019年7月31日/下午5:49:54
	 */
	public static String getDicExplain(String parentDicCode, String dicCode) {
		
		DicRepVO repVO = getObjct(String.format(keyFormat, parentDicCode, dicCode));
		
		return ObjectUtil.isEmpty(repVO) ? null : repVO.getDicExplain();
	}
	
	/**
	 * 
	 * 获取字典对象
	 * @Title: getObjct
	 * @param key
	 * @return   
	 * @return: DicRepVO   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月31日/下午6:02:29
	 */
	public static DicRepVO getObjct(String key) {
		
		Object object = RedisUtil.get(key);
		
		if (ObjectUtil.isNotEmpty(object)) {
			return JSON.parseObject(JSON.toJSONString(object), DicRepVO.class);
		}
		
		return null;
	}
	
}
