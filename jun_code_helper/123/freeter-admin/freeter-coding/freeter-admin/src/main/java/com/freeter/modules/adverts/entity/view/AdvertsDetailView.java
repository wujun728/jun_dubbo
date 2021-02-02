package com.freeter.modules.adverts.entity.view;

import com.freeter.modules.adverts.entity.AdvertsDetailEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 广告位详情
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 12:36:59
 */
@TableName("cn_adverts_detail")
@ApiModel(value = "AdvertsDetail")
public class AdvertsDetailView  extends AdvertsDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public AdvertsDetailView(){
	}
 
 	public AdvertsDetailView(AdvertsDetailEntity advertsDetailEntity){
 	try {
			BeanUtils.copyProperties(this, advertsDetailEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
