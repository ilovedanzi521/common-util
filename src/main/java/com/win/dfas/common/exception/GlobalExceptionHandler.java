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

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.win.dfas.common.vo.WinResponseData;

import cn.hutool.core.exceptions.ExceptionUtil;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public WinResponseData defaultErrorHandler(HttpServletRequest req, RuntimeException e) {
    	LOGGER.error("url={},errormsg={}", req.getRequestURL().toString(), getMessage(e));
        return WinResponseData.handleError();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public WinResponseData httpMessageNotReadableExceptionHandler(HttpServletRequest req, RuntimeException e) {
    	LOGGER.error("url={},errormsg={}", req.getRequestURL().toString(), getMessage(e));
        return WinResponseData.handleError("数据类型或格式异常");
    }
    
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public WinResponseData numberFormatExceptionHandler(HttpServletRequest req, RuntimeException e) {
    	LOGGER.error("url={},errormsg={}", req.getRequestURL().toString(), getMessage(e));
        return WinResponseData.handleError(e.getMessage());
    }
    
    @ExceptionHandler(InvalidFormatException.class)
    @ResponseBody
    public WinResponseData invalidFormatExceptionHandler(HttpServletRequest req, RuntimeException e) {
    	LOGGER.error("url={},errormsg={}", req.getRequestURL().toString(), getMessage(e));
        return WinResponseData.handleError(e.getMessage());
    }
    
    @ExceptionHandler(UserAuthException.class)
    @ResponseBody
    public WinResponseData userTokenExceptionHandler(HttpServletRequest request, UserAuthException ex) {
    	
    	LOGGER.error("url = {}, errMsg ={}", request.getRequestURL(), getMessage(ex));
    	
        return WinResponseData.handleAuth(ex.getMessage());
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
        LOGGER.error("url={},errormsg={}",req.getRequestURL().toString(),logMsg);
        return WinResponseData.handleError(mes);
    }

    @ExceptionHandler(WinException.class)
    @ResponseBody
    public WinResponseData defaultErrorHandler(HttpServletRequest req,WinException e) {
    	LOGGER.error("url={},errormsg={}",req.getRequestURL().toString(), getMessage(e));
        return WinResponseData.handleError(e.getCode(),e.getMsg());
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public WinResponseData methodArgumentNotValidExceptionHandler(HttpServletRequest req, MethodArgumentNotValidException e) {
    	LOGGER.error("url = {},errormsg = {}", req.getRequestURL().toString(), getMessage(e));
    	
    	List<ObjectError> errorList = e.getBindingResult().getAllErrors();
    	
    	String errorMsg = errorList.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(";"));
    	
        return WinResponseData.handleError("400", errorMsg);
    }
    
    /**
     * 
     * 获取完整的堆栈异常信息
     * @Title: getMessage
     * @param throwable
     * @return   
     * @return: String   
     * @throws
     * @author: hechengcheng 
     * @Date:  2019年10月26日/上午10:15:29
     */
    private static String getMessage(Throwable throwable) {
    	
    	return ExceptionUtil.stacktraceToString(throwable, Integer.MAX_VALUE);
    }
}
