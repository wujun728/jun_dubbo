package com.freeter.modules.user.entity.view;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.user.entity.UserEntity;

import io.swagger.annotations.ApiModel;
 

/**
 * 用户表
 * 
 * @author liuqi
 * @email 171998110@qq.com
 * @date 2018-05-19 13:46:34
 */
@TableName("cn_user")
@ApiModel(value = "User")
public class UserView  extends UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public UserView(){
	}
 
 	public UserView(UserEntity userEntity){
 	
 		try {
			BeanUtils.copyProperties(this, userEntity);
		} catch (IllegalAccessException e) {
 			e.printStackTrace();
		} catch (InvocationTargetException e) {
 			e.printStackTrace();
		}
	}
}
