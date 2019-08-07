/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2019年7月2日/上午10:33:29
 * 项目名称：  dfas-common-util
 * 文件名称: UserUtil.java
 * 文件描述: @Description: 用户工具类
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 * 
 ********************************************************/

package com.win.dfas.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.entity.BaseUserInfo;
import com.win.dfas.common.enumeration.EnvEnum;
import com.win.dfas.common.exception.WinException;
import com.win.dfas.common.feign.UserFeign;
import com.win.dfas.common.vo.WinResponseData;
import com.win.dfas.common.vo.WinResponseData.WinRspType;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

/**   
 * 包名称： com.win.dfas.common.util 
 * 类名称：UserUtil 
 * 类描述：用户工具类
 * 创建人：@author hechengcheng 
 * 创建时间：2019年7月2日/上午10:33:29
 *     
 */
public class UserUtil {
	
	/**
	 * 
	 * 获取用户信息
	 * @Title: getUser
	 * @return   
	 * @return: BaseUserInfo   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月2日/上午11:02:42
	 */
	public static BaseUserInfo getUser() {
		
		BaseUserInfo baseUserInfo = null;
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		
		String userStr = request.getHeader(CommonConstants.USER_KEY);
		
		if (StrUtil.isEmpty(userStr)) {
			if (EnvEnum.DEV.getEnv().equals(SpringContextUtil.getActiveProfile())) {
				baseUserInfo = new BaseUserInfo();
				baseUserInfo.setUserId("admin");
				baseUserInfo.setCompanyCode("win");
				baseUserInfo.setDepartmentCode("win");
			}
		} else {
			baseUserInfo = JSON.parseObject(userStr, BaseUserInfo.class);
		}
		
		return baseUserInfo;
	}
	
	/**
	 * 
	 * 获取用户ID
	 * @Title: getUserId
	 * @return   
	 * @return: String   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月2日/上午11:02:56
	 */
	public static String getUserId() {
		
		String userId = null;
		
		// 获取用户信息
		BaseUserInfo baseUserInfo = getUser();
		
		if (ObjectUtil.isNotEmpty(baseUserInfo)) {
			return baseUserInfo.getUserId();
		}
		
		return userId;
	}
	
	/**
	 * 
	 * 获取公司编码
	 * @Title: getCompanyCode
	 * @return   
	 * @return: String   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月2日/上午11:13:22
	 */
	public static String getCompanyCode() {
		
		String companyCode = null;
		
		// 获取用户信息
		BaseUserInfo baseUserInfo = getUser();
		
		if (ObjectUtil.isNotEmpty(baseUserInfo)) {
			return baseUserInfo.getCompanyCode();
		}
		
		return companyCode;
		
	}
	
	/**
	 * 
	 * 获取部门编码
	 * @Title: getDepartmentCode
	 * @return   
	 * @return: String   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月2日/上午11:13:22
	 */
	public static String getDepartmentCode() {
		
		String departmentCode = null;
		
		// 获取用户信息
		BaseUserInfo baseUserInfo = getUser();
		
		if (ObjectUtil.isNotEmpty(baseUserInfo)) {
			return baseUserInfo.getDepartmentCode();
		}
		
		return departmentCode;
	}
	
	/**
	 * 
	 * 根据用户ID获取用户名
	 * @Title: getUserName
	 * @param userId
	 * @return   
	 * @return: String   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月10日/下午4:31:26
	 */
	public static String getUserName(String userId) {
		
		if (StrUtil.isEmpty(userId)) {
			return null;
		}
		
		List<String> userIdList = new ArrayList<String>(1);
		
		userIdList.add(userId);
		
		Map<String, String> map = getUserName(userIdList);
		
		if (CollectionUtil.isNotEmpty(map)) {
			return map.get(userId);
		}
		
		return null;
	}
	
	/**
	 * 
	 * 根据多个用户ID获取用户名
	 * @Title: getUserName
	 * @param userIdList
	 * @return   
	 * @return: Map<String,String> 用户名和密码的键值对   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2019年7月10日/下午5:08:27
	 */
	public static Map<String, String> getUserName(List<String> userIdList) {
		
		if (CollectionUtil.isEmpty(userIdList)) {
			return null;
		}
		
		Map<String, String> resultMap = new HashMap<String, String>(16);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userIdList", userIdList);
		
		// 调用Feign接口
		WinResponseData winResponseData = SpringContextUtil.getBean(UserFeign.class).queryUserName(jsonObject);
		
		if (WinRspType.SUCC.getKey().equals(winResponseData.getWinRspType().getKey())) {
			
			List<BaseUserInfo> userList = JSON.parseArray(JSON.toJSONString(winResponseData.getData()), BaseUserInfo.class);
			
			if (CollectionUtil.isEmpty(userList)) {
				return resultMap;
			}
			
			for (BaseUserInfo baseUserInfo : userList) {
				resultMap.put(baseUserInfo.getUserId(), baseUserInfo.getUserName());
			}
			
		} else {
			throw new WinException(winResponseData.getMsg());
		}
		
		return resultMap;
	}
}
