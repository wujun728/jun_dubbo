package com.freeter.modules.address.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.address.entity.view.AddressView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-19 17:57:52
 */
@TableName("cn_address")
@ApiModel(value = "Address")
public class AddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	public AddressEntity() {
		
	}
	
	public AddressEntity(AddressView addressView) {
		BeanUtils.copyProperties(this, addressView);
	}

	/**
	 * 
	 */
	
	@TableId 				 
	@ApiModelProperty(value = "",hidden = true)
	private Integer id;
	
	/**
	 * 
	 */
			
	@NotNull (message = "不能为空") 			 
	@ApiModelProperty(value = "")
	private Integer userId;
	
	/**
	 * 详细地址
	 */
				
	@NotBlank (message = "详细地址不能为空") 		 
	@ApiModelProperty(value = "详细地址")
	private String detailedAddress;
	
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
	 * 省
	 */
				
	@NotBlank (message = "省不能为空") 		 
	@ApiModelProperty(value = "省")
	private String province;
	
	/**
	 * 市
	 */
				
	@NotBlank (message = "市不能为空") 		 
	@ApiModelProperty(value = "市")
	private String city;
	
	/**
	 * 区
	 */
				
	@NotBlank (message = "区不能为空") 		 
	@ApiModelProperty(value = "区")
	private String area;
	
	/**
	 * 是否默认地址 0：否 1：是
	 */
				
	@NotBlank (message = "是否默认地址 0：否 1：是不能为空") 		 
	@ApiModelProperty(value = "是否默认地址 0：否 1：是")
	private String isDefault;
	
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
	 * 设置：详细地址
	 */
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	/**
	 * 获取：详细地址
	 */
	public String getDetailedAddress() {
		return detailedAddress;
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
	/**
	 * 设置：省
	 */
	public void setProvince(String  province) {
		this.province = province;
	}
	/**
	 * 获取：省
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：区
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：区
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：是否默认地址 0：否 1：是
	 */
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	/**
	 * 获取：是否默认地址 0：否 1：是
	 */
	public String getIsDefault() {
		return isDefault;
	}
}
