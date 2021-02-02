package com.freeter.modules.good.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freeter.modules.good.entity.GoodEntity;

import java.io.Serializable;
 

/**
 * 商品表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-31 09:01:38
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
	 * 最大价格
	 */
	
	@ApiModelProperty(value = "最大价格") 
	private BigDecimal maxPrice;
		
	/**
	 * 最小价格
	 */
	
	@ApiModelProperty(value = "最小价格") 
	private BigDecimal minPrice;
		
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
	 * 销量
	 */
	
	@ApiModelProperty(value = "销量") 
	private String sales;
		
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
	 * 上架时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "上架时间") 
	private Date shelveTime;
		
	/**
	 * 上架人
	 */
	
	@ApiModelProperty(value = "上架人") 
	private String shelveBy;
				
	/**
	 * 商户id
	 */
	
	@ApiModelProperty(value = "商户id") 
	private Long martId;
		
	/**
	 * 
	 */
	
	@ApiModelProperty(value = "") 
	private Integer delFlag;
				
	
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
	 * 设置：最大价格
	 */
	 
	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	/**
	 * 获取：最大价格
	 */
	public BigDecimal getMaxPrice() {
		return maxPrice;
	}
				
	
	/**
	 * 设置：最小价格
	 */
	 
	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}
	
	/**
	 * 获取：最小价格
	 */
	public BigDecimal getMinPrice() {
		return minPrice;
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
	 * 设置：销量
	 */
	 
	public void setSales(String sales) {
		this.sales = sales;
	}
	
	/**
	 * 获取：销量
	 */
	public String getSales() {
		return sales;
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
								
	
	/**
	 * 设置：上架时间
	 */
	 
	public void setShelveTime(Date shelveTime) {
		this.shelveTime = shelveTime;
	}
	
	/**
	 * 获取：上架时间
	 */
	public Date getShelveTime() {
		return shelveTime;
	}
				
	
	/**
	 * 设置：上架人
	 */
	 
	public void setShelveBy(String shelveBy) {
		this.shelveBy = shelveBy;
	}
	
	/**
	 * 获取：上架人
	 */
	public String getShelveBy() {
		return shelveBy;
	}
								
	
	/**
	 * 设置：商户id
	 */
	 
	public void setMartId(Long martId) {
		this.martId = martId;
	}
	
	/**
	 * 获取：商户id
	 */
	public Long getMartId() {
		return martId;
	}
				
	
	/**
	 * 设置：
	 */
	 
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	
	/**
	 * 获取：
	 */
	public Integer getDelFlag() {
		return delFlag;
	}
			
}
