package com.freeter.modules.channel.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.beans.BeanUtils;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freeter.modules.channel.entity.ChannelEntity;

import java.io.Serializable;
 

/**
 * 
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-06-08 14:46:17
 */
@ApiModel(value = "ChannelSearch")
public class ChannelSearch  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 频道名称
	 */
	
	@ApiModelProperty(value = "频道名称") 
	private String name;
			
	/**
	 * 是否展示（0展示，1不展示）
	 */
	
	@ApiModelProperty(value = "是否展示（0展示，1不展示）") 
	private Integer isShow;
		
	/**
	 * 模式 1:商城 2：服务
	 */
	
	@ApiModelProperty(value = "模式 1:商城 2：服务") 
	private Integer model;
				
	
	/**
	 * 设置：频道名称
	 */
	 
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取：频道名称
	 */
	public String getName() {
		return name;
	}
						
	
	/**
	 * 设置：是否展示（0展示，1不展示）
	 */
	 
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	
	/**
	 * 获取：是否展示（0展示，1不展示）
	 */
	public Integer getIsShow() {
		return isShow;
	}
				
	
	/**
	 * 设置：模式 1:商城 2：服务
	 */
	 
	public void setModel(Integer model) {
		this.model = model;
	}
	
	/**
	 * 获取：模式 1:商城 2：服务
	 */
	public Integer getModel() {
		return model;
	}
			
}
