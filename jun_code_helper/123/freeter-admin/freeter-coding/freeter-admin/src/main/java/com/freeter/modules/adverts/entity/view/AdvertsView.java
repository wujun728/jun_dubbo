package com.freeter.modules.adverts.entity.view;

import com.freeter.modules.adverts.entity.AdvertsEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 广告位表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 12:36:59
 */
@TableName("cn_adverts")
@ApiModel(value = "Adverts")
public class AdvertsView  extends AdvertsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public AdvertsView(){
	}
 
 	public AdvertsView(AdvertsEntity advertsEntity){
 	try {
			BeanUtils.copyProperties(this, advertsEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
