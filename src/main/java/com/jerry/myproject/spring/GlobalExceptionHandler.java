package com.jerry.myproject.spring;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * CopyRight (c)2018-2023 : cargogm.com
 * Project :  my-project
 * Comments : <全局异常捕获>
 * JDK version : JDK1.8
 * Create Date : 2023/03/08 17:01
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        if (e instanceof ArithmeticException) {
            return "数据异常";
        }
        if (e instanceof Exception) {
            return "服务器内部异常";
        }
        return null;
    }
}
