package com.yuxuntoo.www.common.exception;

import com.yuxuntoo.www.common.vo.resp.ApiResponse;
import com.yuxuntoo.www.common.vo.resp.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class YuXunTooExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ApiResult handle(BaseException e) {
        logger.error("错误信息是:{}", e);
        ApiResult resp = null;
        ApiResponse response = e.getResponse();
        if (response == null || StringUtils.isEmpty(response.getReturnMsg())) {
            resp = new ApiResult(e.getResponse(), null, e.getMessage());
        } else {
            resp = new ApiResult(e.getResponse(), null);
        }
        return resp;
    }
}
