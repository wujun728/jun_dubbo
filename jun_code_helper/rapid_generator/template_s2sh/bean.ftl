package com.hyj.model;

<#assign table=table[0]?upper_case+table[1..table?length-1]?lower_case?replace("_","")>

public class ${table}{
	<#list columnList as column>
	private ${column.javaType.simpleName} ${column.name?lower_case?replace("_","")};	
	</#list>
	
	public ${table}() {
	}
	<#list columnList as column>
    <#assign method=column.name?lower_case?cap_first?replace("_","")>
    <#assign obj=column.name?lower_case?replace("_","")>
	public ${column.javaType.simpleName} get${method}(){
		return ${obj}; 
	}
	public void set${method}(${column.javaType.simpleName} ${obj}){
		this.${obj}=${obj};
	}
	</#list>
}
