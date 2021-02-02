package com.freeter.modules.pc.entity.view;

import com.freeter.modules.pc.entity.PcEntity;

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
 * @date 2018-06-20 15:47:02
 */
@TableName("t_pc")
@ApiModel(value = "Pc")
public class PcView  extends PcEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PcView(){
	}
 
 	public PcView(PcEntity pcEntity){
 	try {
			BeanUtils.copyProperties(this, pcEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
