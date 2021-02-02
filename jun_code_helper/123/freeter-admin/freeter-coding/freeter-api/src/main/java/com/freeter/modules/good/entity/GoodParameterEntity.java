package com.freeter.modules.good.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freeter.modules.good.entity.view.GoodParameterView;

import java.lang.reflect.InvocationTargetException;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;



/**
 * 商品参数表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
@TableName("cn_good_parameter")
@ApiModel(value = "GoodParameter")
public class GoodParameterEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GoodParameterEntity() {
		
	}
	
	public GoodParameterEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 参数ID
	 */
	
	@TableId 				 
	@ApiModelProperty(value = "参数ID",hidden = true)
	private Long goodParameterId;
	
	/**
	 * 商品ID
	 */
					 
	@ApiModelProperty(value = "商品ID")
	private Long goodId;
	
	/**
	 * 参数名
	 */
					 
	@ApiModelProperty(value = "参数名")
	private String name;
	
	/**
	 * 参数值
	 */
					 
	@ApiModelProperty(value = "参数值")
	private String value;
	
	/**
	 * 状态：1.显示；0.隐藏
	 */
					 
	@ApiModelProperty(value = "状态：1.显示；0.隐藏")
	private Integer status;
	
	/**
	 * 排序
	 */
					 
	@ApiModelProperty(value = "排序")
	private Integer sort;
	
	/**
	 * 创建时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 	 
	@ApiModelProperty(value = "创建时间",hidden = true)
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
	private Date updateTime;
	
	/**
	 * 更新者
	 */
					 
	@ApiModelProperty(value = "更新者",hidden = true)
	private String updateBy;
	
	/**
	 * 设置：参数ID
	 */
	public void setGoodParameterId(Long goodParameterId) {
		this.goodParameterId = goodParameterId;
	}
	/**
	 * 获取：参数ID
	 */
	public Long getGoodParameterId() {
		return goodParameterId;
	}
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
	 * 设置：参数名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：参数名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：参数值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：参数值
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 设置：状态：1.显示；0.隐藏
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态：1.显示；0.隐藏
	 */
	public Integer getStatus() {
		return status;
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
}
