package com.freeter.modules.expressCompany.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.beans.BeanUtils;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freeter.modules.expressCompany.entity.ExpressCompanyEntity;

import java.io.Serializable;
 

/**
 * 
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-06-06 13:08:58
 */
@ApiModel(value = "ExpressCompanySearch")
public class ExpressCompanySearch  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 快递公司编号
	 */
	
	@ApiModelProperty(value = "快递公司编号") 
	private String companyNumber;
		
	/**
	 * 快递公司名称
	 */
	
	@ApiModelProperty(value = "快递公司名称") 
	private String companyName;
				
	
	/**
	 * 设置：快递公司编号
	 */
	 
	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}
	
	/**
	 * 获取：快递公司编号
	 */
	public String getCompanyNumber() {
		return companyNumber;
	}
				
	
	/**
	 * 设置：快递公司名称
	 */
	 
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * 获取：快递公司名称
	 */
	public String getCompanyName() {
		return companyName;
	}
			
}
