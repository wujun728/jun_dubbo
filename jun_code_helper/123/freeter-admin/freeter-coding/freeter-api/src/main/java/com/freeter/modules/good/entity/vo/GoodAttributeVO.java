package com.freeter.modules.good.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freeter.modules.good.entity.GoodAttributeEntity;

import java.io.Serializable;
 

/**
 * 商品属性表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
@ApiModel(value = "GoodAttributeVO")
public class GoodAttributeVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品ID
	 */
	
	@ApiModelProperty(value = "商品ID") 
	private Long goodId;
		
	/**
	 * 总库存
	 */
	
	@ApiModelProperty(value = "总库存") 
	private Long stock;
		
	/**
	 * 销售量
	 */
	
	@ApiModelProperty(value = "销售量") 
	private Long salesVolume;
	
				
	
	/**
	 * 设置：商品ID
	 */
	 
	public void setGoodId(Long goodId) {
		this.goodId = goodId;
	}
	
	/**
	 * 获取：商品ID
	 */
	public Long getGoodId() {
		return goodId;
	}
				
	
	/**
	 * 设置：总库存
	 */
	 
	public void setStock(Long stock) {
		this.stock = stock;
	}
	
	/**
	 * 获取：总库存
	 */
	public Long getStock() {
		return stock;
	}
				
	
	/**
	 * 设置：销售量
	 */
	 
	public void setSalesVolume(Long salesVolume) {
		this.salesVolume = salesVolume;
	}
	
	/**
	 * 获取：销售量
	 */
	public Long getSalesVolume() {
		return salesVolume;
	}
				
			
}
