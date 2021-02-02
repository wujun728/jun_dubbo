package com.freeter.modules.user.entity.vo;

import com.freeter.modules.user.entity.UserEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 用户表
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 13:55:47
 */
@ApiModel(value = "UserVO")
public class UserVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 身份证号码
	 */
	
	@ApiModelProperty(value = "身份证号码") 
	private String idCard;
		
	/**
	 * 用户编号
	 */
	
	@ApiModelProperty(value = "用户编号") 
	private String userNumber;
		
	/**
	 * 手机号
	 */
	
	@ApiModelProperty(value = "手机号") 
	private String phone;
		
	/**
	 * 密码
	 */
	
	@ApiModelProperty(value = "密码") 
	private String password;
		
	/**
	 * 盐
	 */
	
	@ApiModelProperty(value = "盐") 
	private String salt;
		
	/**
	 * 用户昵称
	 */
	
	@ApiModelProperty(value = "用户昵称") 
	private String userName;
		
	/**
	 * 真实姓名
	 */
	
	@ApiModelProperty(value = "真实姓名") 
	private String realName;
		
	/**
	 * 性别
	 */
	
	@ApiModelProperty(value = "性别") 
	private Integer sex;
		
	/**
	 * 出生日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "出生日期") 
	private Date birth;
		
	/**
	 * 年龄
	 */
	
	@ApiModelProperty(value = "年龄") 
	private Integer age;
		
	/**
	 * 用户头像
	 */
	
	@ApiModelProperty(value = "用户头像") 
	private String picImg;
		
	/**
	 * 状态 0=冻结/1=正常
	 */
	
	@ApiModelProperty(value = "状态 0=冻结/1=正常") 
	private Integer status;
		
	/**
	 * 总金额
	 */
	
	@ApiModelProperty(value = "总金额") 
	private String amount;
		
	/**
	 * 用户类型
	 */
	
	@ApiModelProperty(value = "用户类型") 
	private String userType;
		
	/**
	 * 注册时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "注册时间") 
	private Date regeistTime;
					
	/**
	 * 身份证正面照
	 */
	
	@ApiModelProperty(value = "身份证正面照") 
	private String idcardFrontImg;
		
	/**
	 * 身份证反面照
	 */
	
	@ApiModelProperty(value = "身份证反面照") 
	private String idcardBackImg;
				
	
	/**
	 * 设置：身份证号码
	 */
	 
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	/**
	 * 获取：身份证号码
	 */
	public String getIdCard() {
		return idCard;
	}
				
	
	/**
	 * 设置：用户编号
	 */
	 
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	
	/**
	 * 获取：用户编号
	 */
	public String getUserNumber() {
		return userNumber;
	}
				
	
	/**
	 * 设置：手机号
	 */
	 
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * 获取：手机号
	 */
	public String getPhone() {
		return phone;
	}
				
	
	/**
	 * 设置：密码
	 */
	 
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
				
	
	/**
	 * 设置：盐
	 */
	 
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	/**
	 * 获取：盐
	 */
	public String getSalt() {
		return salt;
	}
				
	
	/**
	 * 设置：用户昵称
	 */
	 
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 获取：用户昵称
	 */
	public String getUserName() {
		return userName;
	}
				
	
	/**
	 * 设置：真实姓名
	 */
	 
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	/**
	 * 获取：真实姓名
	 */
	public String getRealName() {
		return realName;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	/**
	 * 获取：性别
	 */
	public Integer getSex() {
		return sex;
	}
				
	
	/**
	 * 设置：出生日期
	 */
	 
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	/**
	 * 获取：出生日期
	 */
	public Date getBirth() {
		return birth;
	}
				
	
	/**
	 * 设置：年龄
	 */
	 
	public void setAge(Integer age) {
		this.age = age;
	}
	
	/**
	 * 获取：年龄
	 */
	public Integer getAge() {
		return age;
	}
				
	
	/**
	 * 设置：用户头像
	 */
	 
	public void setPicImg(String picImg) {
		this.picImg = picImg;
	}
	
	/**
	 * 获取：用户头像
	 */
	public String getPicImg() {
		return picImg;
	}
				
	
	/**
	 * 设置：状态 0=冻结/1=正常
	 */
	 
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * 获取：状态 0=冻结/1=正常
	 */
	public Integer getStatus() {
		return status;
	}
				
	
	/**
	 * 设置：总金额
	 */
	 
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * 获取：总金额
	 */
	public String getAmount() {
		return amount;
	}
				
	
	/**
	 * 设置：用户类型
	 */
	 
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	/**
	 * 获取：用户类型
	 */
	public String getUserType() {
		return userType;
	}
				
	
	/**
	 * 设置：注册时间
	 */
	 
	public void setRegeistTime(Date regeistTime) {
		this.regeistTime = regeistTime;
	}
	
	/**
	 * 获取：注册时间
	 */
	public Date getRegeistTime() {
		return regeistTime;
	}
										
	
	/**
	 * 设置：身份证正面照
	 */
	 
	public void setIdcardFrontImg(String idcardFrontImg) {
		this.idcardFrontImg = idcardFrontImg;
	}
	
	/**
	 * 获取：身份证正面照
	 */
	public String getIdcardFrontImg() {
		return idcardFrontImg;
	}
				
	
	/**
	 * 设置：身份证反面照
	 */
	 
	public void setIdcardBackImg(String idcardBackImg) {
		this.idcardBackImg = idcardBackImg;
	}
	
	/**
	 * 获取：身份证反面照
	 */
	public String getIdcardBackImg() {
		return idcardBackImg;
	}
			
}
