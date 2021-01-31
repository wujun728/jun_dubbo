<#include "/macro.include"/>
<#include "/java_copyright.include">
package ${basepackage}.dto;

import com.dianjinhe.common.util.DateUtil;
import com.hongma.saa.constants.IConstants;

<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 


import com.dianjinhe.core.dto.BaseDTO;

<#include "/java_imports.include">

public class ${className}DTO extends BaseDTO {
	
	//columns START
	<#list table.columns as column>	
	/** ${column.columnAlias} ${column.hibernateValidatorExprssion}*/	
	private ${column.javaType} ${column.columnNameLower};
	</#list>
	//columns END


<@generateJavaColumns/>
<@generateJavaOneToMany/>
<@generateJavaManyToOne/>

}

<#macro generateJavaColumns>
	<#list table.columns as column>
		<#if column.isDateTimeColumn>
		
	/** ${column.columnAlias}字符格式*/
	public String get${column.columnName}String() {
		return DateUtil.formatDate(get${column.columnName}(), IConstants.DATETIME_DEFAULT_FORMAT);
	}
	
	/** ${column.columnAlias}字符格式*/
	public void set${column.columnName}String(String value) {
		set${column.columnName}(DateUtil.parseDate(value, IConstants.DATETIME_DEFAULT_FORMAT));
	}
	
		</#if>

	/** ${column.columnAlias}*/
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	/** ${column.columnAlias}*/
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	</#list>
</#macro>

<#macro generateJavaOneToMany>
	<#list table.exportedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	private Set ${fkPojoClassVar}s = new HashSet(0);
	public void set${fkPojoClass}s(Set<${fkPojoClass}> ${fkPojoClassVar}){
		this.${fkPojoClassVar}s = ${fkPojoClassVar};
	}
	
	public Set<${fkPojoClass}> get${fkPojoClass}s() {
		return ${fkPojoClassVar}s;
	}
	</#list>
</#macro>

<#macro generateJavaManyToOne>
	<#list table.importedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	private ${fkPojoClass} ${fkPojoClassVar};
	
	public void set${fkPojoClass}(${fkPojoClass} ${fkPojoClassVar}){
		this.${fkPojoClassVar} = ${fkPojoClassVar};
	}
	
	public ${fkPojoClass} get${fkPojoClass}() {
		return ${fkPojoClassVar};
	}
	</#list>
</#macro>
