package com.freeter.modules.good.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;




/**
 * 规格价格表
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-24 14:04:18
 */
@TableName("cn_good_spec_price")
@ApiModel(value = "GoodSpecPrice")
public class GoodSpecPriceEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GoodSpecPriceEntity() {
		
	}
	
	public GoodSpecPriceEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 商品规格价格表id 主键
	 */
	
	@TableId 				 
	@ApiModelProperty(value = "商品规格价格表id 主键",hidden = true)
	private Integer id;
	
	/**
	 * 商品id
	 */
			
	@NotNull (message = "商品id不能为空") 			 
	@ApiModelProperty(value = "商品id")
	private Integer goodId;
	
	/**
	 * 规格 以，相隔  内容为规格值表的id
	 */
				
	@NotBlank (message = "规格 以，相隔  内容为规格值表的id不能为空") 		 
	@ApiModelProperty(value = "规格 以，相隔  内容为规格值表的id")
	private String spec;
	
	/**
	 * 价格
	 */
			
	@NotNull (message = "价格不能为空") 			 
	@ApiModelProperty(value = "价格")
	private BigDecimal price;
	
	/**
	 * 库存
	 */
			
	@NotNull (message = "库存不能为空") 			 
	@ApiModelProperty(value = "库存")
	private Integer stock;
	
	/**
	 * 是否默认
	 */
				
	@NotBlank (message = "是否默认不能为空") 		 
	@ApiModelProperty(value = "是否默认")
	private String defaultStatus;
	
	/**
	 * 销售量
	 */
				
	@NotBlank (message = "销售量不能为空") 		 
	@ApiModelProperty(value = "销售量")
	private String salesVolume;
	
	/**
	 * 状态 0无库存 1 上架 2 下架
	 */
				
	@NotBlank (message = "状态 0无库存 1 上架 2 下架不能为空") 		 
	@ApiModelProperty(value = "状态 0无库存 1 上架 2 下架")
	private String status;
	
	/**
	 * 设置：商品规格价格表id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：商品规格价格表id 主键
	 */
	public Integer getId() {
		return id;
	}
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
