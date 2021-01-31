/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package com.company.project.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.company.project.model.*;
import com.company.project.dao.*;
import com.company.project.service.*;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


@Entity
@Table(name = "blog")
public class Blog extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "Blog";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USERNAME = "username";
	public static final String ALIAS_BIRTH_DATE = "birthDate";
	public static final String ALIAS_SEX = "sex";
	public static final String ALIAS_TITLE = "title";
	public static final String ALIAS_LENGTH = "length";
	public static final String ALIAS_CONTENT = "content";
	
	//date formats
	public static final String FORMAT_BIRTH_DATE = DATE_TIME_FORMAT;
	

	//columns START
	private java.lang.Long id;
	private java.lang.String username;
	private java.sql.Timestamp birthDate;
	private java.lang.String sex;
	private java.lang.String title;
	private java.lang.Integer length;
	private java.lang.String content;
	//columns END


	public Blog(){
	}

	public Blog(
		java.lang.Long id
	){
		this.id = id;
	}

	

	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	@Id @GeneratedValue(generator="custom-id")
	@GenericGenerator(name="custom-id", strategy = "increment")
	@Column(name = "id", unique = true, nullable = false, insertable = true, updatable = true, length = 32)
	public java.lang.Long getId() {
		return this.id;
	}
	
	@Column(name = "username", unique = true, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getUsername() {
		return this.username;
	}
	
	public void setUsername(java.lang.String value) {
		this.username = value;
	}
	
	@Transient
	public String getBirthDateString() {
		return date2String(getBirthDate(), FORMAT_BIRTH_DATE);
	}
	public void setBirthDateString(String value) {
		setBirthDate(string2Date(value, FORMAT_BIRTH_DATE,java.sql.Timestamp.class));
	}
	
	@Column(name = "birth_date", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
	public java.sql.Timestamp getBirthDate() {
		return this.birthDate;
	}
	
	public void setBirthDate(java.sql.Timestamp value) {
		this.birthDate = value;
	}
	
	@Column(name = "sex", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.String getSex() {
		return this.sex;
	}
	
	public void setSex(java.lang.String value) {
		this.sex = value;
	}
	
	@Column(name = "title", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.String getTitle() {
		return this.title;
	}
	
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
	
	@Column(name = "length", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	public java.lang.Integer getLength() {
		return this.length;
	}
	
	public void setLength(java.lang.Integer value) {
		this.length = value;
	}
	
	@Column(name = "content", unique = false, nullable = true, insertable = true, updatable = true, length = 56)
	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	

	public String toString() {
		return new ToStringBuilder(this)
			.append("Id",getId())
			.append("Username",getUsername())
			.append("BirthDate",getBirthDate())
			.append("Sex",getSex())
			.append("Title",getTitle())
			.append("Length",getLength())
			.append("Content",getContent())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getUsername())
			.append(getBirthDate())
			.append(getSex())
			.append(getTitle())
			.append(getLength())
			.append(getContent())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Blog == false) return false;
		if(this == obj) return true;
		Blog other = (Blog)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getUsername(),other.getUsername())
			.append(getBirthDate(),other.getBirthDate())
			.append(getSex(),other.getSex())
			.append(getTitle(),other.getTitle())
			.append(getLength(),other.getLength())
			.append(getContent(),other.getContent())
			.isEquals();
	}
}

