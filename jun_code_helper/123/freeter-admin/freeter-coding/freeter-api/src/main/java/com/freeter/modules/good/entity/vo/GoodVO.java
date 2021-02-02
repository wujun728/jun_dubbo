package com.freeter.modules.good.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freeter.modules.good.entity.GoodEntity;

import java.io.Serializable;
 

/**
 * 商品表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:00
 */
@ApiModel(value = "GoodVO")
public class GoodVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品名称
	 */
	
	@ApiModelProperty(value = "商品名称") 
	private String goodName;
		
	/**
	 * 商品编号
	 */
	
	@ApiModelProperty(value = "商品编号") 
	private String goodNumber;
		
	/**
	 * 显示价格
	 */
	
	@ApiModelProperty(value = "显示价格") 
	private String showPrice;
		
	/**
	 * 商品简介
	 */
	
	@ApiModelProperty(value = "商品简介") 
	private String introduce;
		
	/**
	 * 展示图片
	 */
	
	@ApiModelProperty(value = "展示图片") 
	private String picImg;
		
	  
	
	/**
	 * 设置：商品名称
	 */
	 
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	
	/**
	 * 获取：商品名称
	 */
	public String getGoodName() {
		return goodName;
	}
				
	
	/**
	 * 设置：商品编号
	 */
	 
	public void setGoodNumber(String goodNumber) {
		this.goodNumber = goodNumber;
	}
	
	/**
	 * 获取：商品编号
	 */
	public String getGoodNumber() {
		return goodNumber;
	}
				
	
	/**
	 * 设置：显示价格
	 */
	 
	public void setShowPrice(String showPrice) {
		this.showPrice = showPrice;
	}
	
	/**
	 * 获取：显示价格
	 */
	public String getShowPrice() {
		return showPrice;
	}
				
	
	/**
	 * 设置：商品简介
	 */
	 
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	/**
	 * 获取：商品简介
	 */
	public String getIntroduce() {
		return introduce;
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
