<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dianjinhe.core.service.GenericService;

import ${basepackage}.dto.${className}DTO;
import ${basepackage}.dao.${className}DAO;
import ${basepackage}.service.${className}Service;

<#include "/java_imports.include">

@Service("djh_${"${className}Service"?uncap_first}")
public class ${className}ServiceImpl extends GenericService<${className}DTO, Long> implements ${className}Service{
	
	@Autowired
	private ${className}DAO dao;
	
	@Autowired
	public void setGenericDAO(${className}DAO dao){
		setDAO(dao);
	}
	
	
	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public ${className} getBy${column.columnName}(${column.javaType} v) {
		return (${className})getSqlMapClientTemplate().queryForObject("${className}.getBy${column.columnName}",v);
	}	
	
	</#if>
	</#list>

}
