package com.freeter.modules.pc.entity.vo;

import com.freeter.modules.pc.entity.SchoolEntity;

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
 * @date 2018-06-20 12:40:06
 */
@ApiModel(value = "SchoolVO")
public class SchoolVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 排序
	 */
	
	@ApiModelProperty(value = "排序") 
	private String schoolName;
			
	/**
	 * 备注
	 */
	
	@ApiModelProperty(value = "备注") 
	private String remark;
				
	
	/**
	 * 设置：排序
	 */
	 
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	/**
	 * 获取：排序
	 */
	public String getSchoolName() {
		return schoolName;
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
