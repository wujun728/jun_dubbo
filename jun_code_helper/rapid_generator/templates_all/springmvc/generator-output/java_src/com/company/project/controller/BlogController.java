/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package com.company.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.rapid_framework.beanutils.BeanUtils;

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


@Controller
public class BlogController extends BaseSpringController{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	private BlogManager blogManager;
	
	private final String LIST_ACTION = "redirect:/pages/Blog/list.do";
	
	public BlogController() {
	}
	
	/** 
	 * 通过spring自动注入
	 **/
	public void setBlogManager(BlogManager manager) {
		this.blogManager = manager;
	}
	
	/** 
	 * 进入查询页面
	 **/
	public ModelAndView query(HttpServletRequest request,HttpServletResponse response) {
		return new ModelAndView("/pages/Blog/query");
	}
	
	/** 
	 * 执行搜索 
	 **/
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,Blog blog) {
		PageRequest<Map> pageRequest = newPageRequest(request,DEFAULT_SORT_COLUMNS);
		pageRequest.getFilters().putAll(BeanUtils.describe(blog)); //add custom filters
		
		Page page = this.blogManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest,request);
		return new ModelAndView("/pages/Blog/list","blog",blog);
	}
	
	/** 
	 * 查看对象
	 **/
	public ModelAndView show(HttpServletRequest request,HttpServletResponse response) throws Exception {
		java.lang.Long id = new java.lang.Long(request.getParameter("id"));
		Blog blog = (Blog)blogManager.getById(id);
		return new ModelAndView("/pages/Blog/show","blog",blog);
	}
	
	/** 
	 * 进入新增页面
	 **/
	public ModelAndView create(HttpServletRequest request,HttpServletResponse response,Blog blog) throws Exception {
		return new ModelAndView("/pages/Blog/create","blog",blog);
	}
	
	/** 
	 * 保存新增对象
	 **/
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,Blog blog) throws Exception {
		blogManager.save(blog);
		return new ModelAndView(LIST_ACTION);
	}
	
	/**
	 * 进入更新页面
	 **/
	public ModelAndView edit(HttpServletRequest request,HttpServletResponse response) throws Exception {
		java.lang.Long id = new java.lang.Long(request.getParameter("id"));
		Blog blog = (Blog)blogManager.getById(id);
		return new ModelAndView("/pages/Blog/edit","blog",blog);
	}
	
	/**
	 * 保存更新对象
	 **/
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response) throws Exception {
		java.lang.Long id = new java.lang.Long(request.getParameter("id"));
		
		Blog blog = (Blog)blogManager.getById(id);
		bind(request,blog);
		blogManager.update(blog);
		return new ModelAndView(LIST_ACTION);
	}
	
	/**
	 *删除对象
	 **/
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response) {
		String[] items = request.getParameterValues("items");
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			
			java.lang.Long id = new java.lang.Long((String)params.get("id"));
			
			blogManager.removeById(id);
		}
		return new ModelAndView(LIST_ACTION);
	}
	
}

