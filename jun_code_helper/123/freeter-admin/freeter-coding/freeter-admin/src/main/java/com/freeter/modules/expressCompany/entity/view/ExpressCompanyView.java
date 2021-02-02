package com.freeter.modules.expressCompany.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.expressCompany.entity.ExpressCompanyEntity;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;
 

/**
 * 
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-06-06 13:08:58
 */
@TableName("cn_express_company")
@ApiModel(value = "ExpressCompany")
public class ExpressCompanyView  extends ExpressCompanyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ExpressCompanyView(){
	}
 
 	public ExpressCompanyView(ExpressCompanyEntity expressCompanyEntity){
 	
 		BeanUtils.copyProperties(this, expressCompanyEntity);
	}
}
