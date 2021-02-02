package com.freeter.modules.good.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freeter.modules.good.entity.ChannelEntity;

import java.io.Serializable;
 

/**
 * 频道
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-28 17:34:00
 */
@ApiModel(value = "ChannelModel")
public class ChannelModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 频道名称
	 */
	
	@ApiModelProperty(value = "频道名称") 
	private String name;
					
	
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
					
}
