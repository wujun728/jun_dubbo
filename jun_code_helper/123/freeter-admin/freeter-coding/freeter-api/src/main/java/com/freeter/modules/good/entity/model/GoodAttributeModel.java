package com.freeter.modules.good.entity.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
 

/**
 * 商品属性表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
@ApiModel(value = "GoodAttributeModel")
public class GoodAttributeModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品ID
	 */
	@NotNull(message="商品ID不能为空")
	@ApiModelProperty(value = "商品ID") 
	private Long goodId;
		
	
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
						
}
