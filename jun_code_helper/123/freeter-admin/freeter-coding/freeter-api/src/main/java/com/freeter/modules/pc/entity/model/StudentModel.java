package com.freeter.modules.pc.entity.model;

import com.freeter.modules.pc.entity.StudentEntity;

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
 * @date 2018-06-20 14:56:33
 */
@ApiModel(value = "StudentModel")
public class StudentModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 性别（1：男，0：女）
	 */
	
	@ApiModelProperty(value = "性别（1：男，0：女）") 
	private Integer sex;
		
	/**
	 * 姓名
	 */
	
	@ApiModelProperty(value = "姓名") 
	private String studentName;
		
	/**
	 * 身份证
	 */
	
	@ApiModelProperty(value = "身份证") 
	private String idCart;
		
	/**
	 * 学号
	 */
	
	@ApiModelProperty(value = "学号") 
	private String studentNo;
		
	/**
	 * 学校id
	 */
	
	@ApiModelProperty(value = "学校id") 
	private Long schoolId;
		
	/**
	 * 专业id
	 */
	
	@ApiModelProperty(value = "专业id") 
	private Long professionalId;
				
	/**
	 * 会员标识(1:会员 0：普通)
	 */
	
	@ApiModelProperty(value = "会员标识(1:会员 0：普通)") 
	private Integer member;
		
	/**
	 * 备注
	 */
	
	@ApiModelProperty(value = "备注") 
	private String remark;
				
	
	/**
	 * 设置：性别（1：男，0：女）
	 */
	 
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	/**
	 * 获取：性别（1：男，0：女）
	 */
	public Integer getSex() {
		return sex;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getStudentName() {
		return studentName;
	}
				
	
	/**
	 * 设置：身份证
	 */
	 
	public void setIdCart(String idCart) {
		this.idCart = idCart;
	}
	
	/**
	 * 获取：身份证
	 */
	public String getIdCart() {
		return idCart;
	}
				
	
	/**
	 * 设置：学号
	 */
	 
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	
	/**
	 * 获取：学号
	 */
	public String getStudentNo() {
		return studentNo;
	}
				
	
	/**
	 * 设置：学校id
	 */
	 
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	
	/**
	 * 获取：学校id
	 */
	public Long getSchoolId() {
		return schoolId;
	}
				
	
	/**
	 * 设置：专业id
	 */
	 
	public void setProfessionalId(Long professionalId) {
		this.professionalId = professionalId;
	}
	
	/**
	 * 获取：专业id
	 */
	public Long getProfessionalId() {
		return professionalId;
	}
								
	
	/**
	 * 设置：会员标识(1:会员 0：普通)
	 */
	 
	public void setMember(Integer member) {
		this.member = member;
	}
	
	/**
	 * 获取：会员标识(1:会员 0：普通)
	 */
	public Integer getMember() {
		return member;
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
