<#assign className=table?lower_case?cap_first?replace("_","")/>
<#assign reference=table?lower_case?replace("_","")/>
<#assign pkName=pk.name?lower_case?cap_first?replace("_","")/>
package com.hyj.action;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.hyj.dao.PageBean;
import com.hyj.dao.jdbc.${className}Dao;
import com.hyj.model.${className};
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.opensymphony.xwork.ModelDriven;

public class ${className}Action extends ActionSupport implements ModelDriven{
	Logger logger = LogManager.getLogger(this.getClass());
	List ${reference}List;
	private ${className}Dao ${reference}Dao;
	private ${className} ${reference} = new ${className}();
	private PageBean pageBean;
	private String id;
	private String action;
	public String execute() {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from ${table}");
		if(pageBean==null){
			pageBean= new PageBean();
		}
		int count = ${reference}Dao.getCountFromSql(sb.toString());
		System.out.println(count);
		pageBean.setFormName(ActionContext.getContext().getActionInvocation().getProxy().getActionName());
		pageBean.setTotalNumber(count);
		pageBean.execute();		
		sb.append(" limit "+pageBean.getStartRow()+","+pageBean.getPageSize());		
		logger.info(sb.toString());					
		List ${className}list = ${reference}Dao.getList(sb.toString());	
		pageBean.setElements(${className}list);
		return SUCCESS;
	}

	public String input() {
		this.action="insert";
		return INPUT;
	}

	public String insert() {
		${reference}Dao.insert(${reference});
		return execute();
	}

	public String update() {
		${reference}Dao.update(${reference});
		return execute();
	}

	public String modify() {
		${className} tc =(${className})${reference}Dao.findByPrimaryKey(new Long(id));
		BeanUtils.copyProperties(tc,${reference});
		this.action="update";
		return "input";
	}

	public String delete() {
		${reference}Dao.delete(id);
		return execute();
	}

	public ${className}Dao get${className}Dao() {
		return ${reference}Dao;
	}

	public void set${className}Dao(${className}Dao ${reference}Dao) {
		this.${reference}Dao = ${reference}Dao;
	}

	public List get${className}List() {
		return ${reference}List;
	}

	public void set${className}List(List ${reference}List) {
		this.${reference}List = ${reference}List;
	}

	public ${className} get${className}() {
		return ${reference};
	}

	public void set${className}(${className} ${reference}) {
		this.${reference} = ${reference};
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action=action;
	}
	public PageBean getPageBean(){
		return pageBean;
	}
	public void setPageBean(PageBean pageBean ){
		this.pageBean = pageBean;
	}
	public Object getModel() {
		return ${reference};
	}

	
}
