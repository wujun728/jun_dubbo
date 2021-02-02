package com.freeter.modules.good.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freeter.modules.good.entity.GoodDetailEntity;

import java.io.Serializable;
 

/**
 * 商品描述表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-07 15:43:06
 */
@ApiModel(value = "GoodDetailModel")
public class GoodDetailModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品ID
	 */
	
	@ApiModelProperty(value = "商品ID") 
	private Long goodId;
		
	/**
	 * 商品描述
	 */
	
	@ApiModelProperty(value = "商品描述") 
	private String description;
								
	
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
	 * 设置：商品描述
	 */
	 
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 获取：商品描述
	 */
	public String getDescription() {
		return description;
	}
											
}
