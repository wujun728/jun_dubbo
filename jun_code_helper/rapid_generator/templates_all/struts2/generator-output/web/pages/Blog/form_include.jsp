<%@page import="com.company.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
	
	<s:textfield label="%{@vs@ALIAS_USERNAME}" key="username" value="%{model.username}" cssClass="" required="false" />
	
	
	<tr>	
		<td class="tdLabel">
			<span class="required">*</span><%=Blog.ALIAS_BIRTH_DATE%>:
		</td>	
		<td>
		<input value="${model.birthDateString}" onclick="WdatePicker({dateFmt:'<%=Blog.FORMAT_BIRTH_DATE%>'})" id="birthDateString" name="birthDateString"  maxlength="0" class="required " />
		</td>
	</tr>
	
	
	<s:textfield label="%{@vs@ALIAS_SEX}" key="sex" value="%{model.sex}" cssClass="" required="false" />
	
	
	<s:textfield label="%{@vs@ALIAS_TITLE}" key="title" value="%{model.title}" cssClass="" required="false" />
	
	
	<s:textfield label="%{@vs@ALIAS_LENGTH}" key="length" value="%{model.length}" cssClass="validate-integer " required="false" />
	
	
	<s:textfield label="%{@vs@ALIAS_CONTENT}" key="content" value="%{model.content}" cssClass="" required="false" />
	
