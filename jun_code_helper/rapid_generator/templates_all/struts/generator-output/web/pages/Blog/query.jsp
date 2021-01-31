<%@page import="com.company.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<html:base/>
	<title><%=Blog.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<html:form action="/pages/Blog/list.do" method="post">
	<input type="submit" value="提交" onclick="return new Validation(document.forms[0]).validate();"/>
	<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/Blog/list.do'"/>
	<input type="button" value="后退" onclick="history.back();"/>
	
	<table class="formTable">
	
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=Blog.ALIAS_USERNAME%></td>
		   <td>
				<input  type="text" name="s_username" size="30" maxlength="50" class=""/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=Blog.ALIAS_BIRTH_DATE%></td>
		   <td>
				<input onclick="WdatePicker({dateFmt:'<%=Blog.FORMAT_BIRTH_DATE%>'})" type="text" name="s_birthDate" size="30" maxlength="19" class=""/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=Blog.ALIAS_SEX%></td>
		   <td>
				<input  type="text" name="s_sex" size="30" maxlength="1" class=""/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=Blog.ALIAS_TITLE%></td>
		   <td>
				<input  type="text" name="s_title" size="30" maxlength="10" class=""/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=Blog.ALIAS_LENGTH%></td>
		   <td>
				<input  type="text" name="s_length" size="30" maxlength="40" class="validate-integer "/>
		   </td>
		</tr>
		<tr bgcolor="#FFFFFF">
		   <td class="tdLabel"><%=Blog.ALIAS_CONTENT%></td>
		   <td>
				<input  type="text" name="s_content" size="30" maxlength="56" class=""/>
		   </td>
		</tr>
	
	</table>
</html:form>
			
</body>

</html>