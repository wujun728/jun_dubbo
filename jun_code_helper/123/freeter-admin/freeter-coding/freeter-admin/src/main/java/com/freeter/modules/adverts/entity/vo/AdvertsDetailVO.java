package com.freeter.modules.adverts.entity.vo;

import com.freeter.modules.adverts.entity.AdvertsDetailEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 广告位详情
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 12:36:59
 */
@ApiModel(value = "AdvertsDetailVO")
public class AdvertsDetailVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 广告位置
	 */
	
	@ApiModelProperty(value = "广告位置") 
	private String name;
		
	/**
	 * 广告位ID
	 */
	
	@ApiModelProperty(value = "广告位ID") 
	private Long advertsId;
		
	/**
	 * 标题
	 */
	
	@ApiModelProperty(value = "标题") 
	private String title;
			
	/**
	 * 链接地址
	 */
	
	@ApiModelProperty(value = "链接地址") 
	private String href;
		
	/**
	 * 类型(0:图文，1：图片，2：视频）
	 */
	
	@ApiModelProperty(value = "类型(0:图文，1：图片，2：视频）") 
	private Integer type;
		
	/**
	 * 状态 0=显示/1=隐藏
	 */
	
	@ApiModelProperty(value = "状态 0=显示/1=隐藏") 
	private Integer status;
		
	/**
	 * 展示图片
	 */
	
	@ApiModelProperty(value = "展示图片") 
	private String picImg;
						
	/**
	 * 备注信息
	 */
	
	@ApiModelProperty(value = "备注信息") 
	private String remarks;
		
	/**
	 * 广告起始时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "广告起始时间") 
	private Date beginTime;
		
	/**
	 * 广告结束时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "广告结束时间") 
	private Date endTime;
		
	/**
	 * 广告内容
	 */
	
	@ApiModelProperty(value = "广告内容") 
	private String content;
				
	
	/**
	 * 设置：广告位置
	 */
	 
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取：广告位置
	 */
	public String getName() {
		return name;
	}
				
	
	/**
	 * 设置：广告位ID
	 */
	 
	public void setAdvertsId(Long advertsId) {
		this.advertsId = advertsId;
	}
	
	/**
	 * 获取：广告位ID
	 */
	public Long getAdvertsId() {
		return advertsId;
	}
				
	
	/**
	 * 设置：标题
	 */
	 
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
						
	
	/**
	 * 设置：链接地址
	 */
	 
	public void setHref(String href) {
		this.href = href;
	}
	
	/**
	 * 获取：链接地址
	 */
	public String getHref() {
		return href;
	}
				
	
	/**
	 * 设置：类型(0:图文，1：图片，2：视频）
	 */
	 
	public void setType(Integer type) {
		this.type = type;
	}
	
	/**
	 * 获取：类型(0:图文，1：图片，2：视频）
	 */
	public Integer getType() {
		return type;
	}
				
	
	/**
	 * 设置：状态 0=显示/1=隐藏
	 */
	 
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * 获取：状态 0=显示/1=隐藏
	 */
	public Integer getStatus() {
		return status;
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
	 * 设置：广告起始时间
	 */
	 
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	/**
	 * 获取：广告起始时间
	 */
	public Date getBeginTime() {
		return beginTime;
	}
				
	
	/**
	 * 设置：广告结束时间
	 */
	 
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * 获取：广告结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}
				
	
	/**
	 * 设置：广告内容
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取：广告内容
	 */
	public String getContent() {
		return content;
	}
			
}
