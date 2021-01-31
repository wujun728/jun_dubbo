<%@page import="com.company.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=Blog.TABLE_ALIAS%> 维护</title>
	
	<link href="<c:url value="/widgets/simpletable/simpletable.css"/>" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="<c:url value="/widgets/simpletable/simpletable.js"/>"></script>
	
	<script type="text/javascript" >
		$(document).ready(function() {
			// 分页需要依赖的初始化动作
			window.simpleTable = new SimpleTable('simpleTableForm',${page.thisPageNumber},${page.pageSize},'${pageRequest.sortColumns}');
		});
	</script>

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
			<td class="tdLabel">
					<%=Blog.ALIAS_LENGTH%>
			</td>		
			<td>
				<input value="${pageRequest.filters.length}" id="length" name="length"  />
			</td>
		</tr>	
		<tr>	
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
	<input type="button" class="stdButton" style="width:80px" value="删除" onclick="batchDelete('${ctx}/pages/Blog/delete.do','items',document.forms.simpleTableForm)"/>
<div>
</form>
</div>

<form id="simpleTableForm" action="<c:url value="/pages/Blog/list.do"/>" method="get" style="display: inline;">

	<!-- auto include parameters -->
	<c:forEach items="${pageRequest.filters}" var="entry">
	<input type="hidden" name="s_${entry.key}" value="${entry.value}"/>
	</c:forEach>
	
	<input type="hidden" name="pageNumber" id="pageNumber" />
	<input type="hidden" name="pageSize" id="pageSize"/>
	<input type="hidden" name="sortColumns" id="sortColumns"/>
	
	<div class="gridTable">
	
		<simpletable:pageToolbar page="${page}">
		显示在这里是为了提示你如何自定义表头,可修改模板删除此行
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="gridBody">
		  <thead class="tableHeader">
			  
			  <tr>
				<th style="width:1px;"> </th>
				<th style="width:1px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="username" ><%=Blog.ALIAS_USERNAME%></th>
				<th sortColumn="birth_date" ><%=Blog.ALIAS_BIRTH_DATE%></th>
				<th sortColumn="sex" ><%=Blog.ALIAS_SEX%></th>
				<th sortColumn="title" ><%=Blog.ALIAS_TITLE%></th>
				<th sortColumn="length" ><%=Blog.ALIAS_LENGTH%></th>
				<th sortColumn="content" ><%=Blog.ALIAS_CONTENT%></th>

				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody class="tableBody">
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="checkbox"></td>
				
				<td><c:out value='${item.username}'/>&nbsp;</td>
				<td><c:out value='${item.birthDateString}'/>&nbsp;</td>
				<td><c:out value='${item.sex}'/>&nbsp;</td>
				<td><c:out value='${item.title}'/>&nbsp;</td>
				<td><c:out value='${item.length}'/>&nbsp;</td>
				<td><c:out value='${item.content}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/pages/Blog/show.do?id=${item.id}&">查看</a>&nbsp;&nbsp;&nbsp;
					<a href="${ctx}/pages/Blog/edit.do?id=${item.id}&">修改</a>
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar page="${page}">
		显示在这里是为了提示你如何自定义表头,可修改模板删除此行
		</simpletable:pageToolbar>
		
	</div>
</form>

</body>
</html>

