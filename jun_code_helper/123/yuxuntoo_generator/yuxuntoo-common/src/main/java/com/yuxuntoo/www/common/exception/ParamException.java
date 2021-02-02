package com.yuxuntoo.www.common.exception;


import com.yuxuntoo.www.common.vo.resp.ApiResponse;

public class ParamException extends BaseException {

    public ParamException(Throwable cause) {
        this(ApiResponse.PARAM_ERROR, cause);
    }

    public ParamException(String message) {
        this(ApiResponse.PARAM_ERROR, message);
    }

    public ParamException(ApiResponse response, Throwable cause) {
        super(cause);
        this.setResponse(response);
    }

    public ParamException(ApiResponse response, String message) {
        super(message);
        this.setResponse(response);
    }

    public ParamException(ApiResponse response) {
        super(response);
    }
}
