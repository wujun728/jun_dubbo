package com.freeter.modules.good.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freeter.modules.good.entity.GoodSpecValueEntity;

import java.io.Serializable;
 

/**
 * 商品规格值表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-02 15:23:17
 */
@ApiModel(value = "GoodSpecValueVO")
public class GoodSpecValueVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品id
	 */
	
	@ApiModelProperty(value = "商品id") 
	private Integer goodId;
		
	/**
	 * 分类规格id
	 */
	
	@ApiModelProperty(value = "分类规格id") 
	private Integer categorySpecId;
		
	/**
	 * 商品规格值
	 */
	
	@ApiModelProperty(value = "商品规格值") 
	private String specValue;
				
	
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
	 * 设置：分类规格id
	 */
	 
	public void setCategorySpecId(Integer categorySpecId) {
		this.categorySpecId = categorySpecId;
	}
	
	/**
	 * 获取：分类规格id
	 */
	public Integer getCategorySpecId() {
		return categorySpecId;
	}
				
	
	/**
	 * 设置：商品规格值
	 */
	 
	public void setSpecValue(String specValue) {
		this.specValue = specValue;
	}
	
	/**
	 * 获取：商品规格值
	 */
	public String getSpecValue() {
		return specValue;
	}
			
}
