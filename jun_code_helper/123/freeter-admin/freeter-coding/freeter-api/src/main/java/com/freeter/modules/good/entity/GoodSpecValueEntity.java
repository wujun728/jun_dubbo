package com.freeter.modules.good.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freeter.modules.good.entity.view.GoodSpecValueView;

import java.lang.reflect.InvocationTargetException;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;



/**
 * 
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-23 12:01:16
 */
@TableName("cn_good_spec_value")
@ApiModel(value = "GoodSpecValue")
public class GoodSpecValueEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GoodSpecValueEntity() {
		
	}
	
	public GoodSpecValueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 商品规格值表主键id
	 */
	
	@TableId 				 
	@ApiModelProperty(value = "商品规格值表主键id",hidden = true)
	private Integer id;
	
	/**
	 * 商品id
	 */
			
	@NotEmpty (message = "商品id不能为空") 			 
	@ApiModelProperty(value = "商品id")
	private Integer goodId;
	
	/**
	 * 分类规格id
	 */
			
	@NotEmpty (message = "分类规格id不能为空") 			 
	@ApiModelProperty(value = "分类规格id")
	private Integer categorySpecId;



	
	/**
	 * 商品规格值
	 */
				
	@NotBlank (message = "商品规格值不能为空") 		 
	@ApiModelProperty(value = "商品规格值")
	private String specValue;
	
	/**
	 * 设置：商品规格值表主键id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：商品规格值表主键id
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

	public Integer getCategorySpecId() {
		return categorySpecId;
	}

	public void setCategorySpecId(Integer categorySpecId) {
		this.categorySpecId = categorySpecId;
	}

}
