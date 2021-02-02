package com.yuxuntoo.www.common.vo.resp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ApiResult implements Serializable {
	/**
	 * 响应码
	 */
	private String resultCode;

	/**
	 * 响应描述
	 */
	public String msg;

	/**
	 * 返回数据对象
	 */
	public Map<String, Object> data = new HashMap<>();
	public ApiResult() {
		this.resultCode = ApiResponse.SUCCESS.getResCode();
		this.msg = ApiResponse.SUCCESS.getResDesc();
	}
	public ApiResult(Map<String, Object> data) {
		this.resultCode = ApiResponse.SUCCESS.getResCode();
		this.msg = ApiResponse.SUCCESS.getResDesc();
		this.data = data;
	}

	public ApiResult(ApiResponse resp, Map<String, Object> data) {
		this.resultCode = resp.getResCode();
		this.msg = resp.getResDesc();
		this.data = data;
	}

	public ApiResult(ApiResponse resp, Map<String, Object> data, String msg) {
		this.resultCode = resp.getResCode();
		this.msg = msg;
		this.data = data;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ApiResult{" +
				"resultCode='" + resultCode + '\'' +
				", msg='" + msg + '\'' +
				", data=" + data +
				'}';
	}
}
