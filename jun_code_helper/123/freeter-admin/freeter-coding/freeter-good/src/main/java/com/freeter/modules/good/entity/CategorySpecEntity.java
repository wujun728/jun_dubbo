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
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;



/**
 * 分类规格表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-31 18:32:07
 */
@TableName("cn_category_spec")
@ApiModel(value = "CategorySpec")
public class CategorySpecEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CategorySpecEntity() {
		
	}
	
	public CategorySpecEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	
	@TableId 					
	@ApiModelProperty(value = "",hidden = true)
	private Integer id;
	
	/**
	 * 商品分类id（商品规格和商品分类关联）
	 */
			
	@NotNull (message = "商品分类id（商品规格和商品分类关联）不能为空") 				
	@ApiModelProperty(value = "商品分类id（商品规格和商品分类关联）")
	private Integer categoryId;
	
	/**
	 * 规格名称
	 */
				
	@NotBlank (message = "规格名称不能为空") 			
	@ApiModelProperty(value = "规格名称")
	private String specName;
	
	/**
	 * 规格排序
	 */
				
	@NotBlank (message = "规格排序不能为空") 			
	@ApiModelProperty(value = "规格排序")
	private String sort;
	
	/**
	 * 是否可见 1 可见 0不可见
	 */
				
	@NotBlank (message = "是否可见 1 可见 0不可见不能为空") 			
	@ApiModelProperty(value = "是否可见 1 可见 0不可见")
	private String isShow;
	
	/**
	 * 手机端是否可见 1可见 0不可见
	 */
						
	@ApiModelProperty(value = "手机端是否可见 1可见 0不可见")
	private Integer isMobileShow;
	
	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
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
	 * 设置：规格排序
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	/**
	 * 获取：规格排序
	 */
	public String getSort() {
		return sort;
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
