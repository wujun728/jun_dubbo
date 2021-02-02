package com.freeter.modules.good.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freeter.modules.good.entity.GoodSpecPriceEntity;

import java.io.Serializable;
 

/**
 * 规格价格表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-04 15:09:04
 */
@ApiModel(value = "GoodSpecPriceModel")
public class GoodSpecPriceModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品id
	 */
	
	@ApiModelProperty(value = "商品id") 
	private Integer goodId;
		
	/**
	 * 规格 以，相隔  内容为规格值表的id
	 */
	
	@ApiModelProperty(value = "规格 以，相隔  内容为规格值表的id") 
	private String spec;
		
	/**
	 * 价格
	 */
	
	@ApiModelProperty(value = "价格") 
	private BigDecimal price;
		
	/**
	 * 库存
	 */
	
	@ApiModelProperty(value = "库存") 
	private Integer stock;
		
	/**
	 * 是否默认
	 */
	
	@ApiModelProperty(value = "是否默认") 
	private String defaultStatus;
		
	/**
	 * 销售量
	 */
	
	@ApiModelProperty(value = "销售量") 
	private String salesVolume;
		
	/**
	 * 状态 0无库存 1 上架 2 下架
	 */
	
	@ApiModelProperty(value = "状态 0无库存 1 上架 2 下架") 
	private String status;
				
	
	/**
	 * 设置：商品id
	 */
	 
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	
	/**
	 * 获取：商品id
	 */
	public Integer getGoodId() {
		return goodId;
	}
				
	
	/**
	 * 设置：规格 以，相隔  内容为规格值表的id
	 */
	 
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	/**
	 * 获取：规格 以，相隔  内容为规格值表的id
	 */
	public String getSpec() {
		return spec;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	/**
	 * 获取：价格
	 */
	public BigDecimal getPrice() {
		return price;
	}
				
	
	/**
	 * 设置：库存
	 */
	 
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	/**
	 * 获取：库存
	 */
	public Integer getStock() {
		return stock;
	}
				
	
	/**
	 * 设置：是否默认
	 */
	 
	public void setDefaultStatus(String defaultStatus) {
		this.defaultStatus = defaultStatus;
	}
	
	/**
	 * 获取：是否默认
	 */
	public String getDefaultStatus() {
		return defaultStatus;
	}
				
	
	/**
	 * 设置：销售量
	 */
	 
	public void setSalesVolume(String salesVolume) {
		this.salesVolume = salesVolume;
	}
	
	/**
	 * 获取：销售量
	 */
	public String getSalesVolume() {
		return salesVolume;
	}
				
	
	/**
	 * 设置：状态 0无库存 1 上架 2 下架
	 */
	 
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 获取：状态 0无库存 1 上架 2 下架
	 */
	public String getStatus() {
		return status;
	}
			
}
