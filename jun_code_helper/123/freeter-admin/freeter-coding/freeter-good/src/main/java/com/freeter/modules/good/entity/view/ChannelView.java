package com.freeter.modules.good.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.good.entity.ChannelEntity;

import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 频道
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-28 17:34:00
 */
@TableName("cn_channel")
@ApiModel(value = "Channel")
public class ChannelView  extends ChannelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChannelView(){
	}
 
 	public ChannelView(ChannelEntity channelEntity){
 	try {
			BeanUtils.copyProperties(this, channelEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
