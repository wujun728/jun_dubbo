/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package com.company.project.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javacommon.util.extjs.ExtJsPageHelper;
import javacommon.util.extjs.ListRange;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import cn.org.rapid_framework.generator.provider.java.model.JavaClass;
import cn.org.rapid_framework.generator.provider.java.model.JavaField;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.company.project.model.Blog;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;
import static javacommon.util.extjs.Struts2JsonHelper.*;

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


public class BlogAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/Blog/query.jsp";
	protected static final String LIST_JSP= "/pages/Blog/list.jsp";
	protected static final String CREATE_JSP = "/pages/Blog/create.jsp";
	protected static final String EDIT_JSP = "/pages/Blog/edit.jsp";
	protected static final String SHOW_JSP = "/pages/Blog/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/Blog/list.do";
	
	private BlogManager blogManager;
	
	private Blog blog;
	java.lang.Long id = null;
	private String[] items;

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			blog = new Blog();
		} else {
			blog = (Blog)blogManager.getById(id);
		}
	}
	
	/** 通过spring自动注入 */
	public void setBlogManager(BlogManager manager) {
		this.blogManager = manager;
	}	
	
	public Object getModel() {
		return blog;
	}
	
	public void setId(java.lang.Long val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}



	/**
	 * ExtGrid使用
	 * 列表
	 * @throws IOException
	 */
	public void extlist() throws IOException
	{
		PageRequest<Map> pr = ExtJsPageHelper.createPageRequestForExtJs(getRequest(), DEFAULT_SORT_COLUMNS);
		Page page = blogManager.findByPageRequest(pr);
		
		List<Blog> Bloglist = (List) page.getResult();
		ListRange<Blog> resultList = new ListRange<Blog>();
		resultList.setList(Bloglist);
		resultList.setTotalSize(page.getTotalCount());
		resultList.setMessage("ok");
		resultList.setSuccess(true);
		outJson(resultList);
	}

	/**
	 * extGrid保存
	 * @throws IOException
	 */
	public void extsave() throws IOException
	{
		Map<String, Object> result = new HashMap<String, Object>();
		try
		{
			blogManager.save(blog);
			result.put("success", true);
			result.put("msg", "添 加 成 功!");
		}
		catch (Exception e)
		{
			result.put("failure", true);
			result.put("msg", e.getMessage());
			e.printStackTrace();
		}
		outJson(result);
	}
	
	/**
	 * extGrid修改
	 * @throws IOException
	 */
	public void extupdate() throws IOException
	{
		Map<String, Object> result = new HashMap<String, Object>();
		try
		{
			blogManager.save(blog);
			result.put("success", true);
			result.put("msg", "修 改 成 功!");
		}
		catch (Exception e)
		{
			result.put("failure", true);
			result.put("msg", e.getMessage());
			e.printStackTrace();
		}
		outJson(result);
	}
	
	/**
	 * extGrid删除
	 * @throws IOException
	 */
	public void extdelete() throws IOException
	{
		String ids = getRequest().getParameter("ids");
		String[] idarray = ids.split(",");
		Map<String, Object> result = new HashMap<String, Object>();
		try
		{
			for (int i = 0; i < idarray.length; i++)
			{
				java.lang.Long id = new java.lang.Long((String)idarray[i]);
				blogManager.removeById(id);
			}
			result.put("success", true);
			result.put("msg", "删除成功");
		}
		catch (Exception e)
		{
			result.put("failure", true);
			result.put("msg", e.getMessage());
			e.printStackTrace();
		}
		outJson(result);
	}
	
}
