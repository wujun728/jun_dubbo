/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package com.company.project.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.*;

import cn.org.rapid_framework.beanutils.BeanUtils;

import com.company.project.web.form.*;

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


public class BlogAction extends BaseStrutsAction {
	
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final ActionForward QUERY_FORWARD = new ActionForward("/pages/Blog/query.jsp");
	protected static final ActionForward LIST_FORWARD = new ActionForward("/pages/Blog/list.jsp");
	protected static final ActionForward CREATE_FORWARD = new ActionForward("/pages/Blog/create.jsp");
	protected static final ActionForward EDIT_FORWARD = new ActionForward("/pages/Blog/edit.jsp");
	protected static final ActionForward SHOW_FORWARD = new ActionForward("/pages/Blog/show.jsp");
	protected static final ActionForward LIST_ACTION_FORWARD = new ActionForward("/pages/Blog/list.do",true);
	
	private BlogManager blogManager;
	
	/** 
	 * 通过spring自动注入
	 **/
	public void setBlogManager(BlogManager manager) {
		this.blogManager = manager;
	}
	
	/** 
	 * 进入查询页面
	 **/
	public ActionForward query(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		return QUERY_FORWARD;
	}
	
	/** 
	 * 执行搜索 
	 **/
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			  HttpServletResponse response) {
		PageRequest<Map> pageRequest = newPageRequest(request,DEFAULT_SORT_COLUMNS);
		Blog blog = copyProperties(Blog.class,form);
		pageRequest.getFilters().putAll(BeanUtils.describe(blog)); //add custom filters
		
		Page page = this.blogManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest,request);
		return LIST_FORWARD;
	}
	
	/** 
	 * 查看对象
	 **/
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request,
							  HttpServletResponse response) {
		java.lang.Long id = new java.lang.Long(request.getParameter("id"));
		Blog blog = (Blog)blogManager.getById(id);
		copyProperties(form,blog);
		return SHOW_FORWARD;
	}
	
	/** 
	 * 进入新增页面
	 **/
	public ActionForward create(ActionMapping mapping, ActionForm form, HttpServletRequest request,
								HttpServletResponse response) {
		return CREATE_FORWARD;
	}
	
	/** 
	 * 保存新增对象
	 **/
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
								HttpServletResponse response) {
		Blog blog = new Blog();
		copyProperties(blog,form);
		blogManager.save(blog);
		saveDirectMessage(request, MSG_SAVED_SUCCESS);
		return LIST_ACTION_FORWARD;
	}
	
	/**
	 * 进入更新页面
	 **/
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		java.lang.Long id = new java.lang.Long(request.getParameter("id"));
		Blog blog = (Blog)blogManager.getById(id);
		copyProperties(form,blog);
		return EDIT_FORWARD;
	}
	
	/**
	 * 保存更新对象
	 **/
	public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		java.lang.Long id = new java.lang.Long(request.getParameter("id"));
		Blog blog = (Blog)blogManager.getById(id);
		copyProperties(blog,form);
		blogManager.update(blog);
		saveDirectMessage(request, MSG_SAVED_SUCCESS);
		return LIST_ACTION_FORWARD;
	}
	
	/**
	 *删除对象
	 **/
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String[] items = request.getParameterValues("items");
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			
			java.lang.Long id = new java.lang.Long((String)params.get("id"));
			
			blogManager.removeById(id);
		}
		saveDirectMessage(request, MSG_DELETE_SUCCESS);
		return LIST_ACTION_FORWARD;
	}
	
}

