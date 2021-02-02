package com.freeter.modules.category.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.category.entity.CategoryEntity;

import org.apache.commons.beanutils.BeanUtils;


import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;


/**
 * 分类表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-22 15:46:31
 */
@ApiModel(value = "Category")
public class CategoryView  implements Serializable {
	private static final long serialVersionUID = 1L;

	public CategoryView(){
	}

 	public CategoryView(CategoryEntity categoryEntity){

		try {
			BeanUtils.copyProperties(this, categoryEntity);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	private Long categoryId; //分类id
	private String CategoryName;//分类名称
	private Map seoMsg;//SEO信息


	public Long getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public Map getSeoMsg() {
		return seoMsg;
	}

	public void setSeoMsg(Map seoMsg) {
		this.seoMsg = seoMsg;
	}
}
