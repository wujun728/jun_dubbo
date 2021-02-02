package com.freeter.modules.good.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.good.entity.CategorySpecEntity;

import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import javax.validation.constraints.NotNull;

import java.io.Serializable;
 

/**
 * 分类规格表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-31 18:32:07
 */
@TableName("cn_category_spec")
@ApiModel(value = "CategorySpec")
public class CategorySpecView  extends CategorySpecEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CategorySpecView(){
	}
	
 	private Integer categoryId;
	
	private String categoryName;
	
	private Long[] categoryIds;
	
 	public CategorySpecView(CategorySpecEntity categorySpecEntity){
 	try {
			BeanUtils.copyProperties(this, categorySpecEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public Long[] getCategoryIds() {
		return categoryIds;
	}


	public void setCategoryIds(Long[] categoryIds) {
		this.categoryIds = categoryIds;
	}


	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
 	
 	
}
