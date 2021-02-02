package com.freeter.modules.category.entity;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 分类表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-22 15:46:31
 */
@TableName("cn_category")
@ApiModel(value = "Category")
public class CategoryEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CategoryEntity() {
		
	}
	
	public CategoryEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 分类ID
	 */
	
	@TableId 				 
	@ApiModelProperty(value = "分类ID",hidden = true)
	private Long categoryId;
	
	/**
	 * 父分类ID
	 */
					 
	@ApiModelProperty(value = "父分类ID")
	private Long parentId;
	
	/**
	 * 分类名称
	 */
					 
	@ApiModelProperty(value = "分类名称")
	private String name;
	
	/**
	 * 排序
	 */
					 
	@ApiModelProperty(value = "排序")
	private Integer sort;
	
	/**
	 * 目录类型 2=二级目录/1=一级目录/0=总目录
	 */
					 
	@ApiModelProperty(value = "目录类型 2=二级目录/1=一级目录/0=总目录")
	private Integer type;
	
	/**
	 * 状态 1=显示/0=隐藏
	 */
					 
	@ApiModelProperty(value = "状态 1=显示/0=隐藏")
	private Integer status;
	
	/**
	 * 是否导航栏 1=显示/0=隐藏
	 */
					 
	@ApiModelProperty(value = "是否导航栏 1=显示/0=隐藏")
	private Integer showInNav;
	
	/**
	 * 是否置顶 1=置顶/0=默认
	 */
					 
	@ApiModelProperty(value = "是否置顶 1=置顶/0=默认")
	private Integer showInTop;
	
	/**
	 * 是否热门 1=热门/0=默认
	 */
					 
	@ApiModelProperty(value = "是否热门 1=热门/0=默认")
	private Integer showInHot;
	
	/**
	 * 创建时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 	 
	@ApiModelProperty(value = "创建时间",hidden = true)
	@JsonIgnore
	private Date createTime;
	
	/**
	 * 创建者
	 */
					 
	@ApiModelProperty(value = "创建者",hidden = true)
	private String createBy;
	
	/**
	 * 更新时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 	 
	@ApiModelProperty(value = "更新时间",hidden = true)
	@JsonIgnore
	private Date updateTime;
	
	/**
	 * 更新者
	 */
	@JsonIgnore
	@ApiModelProperty(value = "更新者",hidden = true)
	private String updateBy;
	
	/**
	 * 页面标题
	 */
					 
	@ApiModelProperty(value = "页面标题")
	private String pageTitle;
	
	/**
	 * 页面描述
	 */
					 
	@ApiModelProperty(value = "页面描述")
	private String pageDescription;
	
	/**
	 * 页面关键词
	 */
					 
	@ApiModelProperty(value = "页面关键词")
	private String pageKeyword;
	
	/**
	 * 备注信息
	 */
					 
	@ApiModelProperty(value = "备注信息")
	private String remarks;
	
	/**
	 * 设置：分类ID
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * 获取：分类ID
	 */
	public Long getCategoryId() {
		return categoryId;
	}
	/**
	 * 设置：父分类ID
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父分类ID
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：分类名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：分类名称
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
	/**
	 * 设置：目录类型 2=二级目录/1=一级目录/0=总目录
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：目录类型 2=二级目录/1=一级目录/0=总目录
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：状态 1=显示/0=隐藏
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 1=显示/0=隐藏
	 */
	public Integer getStatus() {
		return status;
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
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	@JsonIgnore
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：创建者
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建者
	 */
	@JsonIgnore
	public String getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	@JsonIgnore
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：更新者
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：更新者
	 */
	public String getUpdateBy() {
		return updateBy;
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
	 * 设置：页面描述
	 */
	public void setPageDescription(String pageDescription) {
		this.pageDescription = pageDescription;
	}
	/**
	 * 获取：页面描述
	 */
	public String getPageDescription() {
		return pageDescription;
	}
	/**
	 * 设置：页面关键词
	 */
	public void setPageKeyword(String pageKeyword) {
		this.pageKeyword = pageKeyword;
	}
	/**
	 * 获取：页面关键词
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
