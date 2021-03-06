<%@page import="${basepackage}.${subpackage}.model.*" %>
<#include "macro.include"/> 
<#include "custom.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<html:base/>
	<title><%=${className}.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<html:form action="${strutsActionBasePath}/edit.do" method="post">
	<input type="submit" value="编辑"/>
	<input type="button" value="返回列表" onclick="window.location='<@jspEl 'ctx'/>${strutsActionBasePath}/list.do'"/>

<#list table.columns as column>
<#if column.pk>
	<html:hidden styleId="${column.columnNameLower}" property="${column.columnNameLower}" name="${className}Form"/>
</#if>
</#list>

	<table class="formTable">
	<#list table.columns as column>
	<#if !column.htmlHidden>
		<tr>	
			<th><%=${className}.ALIAS_${column.sqlName?upper_case}%>&nbsp;</th>	
			<td><#rt>
			<#compress>
			<#if column.isDateTimeColumn>
			<c:out value='<@jspEl className+"Form."+column.columnNameLower+"String"/>'/>
			<#else>
			<c:out value='<@jspEl className+"Form."+column.columnNameLower/>'/>
			</#if>
			</#compress>
			<#lt></td>
		</tr>
	</#if>
	</#list>
	</table>
</html:form>

</body>

</html>