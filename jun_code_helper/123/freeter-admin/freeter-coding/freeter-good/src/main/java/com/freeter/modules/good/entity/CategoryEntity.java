package com.freeter.modules.good.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;



/**
 * 分类表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-15 14:33:44
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
	 * 是否推荐（0：不推荐 1：推荐）
	 */
						
	@ApiModelProperty(value = "是否推荐（0：不推荐 1：推荐）")
	private Integer showInCommend;
	
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
	 * 分类小图标
	 */
						
	@ApiModelProperty(value = "分类小图标")
	private String icon;
	
	/**
	 * 创建时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 			
	@TableField(fill = FieldFill.INSERT) 
	@ApiModelProperty(value = "创建时间",hidden = true)
	private Date createTime;
	
	/**
	 * 创建者
	 */
							
	@TableField(fill = FieldFill.INSERT) 
	@ApiModelProperty(value = "创建者",hidden = true)
	private String createBy;
	
	/**
	 * 更新时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@TableField(fill = FieldFill.UPDATE) 	
	@ApiModelProperty(value = "更新时间",hidden = true)
	private Date updateTime;
	
	/**
	 * 更新者
	 */
						
	@TableField(fill = FieldFill.UPDATE) 	
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
	 * 频道id
	 */
						
	@ApiModelProperty(value = "频道id")
	private String channelId;
	
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
	 * 设置：是否推荐（0：不推荐 1：推荐）
	 */
	public void setShowInCommend(Integer showInCommend) {
		this.showInCommend = showInCommend;
	}
	/**
	 * 获取：是否推荐（0：不推荐 1：推荐）
	 */
	public Integer getShowInCommend() {
		return showInCommend;
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
	 * 设置：分类小图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：分类小图标
	 */
	public String getIcon() {
		return icon;
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
	/**
	 * 设置：频道id
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	/**
	 * 获取：频道id
	 */
	public String getChannelId() {
		return channelId;
	}
}
