<%@page import="com.company.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<html:hidden styleId="id" property="id" name="BlogForm"/>

	
	<tr>
		<td class="tdLabel">
			<%=Blog.ALIAS_USERNAME%>:
		</td>
		<td>
		<html:text  styleId="username" property="username" name="BlogForm"  maxlength="50" styleClass="" />
		</td>
	</tr>
	
	<tr>
		<td class="tdLabel">
			<span class="required">*</span><%=Blog.ALIAS_BIRTH_DATE%>:
		</td>
		<td>
		<input value="${BlogForm.birthDateString}" onclick="WdatePicker({dateFmt:'<%=Blog.FORMAT_BIRTH_DATE%>'})"  id="birthDateString" name="birthDateString"  maxlength="0" class="required " />
		</td>
	</tr>
	
	<tr>
		<td class="tdLabel">
			<%=Blog.ALIAS_SEX%>:
		</td>
		<td>
		<html:text  styleId="sex" property="sex" name="BlogForm"  maxlength="1" styleClass="" />
		</td>
	</tr>
	
	<tr>
		<td class="tdLabel">
			<%=Blog.ALIAS_TITLE%>:
		</td>
		<td>
		<html:text  styleId="title" property="title" name="BlogForm"  maxlength="10" styleClass="" />
		</td>
	</tr>
	
	<tr>
		<td class="tdLabel">
			<%=Blog.ALIAS_LENGTH%>:
		</td>
		<td>
		<html:text  styleId="length" property="length" name="BlogForm"  maxlength="40" styleClass="validate-integer " />
		</td>
	</tr>
	
	<tr>
		<td class="tdLabel">
			<%=Blog.ALIAS_CONTENT%>:
		</td>
		<td>
		<html:text  styleId="content" property="content" name="BlogForm"  maxlength="56" styleClass="" />
		</td>
	</tr>

