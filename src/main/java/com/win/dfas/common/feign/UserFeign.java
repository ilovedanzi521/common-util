/****************************************************
 * 创建人：  @author zhoujinyin    
 * 创建时间: 2019/6/3/14:32
 * 项目名称：dfas-common-util
 * 文件名称: UserFeign
 * 文件描述: @Description: 用户服务Feign
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfas.common.feign;


import com.win.dfas.common.entity.BaseUserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 包名称：com.win.dfas.common.feign
 * 类名称：UserFeign
 * 类描述：用户服务Feign
 * 创建人：@author zhoujinyin
 * 创建时间：2019/6/3/14:32
 */
//todo:不知道这个配置 后面再写
@FeignClient()
public interface UserFeign {
    /**
     * @Title: getInfoFromToken
     * @Description: 获取token中的用户信息
     * @param token
     * @return com.win.dfas.common.config.BaseUserInfo
     * @throws
     * @author: zhoujinyin
     * @Date:  2019/6/3/15:08
     */
    @RequestMapping("api/web/userInfo")
    BaseUserInfo getInfoFromToken(String token);
}