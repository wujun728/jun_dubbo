package com.freeter.modules.good.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freeter.modules.good.entity.GoodParameterEntity;

import java.io.Serializable;
 

/**
 * 商品参数表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
@ApiModel(value = "GoodParameterModel")
public class GoodParameterModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品ID
	 */
	
	@ApiModelProperty(value = "商品ID") 
	private Long goodId;
		
	/**
	 * 参数名
	 */
	
	@ApiModelProperty(value = "参数名") 
	private String name;
		
	/**
	 * 参数值
	 */
	
	@ApiModelProperty(value = "参数值") 
	private String value;
		
	/**
	 * 状态：1.显示；0.隐藏
	 */
	
	@ApiModelProperty(value = "状态：1.显示；0.隐藏") 
	private Integer status;
									
	
	/**
	 * 设置：商品ID
	 */
	 
	public void setGoodId(Long goodId) {
		this.goodId = goodId;
	}
	
	/**
	 * 获取：商品ID
	 */
	public Long getGoodId() {
		return goodId;
	}
				
	
	/**
	 * 设置：参数名
	 */
	 
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取：参数名
	 */
	public String getName() {
		return name;
	}
				
	
	/**
	 * 设置：参数值
	 */
	 
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * 获取：参数值
	 */
	public String getValue() {
		return value;
	}
				
	
	/**
	 * 设置：状态：1.显示；0.隐藏
	 */
	 
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * 获取：状态：1.显示；0.隐藏
	 */
	public Integer getStatus() {
		return status;
	}
													
}
