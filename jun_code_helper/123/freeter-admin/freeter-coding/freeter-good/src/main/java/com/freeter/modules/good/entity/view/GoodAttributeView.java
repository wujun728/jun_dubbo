package com.freeter.modules.good.entity.view;

import com.freeter.modules.good.entity.GoodAttributeEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 商品属性表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-30 17:28:16
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
