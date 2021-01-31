<%@page import="com.company.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Blog.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<form action="${ctx}/pages/Blog/list.do" method="post">
	<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/Blog/list.do'"/>
	<input type="button" value="后退" onclick="history.back();"/>
	
	<input type="hidden" id="id" name="id" value="${blog.id}"/>

	<table class="formTable">
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_USERNAME%></td>	
			<td><c:out value='${blog.username}'/></td>
		</tr>
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_BIRTH_DATE%></td>	
			<td><c:out value='${blog.birthDateString}'/></td>
		</tr>
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_SEX%></td>	
			<td><c:out value='${blog.sex}'/></td>
		</tr>
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_TITLE%></td>	
			<td><c:out value='${blog.title}'/></td>
		</tr>
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_LENGTH%></td>	
			<td><c:out value='${blog.length}'/></td>
		</tr>
		<tr>	
			<td class="tdLabel"><%=Blog.ALIAS_CONTENT%></td>	
			<td><c:out value='${blog.content}'/></td>
		</tr>
	</table>
</form>

</body>

</html>