<#assign className=tableName?lower_case?cap_first?replace("_","")/>
<#assign reference=tableName?lower_case?replace("_","")/>
<#assign pkName=pk.name?lower_case?cap_first?replace("_","")/>
package com.hyj.service;

public interface I${className}Service extends IService {

}
