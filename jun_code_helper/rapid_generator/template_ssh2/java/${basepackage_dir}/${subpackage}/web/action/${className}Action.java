<#include "custom.include">
<#include "java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.${subpackage}.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.*;

import ${basepackage}.${subpackage}.web.form.*;

<#include "java_imports.include">

public class ${className}Action extends BaseAction {
	
	//默认排序列
	protected static final String DEFAULT_SORT_COLUMN = null; 
	//默认排序方向,asc或是desc
	protected static final String DEFAULT_SORT_DIRECTION = null; 
	
	//forward paths
	protected static final ActionForward QUERY_FORWARD = new ActionForward("${jspFileBasePath}/query.jsp");
	protected static final ActionForward LIST_FORWARD = new ActionForward("${jspFileBasePath}/list.jsp");
	protected static final ActionForward CREATE_FORWARD = new ActionForward("${jspFileBasePath}/create.jsp");
	protected static final ActionForward EDIT_FORWARD = new ActionForward("${jspFileBasePath}/edit.jsp");
	protected static final ActionForward SHOW_FORWARD = new ActionForward("${jspFileBasePath}/show.jsp");
	protected static final ActionForward LIST_ACTION_FORWARD = new ActionForward("${strutsActionBasePath}/list.do",true);
	
	private ${className}Manager ${classNameLower}Manager;
	
	/** 
	 * 通过spring自动注入
	 **/
	public void set${className}Manager(${className}Manager manager) {
		this.${classNameLower}Manager = manager;
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
		PageInfo pageInfo = newPageInfo(request,DEFAULT_SORT_COLUMN,DEFAULT_SORT_DIRECTION);
		Page page = this.${classNameLower}Manager.findByPageInfo(pageInfo);
		savePage(page,request);
		return LIST_FORWARD;
	}
	
	/** 
	 * 查看对象
	 **/
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request,
							  HttpServletResponse response) {
		<@generateIdParameter/>
		${className} ${classNameLower} = (${className})${classNameLower}Manager.getById(id);
		copyProperties(form,${classNameLower});
		<#if table.compositeId>
		copyProperties(form,${classNameLower}.getId());
		</#if>
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
		<#if table.compositeId>
		${className}Id id = (TbookId)copyProperties(${className}Id.class,form);
		${className} ${classNameLower} = new ${className}(id);
		<#else>
		${className} ${classNameLower} = new ${className}();
		</#if>
		copyProperties(${classNameLower},form);
		${classNameLower}Manager.save(${classNameLower});
		saveDirectMessage(request, MSG_SAVED_SUCCESS);
		return LIST_ACTION_FORWARD;
	}
	
	/**
	 * 进入更新页面
	 **/
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		<@generateIdParameter/>
		${className} ${classNameLower} = (${className})${classNameLower}Manager.getById(id);
		copyProperties(form,${classNameLower});
		<#if table.compositeId>
		copyProperties(form,${classNameLower}.getId());
		</#if>
		return EDIT_FORWARD;
	}
	
	/**
	 * 保存更新对象
	 **/
	public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		<@generateIdParameter/>
		${className} ${classNameLower} = (${className})${classNameLower}Manager.getById(id);
		copyProperties(${classNameLower},form);
		${classNameLower}Manager.update(${classNameLower});
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
			
			<#if table.compositeId>
			${className}Id id = (${className}Id)copyProperties(${className}Id.class,params);
			<#else>
				<#list table.compositeIdColumns as column>
			${column.javaType} id = new ${column.javaType}((String)params.get("${column.columnNameLower}"));
				</#list>
			</#if>
			
			${classNameLower}Manager.removeById(id);
		}
		saveDirectMessage(request, MSG_DELETE_SUCCESS);
		return LIST_ACTION_FORWARD;
	}
	
}

<#macro generateIdParameter>
	<#if table.compositeId>
		${className}Id id = (${className}Id)copyProperties(${className}Id.class,form);
	<#else>
		<#list table.compositeIdColumns as column>
		${column.javaType} id = new ${column.javaType}(request.getParameter("${column.columnNameLower}"));
		</#list>
	</#if>
</#macro>