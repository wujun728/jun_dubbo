package com.freeter.modules.good.entity.view;

import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.good.entity.CategorySpecEntity;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;
 

/**
 * 
 * 
 * @author xuchen
 * @email 363236211@qq.com
 * @date 2018-05-23 10:29:33
 */
@TableName("cn_good")
@ApiModel(value = "goodSpec")
public class CategorySpecView extends CategorySpecEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CategorySpecView(){
	}
 
 	public CategorySpecView(CategorySpecEntity goodSpecEntity){
 	
 		BeanUtils.copyProperties(this, goodSpecEntity);
	}
}
