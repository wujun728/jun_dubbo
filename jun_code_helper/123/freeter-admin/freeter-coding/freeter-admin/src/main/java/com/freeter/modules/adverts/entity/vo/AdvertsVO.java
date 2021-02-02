package com.freeter.modules.adverts.entity.vo;

import com.freeter.modules.adverts.entity.AdvertsEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 广告位表
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 12:36:59
 */
@ApiModel(value = "AdvertsVO")
public class AdvertsVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 名称
	 */
	
	@ApiModelProperty(value = "名称") 
	private String name;
		
	/**
	 * 宽度
	 */
	
	@ApiModelProperty(value = "宽度") 
	private Integer width;
		
	/**
	 * 高度
	 */
	
	@ApiModelProperty(value = "高度") 
	private Integer height;
		
	/**
	 * 描述
	 */
	
	@ApiModelProperty(value = "描述") 
	private String description;
		
	/**
	 * 模版内容
	 */
	
	@ApiModelProperty(value = "模版内容") 
	private String template;
		
	/**
	 * 默认显示个数
	 */
	
	@ApiModelProperty(value = "默认显示个数") 
	private Integer defultNumber;
		
	/**
	 * 广告数量
	 */
	
	@ApiModelProperty(value = "广告数量") 
	private Integer number;
						
	/**
	 * 启用状态(0:开启，1：关闭)
	 */
	
	@ApiModelProperty(value = "启用状态(0:开启，1：关闭)") 
	private Integer status;
				
	
	/**
	 * 设置：名称
	 */
	 
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
				
	
	/**
	 * 设置：宽度
	 */
	 
	public void setWidth(Integer width) {
		this.width = width;
	}
	
	/**
	 * 获取：宽度
	 */
	public Integer getWidth() {
		return width;
	}
				
	
	/**
	 * 设置：高度
	 */
	 
	public void setHeight(Integer height) {
		this.height = height;
	}
	
	/**
	 * 获取：高度
	 */
	public Integer getHeight() {
		return height;
	}
				
	
	/**
	 * 设置：描述
	 */
	 
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 获取：描述
	 */
	public String getDescription() {
		return description;
	}
				
	
	/**
	 * 设置：模版内容
	 */
	 
	public void setTemplate(String template) {
		this.template = template;
	}
	
	/**
	 * 获取：模版内容
	 */
	public String getTemplate() {
		return template;
	}
				
	
	/**
	 * 设置：默认显示个数
	 */
	 
	public void setDefultNumber(Integer defultNumber) {
		this.defultNumber = defultNumber;
	}
	
	/**
	 * 获取：默认显示个数
	 */
	public Integer getDefultNumber() {
		return defultNumber;
	}
				
	
	/**
	 * 设置：广告数量
	 */
	 
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	/**
	 * 获取：广告数量
	 */
	public Integer getNumber() {
		return number;
	}
												
	
	/**
	 * 设置：启用状态(0:开启，1：关闭)
	 */
	 
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * 获取：启用状态(0:开启，1：关闭)
	 */
	public Integer getStatus() {
		return status;
	}
			
}
