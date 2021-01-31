<%@page import="com.company.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<input type="hidden" id="id" name="id" value="${blog.id}"/>

	<tr>	
		<td class="tdLabel">
			<%=Blog.ALIAS_USERNAME%>:
		</td>		
		<td>
		<form:input path="blog.username" id="username" cssClass="" maxlength="50" />
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<span class="required">*</span><%=Blog.ALIAS_BIRTH_DATE%>:
		</td>		
		<td>
		<input value="${blog.birthDateString}" onclick="WdatePicker({dateFmt:'<%=Blog.FORMAT_BIRTH_DATE%>'})" id="birthDateString" name="birthDateString"  maxlength="0" class="required " />
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Blog.ALIAS_SEX%>:
		</td>		
		<td>
		<form:input path="blog.sex" id="sex" cssClass="" maxlength="1" />
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Blog.ALIAS_TITLE%>:
		</td>		
		<td>
		<form:input path="blog.title" id="title" cssClass="" maxlength="10" />
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Blog.ALIAS_LENGTH%>:
		</td>		
		<td>
		<form:input path="blog.length" id="length" cssClass="validate-integer " maxlength="40" />
		</td>
	</tr>	
	
	<tr>	
		<td class="tdLabel">
			<%=Blog.ALIAS_CONTENT%>:
		</td>		
		<td>
		<form:input path="blog.content" id="content" cssClass="" maxlength="56" />
		</td>
	</tr>	
	


