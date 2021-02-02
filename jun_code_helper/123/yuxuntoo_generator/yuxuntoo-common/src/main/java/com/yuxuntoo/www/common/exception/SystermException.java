package com.yuxuntoo.www.common.exception;


import com.yuxuntoo.www.common.vo.resp.ApiResponse;

public class SystermException extends BaseException {

    public SystermException(Throwable cause) {
        super(ApiResponse.SYSTEM_ERROR, cause);
    }

    public SystermException(String message) {
        super(ApiResponse.SYSTEM_ERROR, message);
    }

    public SystermException(ApiResponse response, Throwable cause) {
        super(cause);
        this.setResponse(response);
    }

    public SystermException(ApiResponse response, String message) {
        super(message);
        this.setResponse(response);
    }

    public SystermException(ApiResponse response) {
        super(response);
    }
}
