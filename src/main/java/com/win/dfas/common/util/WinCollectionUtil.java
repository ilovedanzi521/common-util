/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年7月31日/下午2:57:09
 * 项目名称：  dfas-common-util
 * 文件名称: WinCollectionUtil.java
 * 文件描述: @Description: 集合工具转换类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/
package com.win.dfas.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

/**   
 * 包名称： com.win.dfas.common.util 
 * 类名称：WinCollectionUtil 
 * 类描述：集合工具转换类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年7月31日/下午2:57:09
 *     
 */
public final class WinCollectionUtil {

	/**
	 * 
	 * 根据keyName和prefix转为Map
	 * @Title: list2map
	 * @param list 数据列表
	 * @param keyName
	 * @param keyPrefix
	 * @return   
	 * @return: Map<String,Object>   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月31日/下午3:09:09
	 */
	public static Map<String, Object> list2map(List<Map<String, Object>> list, String keyName, String keyPrefix) {
		
		if (CollectionUtil.isEmpty(list)) {
			return null;
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		for (Map<String, Object> map : list) {
			
			if (ObjectUtil.isEmpty(map.get(keyName))) {
				continue;
			}
			
			String key = StrUtil.isEmpty(keyPrefix) ? "" : keyPrefix;
			
			key += map.get(keyName).toString();
			
			resultMap.put(key, map);
		}
		
		return resultMap;
	}
}
