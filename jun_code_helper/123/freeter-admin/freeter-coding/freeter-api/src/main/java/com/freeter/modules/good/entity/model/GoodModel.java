package com.freeter.modules.good.entity.model;

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
@ApiModel(value = "GoodModel")
public class GoodModel  implements Serializable {
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
	 * 是否置顶 1=置顶/0=默认
	 */
	
	@ApiModelProperty(value = "是否置顶 1=置顶/0=默认") 
	private Integer showInTop;
		
	/**
	 * 是否导航栏 1=显示/0=隐藏
	 */
	
	@ApiModelProperty(value = "是否导航栏 1=显示/0=隐藏") 
	private Integer showInNav;
		
	/**
	 * 猜你喜欢 1=显示/0=隐藏
	 */
	
	@ApiModelProperty(value = "猜你喜欢 1=显示/0=隐藏") 
	private Integer showInLike;
		
	/**
	 * 是否热门 1=热门/0=默认
	 */
	
	@ApiModelProperty(value = "是否热门 1=热门/0=默认") 
	private Integer showInHot;
		
	/**
	 * 是否上架：1=上架/0=下架
	 */
	
	@ApiModelProperty(value = "是否上架：1=上架/0=下架") 
	private Integer showInShelve;
		
	/**
	 * 搜索的关键词
	 */
	
	@ApiModelProperty(value = "搜索的关键词") 
	private String searchKey;
		
	/**
	 * 页面标题
	 */
	
	@ApiModelProperty(value = "页面标题") 
	private String pageTitle;
		
	/**
	 * 页面的描述
	 */
	
	@ApiModelProperty(value = "页面的描述") 
	private String pageDescription;
		
	/**
	 * 页面的关键词
	 */
	
	@ApiModelProperty(value = "页面的关键词") 
	private String pageKeyword;
		
	/**
	 * 备注信息
	 */
	
	@ApiModelProperty(value = "备注信息") 
	private String remarks;
				
	 
	
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
				
	
	/**
	 * 设置：是否置顶 1=置顶/0=默认
	 */
	 
	public void setShowInTop(Integer showInTop) {
		this.showInTop = showInTop;
	}
	
	/**
	 * 获取：是否置顶 1=置顶/0=默认
	 */
	public Integer getShowInTop() {
		return showInTop;
	}
				
	
	/**
	 * 设置：是否导航栏 1=显示/0=隐藏
	 */
	 
	public void setShowInNav(Integer showInNav) {
		this.showInNav = showInNav;
	}
	
	/**
	 * 获取：是否导航栏 1=显示/0=隐藏
	 */
	public Integer getShowInNav() {
		return showInNav;
	}
				
	
	/**
	 * 设置：猜你喜欢 1=显示/0=隐藏
	 */
	 
	public void setShowInLike(Integer showInLike) {
		this.showInLike = showInLike;
	}
	
	/**
	 * 获取：猜你喜欢 1=显示/0=隐藏
	 */
	public Integer getShowInLike() {
		return showInLike;
	}
				
	
	/**
	 * 设置：是否热门 1=热门/0=默认
	 */
	 
	public void setShowInHot(Integer showInHot) {
		this.showInHot = showInHot;
	}
	
	/**
	 * 获取：是否热门 1=热门/0=默认
	 */
	public Integer getShowInHot() {
		return showInHot;
	}
				
	
	/**
	 * 设置：是否上架：1=上架/0=下架
	 */
	 
	public void setShowInShelve(Integer showInShelve) {
		this.showInShelve = showInShelve;
	}
	
	/**
	 * 获取：是否上架：1=上架/0=下架
	 */
	public Integer getShowInShelve() {
		return showInShelve;
	}
				
	
	/**
	 * 设置：搜索的关键词
	 */
	 
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	
	/**
	 * 获取：搜索的关键词
	 */
	public String getSearchKey() {
		return searchKey;
	}
				
	
	/**
	 * 设置：页面标题
	 */
	 
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	
	/**
	 * 获取：页面标题
	 */
	public String getPageTitle() {
		return pageTitle;
	}
				
	
	/**
	 * 设置：页面的描述
	 */
	 
	public void setPageDescription(String pageDescription) {
		this.pageDescription = pageDescription;
	}
	
	/**
	 * 获取：页面的描述
	 */
	public String getPageDescription() {
		return pageDescription;
	}
				
	
	/**
	 * 设置：页面的关键词
	 */
	 
	public void setPageKeyword(String pageKeyword) {
		this.pageKeyword = pageKeyword;
	}
	
	/**
	 * 获取：页面的关键词
	 */
	public String getPageKeyword() {
		return pageKeyword;
	}
				
	
	/**
	 * 设置：备注信息
	 */
	 
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	/**
	 * 获取：备注信息
	 */
	public String getRemarks() {
		return remarks;
	}
											
}
