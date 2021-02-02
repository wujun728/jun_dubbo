package com.freeter.modules.good.entity.vo;

import com.freeter.modules.good.entity.GoodAttributeEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 商品属性表
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-30 17:28:16
 */
@ApiModel(value = "GoodAttributeVO")
public class GoodAttributeVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品ID
	 */
	
	@ApiModelProperty(value = "商品ID") 
	private Long goodId;
		
	/**
	 * 总库存
	 */
	
	@ApiModelProperty(value = "总库存") 
	private Long stock;
		
	/**
	 * 销售量
	 */
	
	@ApiModelProperty(value = "销售量") 
	private Long salesVolume;
		
	/**
	 * 总访问量
	 */
	
	@ApiModelProperty(value = "总访问量") 
	private Long pageViews;
		
	/**
	 * 评论数量
	 */
	
	@ApiModelProperty(value = "评论数量") 
	private Long commentNumber;
		
	/**
	 * 累计评价
	 */
	
	@ApiModelProperty(value = "累计评价") 
	private Long commentTotal;
		
	/**
	 * 平均评价
	 */
	
	@ApiModelProperty(value = "平均评价") 
	private BigDecimal commentAverage;
		
	/**
	 * 收藏数
	 */
	
	@ApiModelProperty(value = "收藏数") 
	private Long favoriteNumber;
		
	/**
	 * 提问数
	 */
	
	@ApiModelProperty(value = "提问数") 
	private Long questionNumber;
				
	
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
	 * 设置：总库存
	 */
	 
	public void setStock(Long stock) {
		this.stock = stock;
	}
	
	/**
	 * 获取：总库存
	 */
	public Long getStock() {
		return stock;
	}
				
	
	/**
	 * 设置：销售量
	 */
	 
	public void setSalesVolume(Long salesVolume) {
		this.salesVolume = salesVolume;
	}
	
	/**
	 * 获取：销售量
	 */
	public Long getSalesVolume() {
		return salesVolume;
	}
				
	
	/**
	 * 设置：总访问量
	 */
	 
	public void setPageViews(Long pageViews) {
		this.pageViews = pageViews;
	}
	
	/**
	 * 获取：总访问量
	 */
	public Long getPageViews() {
		return pageViews;
	}
				
	
	/**
	 * 设置：评论数量
	 */
	 
	public void setCommentNumber(Long commentNumber) {
		this.commentNumber = commentNumber;
	}
	
	/**
	 * 获取：评论数量
	 */
	public Long getCommentNumber() {
		return commentNumber;
	}
				
	
	/**
	 * 设置：累计评价
	 */
	 
	public void setCommentTotal(Long commentTotal) {
		this.commentTotal = commentTotal;
	}
	
	/**
	 * 获取：累计评价
	 */
	public Long getCommentTotal() {
		return commentTotal;
	}
				
	
	/**
	 * 设置：平均评价
	 */
	 
	public void setCommentAverage(BigDecimal commentAverage) {
		this.commentAverage = commentAverage;
	}
	
	/**
	 * 获取：平均评价
	 */
	public BigDecimal getCommentAverage() {
		return commentAverage;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setFavoriteNumber(Long favoriteNumber) {
		this.favoriteNumber = favoriteNumber;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Long getFavoriteNumber() {
		return favoriteNumber;
	}
				
	
	/**
	 * 设置：提问数
	 */
	 
	public void setQuestionNumber(Long questionNumber) {
		this.questionNumber = questionNumber;
	}
	
	/**
	 * 获取：提问数
	 */
	public Long getQuestionNumber() {
		return questionNumber;
	}
			
}
