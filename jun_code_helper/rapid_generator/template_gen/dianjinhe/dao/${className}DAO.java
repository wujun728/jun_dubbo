<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

import com.dianjinhe.core.dao.IGenericDAO;
import ${basepackage}.dto.${className}DTO;

<#include "/java_imports.include">

public interface ${className}DAO  extends IGenericDAO<${className}DTO, Long>{
	
	
	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public ${className} getBy${column.columnName}(${column.javaType} v);
	
	</#if>
	</#list>
}
