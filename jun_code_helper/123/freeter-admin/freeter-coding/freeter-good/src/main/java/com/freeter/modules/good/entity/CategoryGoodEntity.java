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
 * 分类表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-01 16:28:07
 */
@TableName("cn_category_good")
@ApiModel(value = "CategoryGood")
public class CategoryGoodEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CategoryGoodEntity() {
		
	}
	
	public CategoryGoodEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 分类ID
	 */
	
	@TableId 					
	@ApiModelProperty(value = "分类ID",hidden = true)
	private Long categoryGoodId;
	
	/**
	 * 分类ID
	 */
	@NotNull(message = "分类id不能为空")
 	@ApiModelProperty(value = "分类ID")
	private Long categoryId;
	
	/**
	 * 
	 */
				
	@NotBlank (message = "不能为空") 			
	@ApiModelProperty(value = "")
	private String categoryName;
	
	/**
	 * 商品id
	 */
						
	@ApiModelProperty(value = "商品id")
	private Long goodId;
	
	/**
	 * 创建时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 			
	@TableField(fill = FieldFill.INSERT) 
	@ApiModelProperty(value = "创建时间",hidden = true)
	private Date createTime;
	
	/**
	 * 创建者
	 */
							
	@TableField(fill = FieldFill.INSERT) 
	@ApiModelProperty(value = "创建者",hidden = true)
	private String createBy;
	
	/**
	 * 设置：分类ID
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * 获取：分类ID
	 */
	public Long getCategoryId() {
		return categoryId;
	}
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
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：创建者
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建者
	 */
	public String getCreateBy() {
		return createBy;
	}

	public Long getCategoryGoodId() {
		return categoryGoodId;
	}

	public void setCategoryGoodId(Long categoryGoodId) {
		this.categoryGoodId = categoryGoodId;
	}
	
}
