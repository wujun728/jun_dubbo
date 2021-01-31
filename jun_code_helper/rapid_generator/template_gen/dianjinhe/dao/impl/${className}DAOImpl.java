<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao.impl;

import com.dianjinhe.core.dao.GenericIbatisDAO;
import org.springframework.stereotype.Repository;
import ${basepackage}.dto.${className}DTO;
import ${basepackage}.dao.${className}DAO;

<#include "/java_imports.include">

<#macro namespace>.${className}</#macro>
@Repository("djh_${"${className}DAO"?uncap_first}")
public class ${className}DAOImpl  extends GenericIbatisDAO<${className}DTO, Long> implements ${className}DAO{
	
	public ${className}DAOImpl(){
		setSqlmapNamespace("${className}");
	}
	
	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public ${className} getBy${column.columnName}(${column.javaType} v) {
		return (${className})getSqlMapClientTemplate().queryForObject("${className}.getBy${column.columnName}",v);
	}	
	
	</#if>
	</#list>

}
