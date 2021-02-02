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
 * 商品描述表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-07 15:43:06
 */
@TableName("cn_good_detail")
@ApiModel(value = "GoodDetail")
public class GoodDetailEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GoodDetailEntity() {
		
	}
	
	public GoodDetailEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 商品描述ID
	 */
	
	@TableId 					
	@ApiModelProperty(value = "商品描述ID",hidden = true)
	private Long goodDetailId;
	
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
	 * 更新时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@TableField(fill = FieldFill.UPDATE) 	
	@ApiModelProperty(value = "更新时间",hidden = true)
	private Date updateTime;
	
	/**
	 * 更新者
	 */
						
	@TableField(fill = FieldFill.UPDATE) 	
	@ApiModelProperty(value = "更新者",hidden = true)
	private String updateBy;
	
	/**
	 * 设置：商品描述ID
	 */
	public void setGoodDetailId(Long goodDetailId) {
		this.goodDetailId = goodDetailId;
	}
	/**
	 * 获取：商品描述ID
	 */
	public Long getGoodDetailId() {
		return goodDetailId;
	}
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
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：更新者
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：更新者
	 */
	public String getUpdateBy() {
		return updateBy;
	}
}
