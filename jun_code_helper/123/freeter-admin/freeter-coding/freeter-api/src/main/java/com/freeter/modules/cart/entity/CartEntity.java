package com.freeter.modules.cart.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freeter.modules.cart.entity.view.CartView;

import java.lang.reflect.InvocationTargetException;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;



/**
 * 购物车
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-29 09:47:58
 */
@TableName("cn_cart")
@ApiModel(value = "Cart")
public class CartEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CartEntity() {
		
	}
	
	public CartEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 购物车ID
	 */
	
	@TableId 				 
	@ApiModelProperty(value = "购物车ID",hidden = true)
	private Integer cartId;
	
	/**
	 * 商品规格价格id
	 */
					 
	@ApiModelProperty(value = "商品规格价格id")
	private Integer goodSpecPriceId;
	
	/**
	 * 用户ID
	 */
					 
	@ApiModelProperty(value = "用户ID")
	private Integer userId;
	
	/**
	 * 购买数量
	 */
					 
	@ApiModelProperty(value = "购买数量")
	private Integer buyNumber;
	
	/**
	 * 创建时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 	 
	@ApiModelProperty(value = "创建时间",hidden = true)
	private Date createTime;
	
	/**
	 * 更新时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 	 
	@ApiModelProperty(value = "更新时间",hidden = true)
	private Date updateTime;
	
	/**
	 * 购物车状态：0,未选中；1,选中
	 */
					 
	@ApiModelProperty(value = "购物车状态：0,未选中；1,选中")
	private Integer checkStatus;
	
	/**
	 * 设置：购物车ID
	 */
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	/**
	 * 获取：购物车ID
	 */
	public Integer getCartId() {
		return cartId;
	}
	/**
	 * 设置：商品规格价格id
	 */
	public void setGoodSpecPriceId(Integer goodSpecPriceId) {
		this.goodSpecPriceId = goodSpecPriceId;
	}
	/**
	 * 获取：商品规格价格id
	 */
	public Integer getGoodSpecPriceId() {
		return goodSpecPriceId;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：购买数量
	 */
	public void setBuyNumber(Integer buyNumber) {
		this.buyNumber = buyNumber;
	}
	/**
	 * 获取：购买数量
	 */
	public Integer getBuyNumber() {
		return buyNumber;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：购物车状态：0,未选中；1,选中
	 */
	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}
	/**
	 * 获取：购物车状态：0,未选中；1,选中
	 */
	public Integer getCheckStatus() {
		return checkStatus;
	}
}
