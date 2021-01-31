<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.service;

import com.dianjinhe.core.service.IGenericService;
import ${basepackage}.dto.${className}DTO;

<#include "/java_imports.include">
public interface ${className}Service  extends IGenericService<${className}DTO, Long>{
	

	
	
	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public ${className} getBy${column.columnName}(${column.javaType} v) {
		return (${className})getSqlMapClientTemplate().queryForObject("${className}.getBy${column.columnName}",v);
	}	
	
	</#if>
	</#list>

}
