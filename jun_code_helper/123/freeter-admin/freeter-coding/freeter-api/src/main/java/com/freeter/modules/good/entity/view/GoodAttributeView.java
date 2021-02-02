package com.freeter.modules.good.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.good.entity.GoodAttributeEntity;

import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 商品属性表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
@TableName("cn_good_attribute")
@ApiModel(value = "GoodAttribute")
public class GoodAttributeView  extends GoodAttributeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoodAttributeView(){
	}
 
 	public GoodAttributeView(GoodAttributeEntity goodAttributeEntity){
 	try {
			BeanUtils.copyProperties(this, goodAttributeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
