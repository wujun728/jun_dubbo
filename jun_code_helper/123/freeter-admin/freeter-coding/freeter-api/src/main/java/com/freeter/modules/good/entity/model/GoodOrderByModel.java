package com.freeter.modules.good.entity.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
 

/**
 * 商品表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:00
 */
@ApiModel(value = "GoodModel")
public class GoodOrderByModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "分类ID") 
	private Long categoryId;
	 			
	/**
	 * 商品名称
	 */
	//@NotBlank(message="查询内容不能为空")
	@ApiModelProperty(value = "查询关键字") 
	private String search;
	
	/**
	 * 排序
	 */
	
	@ApiModelProperty(value = "排序：（销量:sale 价格:price）") 
	private String orderBy;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	
}
