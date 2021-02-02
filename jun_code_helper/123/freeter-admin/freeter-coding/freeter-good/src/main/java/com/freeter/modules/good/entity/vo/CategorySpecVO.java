package com.freeter.modules.good.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freeter.modules.good.entity.CategorySpecEntity;

import java.io.Serializable;
 

/**
 * 分类规格表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-31 18:32:07
 */
@ApiModel(value = "CategorySpecVO")
public class CategorySpecVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品分类id（商品规格和商品分类关联）
	 */
	
	@ApiModelProperty(value = "商品分类id（商品规格和商品分类关联）") 
	private Integer categoryId;
		
	/**
	 * 规格名称
	 */
	
	@ApiModelProperty(value = "规格名称") 
	private String specName;
			
	/**
	 * 是否可见 1 可见 0不可见
	 */
	
	@ApiModelProperty(value = "是否可见 1 可见 0不可见") 
	private String isShow;
		
	/**
	 * 手机端是否可见 1可见 0不可见
	 */
	
	@ApiModelProperty(value = "手机端是否可见 1可见 0不可见") 
	private Integer isMobileShow;
				
	
	/**
	 * 设置：商品分类id（商品规格和商品分类关联）
	 */
	 
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	/**
	 * 获取：商品分类id（商品规格和商品分类关联）
	 */
	public Integer getCategoryId() {
		return categoryId;
	}
				
	
	/**
	 * 设置：规格名称
	 */
	 
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	
	/**
	 * 获取：规格名称
	 */
	public String getSpecName() {
		return specName;
	}
						
	
	/**
	 * 设置：是否可见 1 可见 0不可见
	 */
	 
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	
	/**
	 * 获取：是否可见 1 可见 0不可见
	 */
	public String getIsShow() {
		return isShow;
	}
				
	
	/**
	 * 设置：手机端是否可见 1可见 0不可见
	 */
	 
	public void setIsMobileShow(Integer isMobileShow) {
		this.isMobileShow = isMobileShow;
	}
	
	/**
	 * 获取：手机端是否可见 1可见 0不可见
	 */
	public Integer getIsMobileShow() {
		return isMobileShow;
	}
			
}
