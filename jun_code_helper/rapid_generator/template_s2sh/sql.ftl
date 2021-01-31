<#list ls as tb>
create table ${tb.table}{
<#list tb.columnList as column>
		${column.name}   ${column.sqlTypeName}<#if (column.sqlTypeName!="date")&&(column.sqlTypeName!="timestamp")&&(column.sqlTypeName!="int")&&(column.sqlTypeName!="datetime")>(${column.sqlColumnLength})</#if>  ${column.sqlNotNull?string("not null","null")}  <#if column.defalutValue?exists>${column.defalutValue}</#if> <#if column.name=tb.pk.name>auto_increment</#if> 
</#list>
		primary key(${tb.pk.name})
}
TYPE=MyISAM,
default character set gb2312;

</#list>


