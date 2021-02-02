package com.yuxuntoo.www.common.vo.resp;

/**
 * 返回码长度四位
 * 前两位表示父状态   后两位表示子状态
 * */
public enum ApiResponse {
    SUCCESS("0000", "操作成功"),
    FAIL("0001","操作失败"),
    SYSTEM_ERROR("0002","操作失败，系统业务异常"),
    BUSS_ERROR("0003","操作失败，业务异常"),

    PARAM_ERROR("0100", "参数异常"),

    ;


    /**
     * 响应CODE
     * */
    private String resCode;
    /**
     * 响应描述
     * */
    private String resDesc;

    /**
     * 返回提前提示信息
     * */
    private String returnMsg;

    private ApiResponse(String resCode, String resDesc) {
        this.resCode = resCode;
        this.resDesc = resDesc;
    }

    private ApiResponse(String resCode, String resDesc, String returnMsg) {
        this.resCode = resCode;
        this.resDesc = resDesc;
        this.returnMsg = returnMsg;
    }

    public String getResCode() {
        return resCode;
    }

    public String getResDesc() {
        return resDesc;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public static ApiResponse getResponseByCode(String resCode) {
        for (ApiResponse mrc : ApiResponse.values()) {
            if (mrc.getResCode().equals(resCode)) {
                return mrc;
            }
        }
        return null;
    }
}
