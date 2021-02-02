package com.freeter.modules.order.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.beans.BeanUtils;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freeter.modules.order.entity.OrderGoodEntity;

import java.io.Serializable;
 

/**
 * 
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-28 17:20:46
 */
@ApiModel(value = "OrderGoodSearch")
public class OrderGoodSearch  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 订单id
	 */
	
	@ApiModelProperty(value = "订单id") 
	private Integer orderId;
		
	/**
	 * 
	 */
	
	@ApiModelProperty(value = "") 
	private Integer goodId;
		
	/**
	 * 商品规格价格id
	 */
	
	@ApiModelProperty(value = "商品规格价格id") 
	private Integer goodSpecPriceId;
		
	/**
	 * 商品购买数量
	 */
	
	@ApiModelProperty(value = "商品购买数量") 
	private Integer amount;
				
	
	/**
	 * 设置：订单id
	 */
	 
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * 获取：订单id
	 */
	public Integer getOrderId() {
		return orderId;
	}
				
	
	/**
	 * 设置：
	 */
	 
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	
	/**
	 * 获取：
	 */
	public Integer getGoodId() {
		return goodId;
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
	 * 设置：商品购买数量
	 */
	 
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	/**
	 * 获取：商品购买数量
	 */
	public Integer getAmount() {
		return amount;
	}
			
}
