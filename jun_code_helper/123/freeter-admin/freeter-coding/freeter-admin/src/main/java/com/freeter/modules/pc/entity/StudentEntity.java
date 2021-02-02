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
 * @date 2018-06-20 15:47:02
 */
@TableName("t_student")
@ApiModel(value = "Student")
public class StudentEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public StudentEntity() {
		
	}
	
	public StudentEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 学生id
	 */
	
	@TableId 					
	@ApiModelProperty(value = "学生id",hidden = true)
	private Long studentId;
	
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
	 * 设置：学生id
	 */
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	/**
	 * 获取：学生id
	 */
	public Long getStudentId() {
		return studentId;
	}
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
