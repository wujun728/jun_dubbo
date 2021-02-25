package com.hoo.codegenerator.server.common.exception;

import com.hoo.codegenerator.server.common.model.Res;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕捉处理
 *
 * @author hank
 * @create 2019-11-12 下午3:56
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Res myExceptionHandler(Exception ex) {
        String msg = ex.getMessage();
        if (StringUtils.isEmpty(msg)) {
            msg = "服务器出错,请稍后再试";
        }
        return Res.error(msg);
    }

    @ResponseBody
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public Res HttpMessageNotReadableExceptionHandler(HttpMessageNotReadableException ex) {
        return Res.error("非法的HTTP调用");
    }

}
