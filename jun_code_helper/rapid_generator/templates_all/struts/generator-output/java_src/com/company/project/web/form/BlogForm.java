/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package com.company.project.web.form;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.*;

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


public class BlogForm extends BaseStrutsForm {

	private String id;
	private String username;
	private String birthDateString;
	private String sex;
	private String title;
	private String length;
	private String content;
	


	public void setId(String value) {
		this.id = value;
	}
	public String getId() {
		return this.id;
	}	


	public void setUsername(String value) {
		this.username = value;
	}
	public String getUsername() {
		return this.username;
	}	


	public void setBirthDateString(String value) {
		this.birthDateString = value;
	}
	public String getBirthDateString() {
		return this.birthDateString;
	}


	public void setSex(String value) {
		this.sex = value;
	}
	public String getSex() {
		return this.sex;
	}	


	public void setTitle(String value) {
		this.title = value;
	}
	public String getTitle() {
		return this.title;
	}	


	public void setLength(String value) {
		this.length = value;
	}
	public String getLength() {
		return this.length;
	}	


	public void setContent(String value) {
		this.content = value;
	}
	public String getContent() {
		return this.content;
	}	

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	public boolean equals(Object other) {
		return EqualsBuilder.reflectionEquals(this, other);
	}
}