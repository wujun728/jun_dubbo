package com.freeter.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freeter.modules.order.entity.view.OrderGoodView;

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
 * 
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-28 17:20:50
 */
@TableName("cn_order_good")
@ApiModel(value = "OrderGood")
public class OrderGoodEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	public OrderGoodEntity() {

	}
	public OrderGoodEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 主键
	 */
	
	@TableId 				 
	@ApiModelProperty(value = "主键",hidden = true)
	private Integer id;
	
	/**
	 * 订单id
	 */
			
	@NotNull (message = "订单编号不能为空")
	@ApiModelProperty(value = "订单编号")
	private String orderNo;
	
	/**
	 * 
	 */
			
	@NotNull (message = "不能为空") 			 
	@ApiModelProperty(value = "")
	private Integer goodId;
	
	/**
	 * 商品规格价格id
	 */
			
	@NotNull (message = "商品规格价格id不能为空") 			 
	@ApiModelProperty(value = "商品规格价格id")
	private Integer goodSpecPriceId;
	
	/**
	 * 商品购买数量
	 */
			
	@NotNull (message = "商品购买数量不能为空") 			 
	@ApiModelProperty(value = "商品购买数量")
	private Integer amount;
	
	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：订单编号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单编号
	 */
	public String getOrderNo() {
		return orderNo;
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
