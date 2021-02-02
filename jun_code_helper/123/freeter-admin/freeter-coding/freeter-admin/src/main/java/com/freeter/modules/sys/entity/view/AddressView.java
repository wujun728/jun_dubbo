package com.freeter.modules.sys.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.sys.entity.AddressEntity;

import java.io.Serializable;
 

/**
 * 
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-18 13:41:16
 */
@TableName("cn_address")
@ApiModel(value = "Address")
public class AddressView  extends AddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

 
}
