package com.yuxuntoo.www.common.exception;


import com.yuxuntoo.www.common.vo.resp.ApiResponse;

public class BussException extends BaseException{

    public BussException(Throwable cause) {
        this(ApiResponse.BUSS_ERROR, cause);
    }

    public BussException(String message) {
        this(ApiResponse.BUSS_ERROR, message);
    }

    public BussException(ApiResponse response, Throwable cause) {
        super(cause);
        this.setResponse(response);
    }

    public BussException(ApiResponse response, String message) {
        super(message);
        this.setResponse(response);
    }

    public BussException(ApiResponse response) {
        super(response);
    }
}
