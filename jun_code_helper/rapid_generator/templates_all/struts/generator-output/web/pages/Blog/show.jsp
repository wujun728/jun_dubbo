<%@page import="com.company.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<html:base/>
	<title><%=Blog.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<html:form action="/pages/Blog/list.do" method="post">
	<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/Blog/list.do'"/>
	<input type="button" value="后退" onclick="history.back();"/>
	
	<html:hidden styleId="id" property="id" name="BlogForm"/>

	<table class="formTable">
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_USERNAME%></td>	
			<td><c:out value='${BlogForm.username}'/></td>
		</tr>
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_BIRTH_DATE%></td>	
			<td><c:out value='${BlogForm.birthDateString}'/></td>
		</tr>
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_SEX%></td>	
			<td><c:out value='${BlogForm.sex}'/></td>
		</tr>
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_TITLE%></td>	
			<td><c:out value='${BlogForm.title}'/></td>
		</tr>
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_LENGTH%></td>	
			<td><c:out value='${BlogForm.length}'/></td>
		</tr>
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_CONTENT%></td>	
			<td><c:out value='${BlogForm.content}'/></td>
		</tr>
	</table>
</html:form>

</body>

</html>