package com.freeter.modules.user.entity.view;

import com.freeter.modules.user.entity.UserEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 用户表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 13:55:47
 */
@ApiModel(value = "User")
public class UserView  extends UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public UserView(){
	}
 
 	public UserView(UserEntity userEntity){
 	try {
			BeanUtils.copyProperties(this, userEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
