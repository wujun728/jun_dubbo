<#assign className=tableName?lower_case?cap_first?replace("_","")/>
<#assign reference=tableName?lower_case?replace("_","")/>
<#assign pkName=pk.name?lower_case?cap_first?replace("_","")/>
package com.hyj.dao;

public interface I${className}Dao extends IDao {

}

