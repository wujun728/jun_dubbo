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
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=Blog.TABLE_ALIAS%> 维护</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
<form action="<c:url value="/pages/Blog/list.do"/>" method="get" style="display: inline;">
<fieldset>
	<legend>搜索</legend>
	<table>
		<tr>	
			<td class="tdLabel">
					<%=Blog.ALIAS_USERNAME%>
			</td>		
			<td>
				<input value="${pageRequest.filters.username}" id="username" name="username"  />
			</td>
			<td class="tdLabel">
					<%=Blog.ALIAS_BIRTH_DATE%>
			</td>		
			<td>
				<input value="${pageRequest.filters.birthDateString}" onclick="WdatePicker({dateFmt:'<%=Blog.FORMAT_BIRTH_DATE%>'})" id="birthDateString" name="birthDateString"   />
			</td>
			<td class="tdLabel">
					<%=Blog.ALIAS_SEX%>
			</td>		
			<td>
				<input value="${pageRequest.filters.sex}" id="sex" name="sex"  />
			</td>
			<td class="tdLabel">
					<%=Blog.ALIAS_TITLE%>
			</td>		
			<td>
				<input value="${pageRequest.filters.title}" id="title" name="title"  />
			</td>
		</tr>	
		<tr>	
			<td class="tdLabel">
					<%=Blog.ALIAS_LENGTH%>
			</td>		
			<td>
				<input value="${pageRequest.filters.length}" id="length" name="length"  />
			</td>
			<td class="tdLabel">
					<%=Blog.ALIAS_CONTENT%>
			</td>		
			<td>
				<input value="${pageRequest.filters.content}" id="content" name="content"  />
			</td>
		</tr>	
	</table>
</fieldset>
<div class="handleControl">
	<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/Blog/list.do'"/>
	<input type="submit" class="stdButton" style="width:80px" value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/Blog/create.do'"/>
	<input type="button" class="stdButton" style="width:80px" value="删除" onclick="batchDelete('${ctx}/pages/Blog/delete.do','items',document.forms.ec)"/>
<div>
</form>
</div>

<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/Blog/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="id=${item.id}&"/>
		</ec:column>
		<ec:column property="username"  title="<%=Blog.ALIAS_USERNAME%>"/>
		<ec:column property="birthDate" value="${item.birthDateString}" title="<%=Blog.ALIAS_BIRTH_DATE%>"/>
		<ec:column property="sex"  title="<%=Blog.ALIAS_SEX%>"/>
		<ec:column property="title"  title="<%=Blog.ALIAS_TITLE%>"/>
		<ec:column property="length"  title="<%=Blog.ALIAS_LENGTH%>"/>
		<ec:column property="content"  title="<%=Blog.ALIAS_CONTENT%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/Blog/show.do?id=${item.id}&">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/Blog/edit.do?id=${item.id}&">修改</a>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>

