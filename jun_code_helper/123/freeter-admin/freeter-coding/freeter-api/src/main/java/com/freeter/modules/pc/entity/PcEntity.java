package com.freeter.modules.pc.entity;

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
 * 
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 14:56:33
 */
@TableName("t_pc")
@ApiModel(value = "Pc")
public class PcEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PcEntity() {
		
	}
	
	public PcEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	
	@TableId 					
	@ApiModelProperty(value = "",hidden = true)
	private Long pcId;
	
	/**
	 * 电脑名称
	 */
				
	@NotBlank (message = "电脑名称不能为空") 			
	@ApiModelProperty(value = "电脑名称")
	private String pcName;
	
	/**
	 * 标题
	 */
						
	@ApiModelProperty(value = "标题")
	private String title;
	
	/**
	 * 详情
	 */
						
	@ApiModelProperty(value = "详情")
	private String detail;
	
	/**
	 * 备注
	 */
						
	@ApiModelProperty(value = "备注")
	private String remark;
	
	/**
	 * 创建时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 			
	@TableField(fill = FieldFill.INSERT) 
	@ApiModelProperty(value = "创建时间",hidden = true)
	private Date createTime;
	
	/**
	 * 创建人
	 */
							
	@TableField(fill = FieldFill.INSERT) 
	@ApiModelProperty(value = "创建人",hidden = true)
	private String createBy;
	
	/**
	 * 设置：
	 */
	public void setPcId(Long pcId) {
		this.pcId = pcId;
	}
	/**
	 * 获取：
	 */
	public Long getPcId() {
		return pcId;
	}
	/**
	 * 设置：电脑名称
	 */
	public void setPcName(String pcName) {
		this.pcName = pcName;
	}
	/**
	 * 获取：电脑名称
	 */
	public String getPcName() {
		return pcName;
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
	 * 设置：详情
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * 获取：详情
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
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
	 * 设置：创建人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateBy() {
		return createBy;
	}
}
