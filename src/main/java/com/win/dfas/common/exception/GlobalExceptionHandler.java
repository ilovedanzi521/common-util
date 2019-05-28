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

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        String mes = e.getMessage();
        String logMsg = e.getMessage();
        if (e instanceof WinException) {
            WinException exp = (WinException) e;
            mes = exp.getMsg();
            logMsg = exp.getLogMsg();
            if (StringUtils.isBlank(logMsg)) {
                logMsg = exp.getMsg();
            }
        }else if( e instanceof ConstraintViolationException) {
            /** 对于统一参数校验的错误信息的获取 */
            ConstraintViolationException invalid=(ConstraintViolationException)e;
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<?> violation : invalid.getConstraintViolations()) {
                sb.append("Error: " + violation.getPropertyPath() + ":" + violation.getMessage() + "\n");
            }
            mes = sb.toString();
            logMsg = invalid.getConstraintViolations().toString();
        }
        if (StringUtils.isEmpty(mes)) {
            //TODO
//            mes = BaseResultCode.SYSTEM_ERROR.getMessage();
        }
        logger.error("url={},errormsg={}",req.getRequestURL().toString(),logMsg, e);
        return new ResponseEntity<String>(mes, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
