package com.freeter.modules.pc.entity.vo;

import com.freeter.modules.pc.entity.PcEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 15:47:02
 */
@ApiModel(value = "PcVO")
public class PcVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 电脑名称
	 */
	
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
							
}
