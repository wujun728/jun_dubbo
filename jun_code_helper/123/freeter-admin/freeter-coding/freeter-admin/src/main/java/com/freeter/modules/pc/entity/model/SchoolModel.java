package com.freeter.modules.pc.entity.model;

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
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 12:40:06
 */
@ApiModel(value = "SchoolModel")
public class SchoolModel  implements Serializable {
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
