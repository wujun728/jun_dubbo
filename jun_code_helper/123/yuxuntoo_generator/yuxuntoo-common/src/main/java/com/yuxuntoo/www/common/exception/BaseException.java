package com.yuxuntoo.www.common.exception;


import com.yuxuntoo.www.common.vo.resp.ApiResponse;

public class BaseException extends Exception {

    /**
     * 响应完整信息
     *
     * */
    private ApiResponse response;

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(ApiResponse response, Throwable cause) {
        super(cause);
        this.response = response;
    }

    public BaseException(ApiResponse response, String message) {
        super(message);
        this.response = response;
    }

    public BaseException(ApiResponse response) {
        super(response.getResDesc());
        this.response = response;
    }

    public ApiResponse getResponse() {
        return response;
    }

    public void setResponse(ApiResponse response) {
        this.response = response;
    }
}
