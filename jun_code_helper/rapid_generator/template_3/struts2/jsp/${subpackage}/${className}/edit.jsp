<#include "macro.include"/> 
<#include "custom.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=${className}.TABLE_ALIAS%>编辑</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="${strutsActionBasePath}/update.action" method="post">
	<input id="submit" name="submit" type="submit" value="提交" />
	<input type="button" value="返回列表" onclick="window.location='<@jspEl 'ctx'/>${strutsActionBasePath}/list.action'"/>
	
	<table class="formTable">
	<%@ include file="form_include.jsp" %>
	</table>
</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		
		return disableSubmit(finalResult);
	}});
	
	function disableSubmit(finalResult) {
		if(finalResult) {
			$('submit').disabled = true;
			return finalResult;
		}else {
			return finalResult;
		}
	}
</script>

</body>

</html>