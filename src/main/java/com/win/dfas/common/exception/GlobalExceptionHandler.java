/****************************************************
 * 创建人：  @author wangkai
 * 创建时间: 2017-11-8/15:11:24
 * 项目名称: ycmp-api
 * 文件名称: GlobalExceptionHandler.java
 * 文件描述: @Description
 * 公司名称: 深圳市赢和信息技术有限公司
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2017
 *
 ********************************************************/
package com.win.dfas.common.exception;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.win.dfas.common.vo.WinResponseData;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 *
 * 包名称： com.yhfin.ycmp.api.exception
 * 类名称：GlobalExceptionHandler
 * 类描述：
 * 创建人：@author wangkai
 * 创建时间：2017年11月8日/下午3:11:32
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * log
     */
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public WinResponseData defaultErrorHandler(HttpServletRequest req,RuntimeException e) {
        logger.error("url={},errormsg={}",req.getRequestURL().toString(),ExceptionUtil.stacktraceToString(e));
        return WinResponseData.handleError();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public WinResponseData defaultErrorHandler(HttpServletRequest req,ConstraintViolationException e) {
        /** 对于统一参数校验的错误信息的获取 */
        ConstraintViolationException invalid=(ConstraintViolationException)e;
        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation<?> violation : invalid.getConstraintViolations()) {
            sb.append("Error: " + violation.getPropertyPath() + ":" + violation.getMessage() + "\n");
        }
        String mes = sb.toString();
        String logMsg = invalid.getConstraintViolations().toString();
        logger.error("url={},errormsg={}",req.getRequestURL().toString(),logMsg);
        return WinResponseData.handleError(mes);
    }

    @ExceptionHandler(WinException.class)
    @ResponseBody
    public WinResponseData defaultErrorHandler(HttpServletRequest req,WinException e) {
        logger.error("url={},errormsg={}",req.getRequestURL().toString(),ExceptionUtil.stacktraceToString(e));
        return WinResponseData.handleError(e.getCode(),e.getMsg());
    }
}
