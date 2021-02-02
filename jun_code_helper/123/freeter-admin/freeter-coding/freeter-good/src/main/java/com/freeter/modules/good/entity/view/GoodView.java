package com.freeter.modules.good.entity.view;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.good.entity.GoodEntity;

import io.swagger.annotations.ApiModel;
 

/**
 * 商品表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-31 09:01:38
 */
@TableName("cn_good")
@ApiModel(value = "Good")
public class GoodView  extends GoodEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoodView(){
	}
 
 	public GoodView(GoodEntity goodEntity){
 	try {
			BeanUtils.copyProperties(this, goodEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
 	
 	private Long oneCategoryId;
 	
 	private Long channelId;
 	
 	private Long categoryId;

 	private List<String> images;
 	
 	private String categoryName;
 	
 	private String categoryParentName;
 	
 	private String channelName;
 	
 	private Long attributeId;
 	
 	private Long salesVolume;
 	
 	private Long stock;
 	
 	private Long pageViews;
 	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getOneCategoryId() {
		return oneCategoryId;
	}

	public void setOneCategoryId(Long oneCategoryId) {
		this.oneCategoryId = oneCategoryId;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public String getCategoryParentName() {
		return categoryParentName;
	}

	public void setCategoryParentName(String categoryParentName) {
		this.categoryParentName = categoryParentName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public Long getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(Long salesVolume) {
		this.salesVolume = salesVolume;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Long getPageViews() {
		return pageViews;
	}

	public void setPageViews(Long pageViews) {
		this.pageViews = pageViews;
	}

	public Long getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Long attributeId) {
		this.attributeId = attributeId;
	}
 	
 	
}
