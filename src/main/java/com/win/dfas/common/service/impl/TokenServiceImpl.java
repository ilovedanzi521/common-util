package com.win.dfas.common.service.impl;

import cn.hutool.core.util.StrUtil;
import com.win.dfas.common.constant.CommonConstants;
import com.win.dfas.common.entity.BaseUserInfo;
import com.win.dfas.common.exception.WinException;
import com.win.dfas.common.feign.UserFeign;
import com.win.dfas.common.service.TokenService;
import com.win.dfas.common.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 包名称：com.win.dfas.common.service.impl
 * 类名称：Service
 * 类描述：${TODO}
 * 创建人：@author wanglei
 * 创建时间：2019/5/28/13:41
 */

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private UserFeign userFeign;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void checkToken(HttpServletRequest request) {
        String token = request.getHeader(CommonConstants.TOKEN_NAME);
        if (StrUtil.isBlank(token)) {        // header中不存在token
            token = request.getParameter(CommonConstants.TOKEN_NAME);
            if (StrUtil.isBlank(token)) {    // parameter中也不存在token
                throw new WinException("报文不存在token");
            }
        }
        if (!redisUtil.lock(token)) {
//          throw new WinException(ResponseCode.REPETITIVE_OPERATION.getMsg());
            throw new WinException("重复操作");
        }
        if (!redisUtil.delete(token)) {
            throw new WinException("重复操作");
        }
    }

    @Override
    public void setBaseUserInfoByToken(HttpServletRequest request) {
        BaseUserInfo baseUserInfo = userFeign.getInfoFromToken(request.getHeader(CommonConstants.TOKEN_NAME));
        request.setAttribute(CommonConstants.USER_KEY, baseUserInfo);
    }
}
