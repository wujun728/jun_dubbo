<#list columnlist as column>
<#if column!=pk>
${table?replace("_","")?lower_case}.${column.name}=${column.name} can not be null
</#if>
</#list>