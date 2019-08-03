package com.win.dfas.common.util;

import com.alibaba.fastjson.JSON;
import com.win.dfas.common.vo.DicRepVO;
import com.win.dfas.common.vo.SecurityBasicRepVO;

import cn.hutool.core.util.ObjectUtil;

/**
 * 通过缓存获取证券信息
 * 
 * @author tandun
 *
 */
public class SecurityCacheUtil {

	private static String keyFormat = "PARAM_SECURINTY_BASIC_INFO-%s";
     /**
      * 
      * @param securityCodeKey
      * @param securityCode
      * @return
      */
	public static String getSecurityName(String securityCodeKey) {

		SecurityBasicRepVO repVO = getObjct(String.format(keyFormat, securityCodeKey));

		return ObjectUtil.isEmpty(repVO) ? null : repVO.getSecurityName();
	}
   /**
    * 
    * @param key
    * @return
    */
	public static SecurityBasicRepVO getObjct(String key) {

		Object object = RedisUtil.get(key);

		if (ObjectUtil.isNotEmpty(object)) {
			return JSON.parseObject(JSON.toJSONString(object), SecurityBasicRepVO.class);
		}

		return null;
	}
}
