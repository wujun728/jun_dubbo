package com.freeter.modules.good.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.good.entity.GoodParameterEntity;

import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 商品参数表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
@TableName("cn_good_parameter")
@ApiModel(value = "GoodParameter")
public class GoodParameterView  extends GoodParameterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoodParameterView(){
	}
 
 	public GoodParameterView(GoodParameterEntity goodParameterEntity){
 	try {
			BeanUtils.copyProperties(this, goodParameterEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
