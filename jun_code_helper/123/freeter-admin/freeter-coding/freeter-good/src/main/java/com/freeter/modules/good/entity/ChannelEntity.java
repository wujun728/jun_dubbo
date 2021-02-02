package com.freeter.modules.good.entity;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.common.annotation.OwnerTable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 频道
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-28 17:34:00
 */
@TableName("cn_channel")
@ApiModel(value = "Channel")
@OwnerTable(ChannelEntity.class)
public class ChannelEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChannelEntity() {
		
	}
	
	public ChannelEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	
	@TableId 				 
	@ApiModelProperty(value = "",hidden = true)
	private Long channelId;
	
	/**
	 * 频道名称
	 */
					 
	@ApiModelProperty(value = "频道名称")
	private String name;
	
	/**
	 * 排序
	 */
					 
	@ApiModelProperty(value = "排序")
	private Integer sort;
	
	/**
	 * 设置：
	 */
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	/**
	 * 获取：
	 */
	public Long getChannelId() {
		return channelId;
	}
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
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
}
