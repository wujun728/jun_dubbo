package com.freeter.modules.good.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.validation.constraints.NotEmpty;
import java.lang.reflect.InvocationTargetException;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import org.apache.commons.beanutils.BeanUtils;


/**
 * 
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-23 10:29:33
 */
@TableName("cn_category_spec")
@ApiModel(value = "categorySpec")
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
			
	@NotEmpty (message = "商品分类id（商品规格和商品分类关联）不能为空") 			 
	@ApiModelProperty(value = "商品分类id（商品规格和商品分类关联）")
	private Integer categoryId;
	
	/**
	 * 规格名称
	 */
					 
	@ApiModelProperty(value = "规格名称")
	private String specName;
	
	/**
	 * 规格排序
	 */
					 
	@ApiModelProperty(value = "规格排序")
	private String sort;


	/**
	 * 是否可见
	 */
	@ApiModelProperty(value = "是否可见 1：可见 0 ：不可见")
	private String isShow;

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
	 * 设置是否可见
	 */
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	/**
	 * 获取是否可见
	 */
	public String getIsShow() {
		return isShow;
	}
}
