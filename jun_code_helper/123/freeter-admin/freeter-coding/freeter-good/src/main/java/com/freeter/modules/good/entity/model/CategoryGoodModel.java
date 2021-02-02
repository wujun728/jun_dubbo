package com.freeter.modules.good.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freeter.modules.good.entity.CategoryGoodEntity;

import java.io.Serializable;
 

/**
 * 分类表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-01 16:28:07
 */
@ApiModel(value = "CategoryGoodModel")
public class CategoryGoodModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 
	 */
	
	@ApiModelProperty(value = "") 
	private String categoryName;
		
	/**
	 * 商品id
	 */
	
	@ApiModelProperty(value = "商品id") 
	private Long goodId;
						
	
	/**
	 * 设置：
	 */
	 
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	/**
	 * 获取：
	 */
	public String getCategoryName() {
		return categoryName;
	}
				
	
	/**
	 * 设置：商品id
	 */
	 
	public void setGoodId(Long goodId) {
		this.goodId = goodId;
	}
	
	/**
	 * 获取：商品id
	 */
	public Long getGoodId() {
		return goodId;
	}
							
}
