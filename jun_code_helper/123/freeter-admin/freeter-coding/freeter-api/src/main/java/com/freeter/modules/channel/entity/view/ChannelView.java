package com.freeter.modules.channel.entity.view;

import com.baomidou.mybatisplus.annotations.TableId;
import com.freeter.modules.channel.entity.ChannelEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.beanutils.BeanUtils;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-06-08 14:46:17
 */

@ApiModel(value = "Channel")
public class ChannelView   implements Serializable {
	private static final long serialVersionUID = 1L;
	public ChannelView(){
	}
 	public ChannelView(ChannelEntity channelEntity){
		try {
			BeanUtils.copyProperties(this, channelEntity);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@ApiModelProperty(value = "频道id")
	private Long channelId;

	/**
	 * 频道名称
	 */

	@ApiModelProperty(value = "频道名称")
	private String name;


	/**
	 * 模式 1:商城 2：服务
	 */

	@ApiModelProperty(value = "模式 1:商城 2：服务")
	private Integer model;


	public Long getChannelId() {
		return channelId;
	}


	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}
}
