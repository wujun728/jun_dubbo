package com.freeter.modules.pc.entity.view;

import com.freeter.modules.pc.entity.SchoolEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 12:40:06
 */
@TableName("t_school")
@ApiModel(value = "School")
public class SchoolView  extends SchoolEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public SchoolView(){
	}
 
 	public SchoolView(SchoolEntity schoolEntity){
 	try {
			BeanUtils.copyProperties(this, schoolEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
