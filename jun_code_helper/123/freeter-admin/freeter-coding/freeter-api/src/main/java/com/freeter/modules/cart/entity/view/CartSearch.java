package com.freeter.modules.cart.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.beans.BeanUtils;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freeter.modules.cart.entity.CartEntity;

import java.io.Serializable;
 

/**
 * 购物车
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-29 09:47:58
 */
@ApiModel(value = "CartSearch")
public class CartSearch  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品规格价格id
	 */
	
	@ApiModelProperty(value = "商品规格价格id") 
	private Long goodSpecPriceId;
		
	/**
	 * 用户ID
	 */
	
	@ApiModelProperty(value = "用户ID") 
	private Long userId;
		
	/**
	 * 购买数量
	 */
	
	@ApiModelProperty(value = "购买数量") 
	private Integer buyNumber;
				
	/**
	 * 购物车状态：0,未选中；1,选中
	 */
	
	@ApiModelProperty(value = "购物车状态：0,未选中；1,选中") 
	private Integer checkStatus;
				
	
	/**
	 * 设置：商品规格价格id
	 */
	 
	public void setGoodSpecPriceId(Long goodSpecPriceId) {
		this.goodSpecPriceId = goodSpecPriceId;
	}
	
	/**
	 * 获取：商品规格价格id
	 */
	public Long getGoodSpecPriceId() {
		return goodSpecPriceId;
	}
				
	
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
