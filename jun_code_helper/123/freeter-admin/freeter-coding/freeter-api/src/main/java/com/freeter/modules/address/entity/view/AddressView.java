package com.freeter.modules.address.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.address.entity.AddressEntity;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;
 

/**
 * 
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-19 17:57:52
 */
@TableName("cn_address")
@ApiModel(value = "Address")
public class AddressView  extends AddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public AddressView(){
	}
 
 	public AddressView(AddressEntity addressEntity){
 	
 		BeanUtils.copyProperties(this, addressEntity);
	}
}
