package com.freeter.modules.good.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freeter.modules.good.entity.GoodImageEntity;

import java.io.Serializable;
 

/**
 * 商品图片表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
@ApiModel(value = "GoodImageVO")
public class GoodImageVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品ID
	 */
	
	@ApiModelProperty(value = "商品ID") 
	private Long goodId;
		
	/**
	 * 展示图片
	 */
	
	@ApiModelProperty(value = "展示图片") 
	private String picImg;
			
	 
	
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
	 * 设置：展示图片
	 */
	 
	public void setPicImg(String picImg) {
		this.picImg = picImg;
	}
	
	/**
	 * 获取：展示图片
	 */
	public String getPicImg() {
		return picImg;
	}
												
}
