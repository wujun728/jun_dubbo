package com.freeter.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModelProperty;

public class SpeedForm {

	@ApiModelProperty(value = "手机号")
	@NotBlank(message = "手机号不能为空")
	@Length(max = 11, min = 11, message = "手机号格式不对")
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
