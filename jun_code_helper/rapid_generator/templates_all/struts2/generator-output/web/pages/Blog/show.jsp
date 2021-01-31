<%@page import="com.company.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Blog.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/Blog/list.do" method="get" theme="simple">
	<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/Blog/list.do'"/>
	<input type="button" value="后退" onclick="history.back();"/>
	
	<s:hidden name="id" id="id" value="%{model.id}"/>

	<table class="formTable">
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_USERNAME%></td>	
			<td><s:property value="%{model.username}" /></td>
		</tr>
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_BIRTH_DATE%></td>	
			<td><s:property value="%{model.birthDateString}" /></td>
		</tr>
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_SEX%></td>	
			<td><s:property value="%{model.sex}" /></td>
		</tr>
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_TITLE%></td>	
			<td><s:property value="%{model.title}" /></td>
		</tr>
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_LENGTH%></td>	
			<td><s:property value="%{model.length}" /></td>
		</tr>
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_CONTENT%></td>	
			<td><s:property value="%{model.content}" /></td>
		</tr>
	</table>
</s:form>

</body>

</html>