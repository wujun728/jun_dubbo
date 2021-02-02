package com.freeter.modules.good.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.good.entity.GoodSpecPriceEntity;

import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 规格价格表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-04 15:09:04
 */
@TableName("cn_good_spec_price")
@ApiModel(value = "GoodSpecPrice")
public class GoodSpecPriceView  extends GoodSpecPriceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoodSpecPriceView(){
	}
 
 	public GoodSpecPriceView(GoodSpecPriceEntity goodSpecPriceEntity){
 	try {
			BeanUtils.copyProperties(this, goodSpecPriceEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
