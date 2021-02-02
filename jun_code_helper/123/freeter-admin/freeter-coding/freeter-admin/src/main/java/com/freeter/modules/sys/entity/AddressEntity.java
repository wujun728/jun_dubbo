package com.freeter.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-18 13:41:16
 */
@TableName("cn_address")
@ApiModel(value = "Address")
public class AddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	@TableId 				 
	@ApiModelProperty(value = "",hidden = true)
	private Integer id;
	
	/**
	 * 
	 */
			
	@NotEmpty (message = "不能为空") 			 
	@ApiModelProperty(value = "")
	private Integer userId;
	
	/**
	 * 收货地址
	 */
				
	@NotBlank (message = "收货地址不能为空") 		 
	@ApiModelProperty(value = "收货地址")
	private String address;
	
	/**
	 * 邮编
	 */
				
	@NotBlank (message = "邮编不能为空") 		 
	@ApiModelProperty(value = "邮编")
	private String postcode;
	
	/**
	 * 收货人姓名
	 */
				
	@NotBlank (message = "收货人姓名不能为空") 		 
	@ApiModelProperty(value = "收货人姓名")
	private String personName;
	
	/**
	 * 收货人电话
	 */
				
	@NotBlank (message = "收货人电话不能为空") 		 
	@ApiModelProperty(value = "收货人电话")
	private String personTel;
	
	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：收货地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：收货地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：邮编
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	/**
	 * 获取：邮编
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * 设置：收货人姓名
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	/**
	 * 获取：收货人姓名
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * 设置：收货人电话
	 */
	public void setPersonTel(String personTel) {
		this.personTel = personTel;
	}
	/**
	 * 获取：收货人电话
	 */
	public String getPersonTel() {
		return personTel;
	}
}
