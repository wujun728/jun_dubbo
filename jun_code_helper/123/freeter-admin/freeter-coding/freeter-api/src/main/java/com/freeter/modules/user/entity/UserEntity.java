package com.freeter.modules.user.entity;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 用户表
 * 
 * @author liuqi
 * @email 171998110@qq.com
 * @date 2018-05-19 13:46:34
 */
@TableName("cn_user")
@ApiModel(value = "User")
public class UserEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public UserEntity() {
		
	}
	
	public UserEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException e) {
 			e.printStackTrace();
		} catch (InvocationTargetException e) {
 			e.printStackTrace();
		}
	}

	/**
	 * 用户ID
	 */
	
	@TableId 				 
	@ApiModelProperty(value = "用户ID",hidden = true)
	private Long userId;
	
	/**
	 * 用户编号
	 */
					 
	@ApiModelProperty(value = "用户编号")
	private String userNumber;
	
	/**
	 * 手机号
	 */
				
	@NotBlank (message = "手机号不能为空") 		 
	@ApiModelProperty(value = "手机号")
	private String phone;
	
	/**
	 * 密码
	 */
				
	@NotBlank (message = "密码不能为空") 		 
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
	@ApiModelProperty(value="身份证号码")
	private String idCard;
					 
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
	 * 年龄
	 */
					 
	@ApiModelProperty(value = "年龄")
	private Integer age;

	/**
	 * 出生日期
	 */
	@ApiModelProperty(value = "出生日期")
	private Date birth;


	/**
	 * 用户头像
	 */
					 
	@ApiModelProperty(value = "用户头像")
	private String picImg;

	/**
	 * 身份证正面照片
	 */
	@ApiModelProperty(value = "身份证正面照")
	private String idcardFrontImg;

	/**
	 * 身份证反面照片
	 */
	@ApiModelProperty(value = "身份证反面照")
	private String idcardBackImg;
	
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
	 * 创建者
	 */
					 
	@ApiModelProperty(value = "创建者",hidden = true)
	private String createBy;
	
	/**
	 * 修改时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 	 
	@ApiModelProperty(value = "修改时间",hidden = true)
	private Date updateTime;
	
	/**
	 * 修改人
	 */
					 
	@ApiModelProperty(value = "修改人",hidden = true)
	private String updateBy;
	
	/**
	 * 设置：用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserId() {
		return userId;
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
	 * 设置：创建者
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建者
	 */
	public String getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	public Date getBirth() {
		return birth;
	}

	public String getIdcardFrontImg() {
		return idcardFrontImg;
	}

	public String getIdcardBackImg() {
		return idcardBackImg;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public void setIdcardFrontImg(String idcardFrontImg) {
		this.idcardFrontImg = idcardFrontImg;
	}

	public void setIdcardBackImg(String idcardBackImg) {
		this.idcardBackImg = idcardBackImg;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
}
