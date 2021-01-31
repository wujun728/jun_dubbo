<#assign reference=table?lower_case?replace("_","")/>
<#assign pkName=pk.name?lower_case?replace("_","")/>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script language="JavaScript">
<!--
//table样式
function TableMouseOver(Obj){
	Obj.style.backgroundColor='#f2f2f2';
}
function TableMouseOut(Obj){
	Obj.style.backgroundColor='';
}
//checkbox样式
function TableBgLock(Obj){
	if(!Obj.checked){
		Obj.style.backgroundColor='';
	}else{
		Obj.style.backgroundColor='orange';
	}
}
function CheckAll(form) {
	for (var i=0;i<form.elements.length;i++) {
		var e = form.elements[i];
		if (e.name != 'chkall' && e.type=='checkbox')
			e.checked = form.chkall.checked;
			TableBgLock(e);
	}
}

function modify(form){
	
	var flag=0;
	for (var i=0;i<form.elements.length;i++) {
            var e = form.elements[i];
            if (e.type=='checkbox'){
                if (e.checked){
               	  flag=flag+1;
                 }
            }
    }
	if(flag==1){
		form.action="${reference}!modify.action";
		form.submit();
	} else if(flag>1){
		alert("只能选择一条记录");
	} else {
		alert("请选择记录！");
	}
}
function add(form){
	form.action="${reference}!input.action";
	form.submit();
}
function del(form){
	var flag=0;
	for (var i=0;i<form.elements.length;i++) {
            var e = form.elements[i];
            if (e.type=='checkbox'&&e.name!= 'chkall' ){
                if (e.checked){
               	  flag=flag+1;
                 }
            }
    }
	if(flag>=1){
		form.action="${reference}!delete.action";
		form.submit();
	}  else {
		alert("没有选择记录！");
	}
}
// -->
</script>

<link href="css.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="#EEF8DE" topmargin="0" leftmargin="0">
<ww:form action="${reference}" method="post">

	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		align="center">
		<tr valign=bottom>
			<td nowrap width="50"><img src="./images/tit-logo.gif" height="30" width="40"></td>
			<td nowrap width="100"><span class="tit">${table}管理</span></td>
			<td nowrap>&nbsp;</td>
			<td width="50%"></td>
		</tr>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		align="center">
		<tr>
			<td height="2" bgcolor="#87CD00"></td>
		</tr>
		<tr>
			<td height="2" bgcolor="#6FA800"></td>
		</tr>
	</table>
	
	<table width="100%" border="0" cellspacing="0" cellpadding="3"
		align="center">
		<tr valign="bottom">
			<td nowrap><input type="button" onClick="add(this.form)" class="button" value="添加"/>&nbsp;<input type="button" onClick="modify(this.form)" class="button" value="修改"/>&nbsp;<input type="button" onClick="del(this.form);" class="button" value="删除"/></td>
			<td align="right"><ww:property value="pageBean.pageLink" escape="false"/></td>
		</tr>
	</table>      
	<table width="100%" border="0" cellspacing="0" cellpadding="3"
		align="center">
		<tr class="TB4">
			<td nowrap valign="bottom" width="40%"><input type="checkbox"
				value="on"
				title="选中所有记录"
				name="chkall" onClick="CheckAll(this.form)">选中所有记录</td>
			<td nowrap height="60%" align="left">                    
                        </td>
		</tr>
	</table>

	<table width="100%" border="1" cellspacing="0" cellpadding="3"
		bordercolorlight="C0BFD1" bordercolordark="#FFFFFF" bgcolor="#FFFFFF"
		align="center" frame="void" rules="rows">
		<tbody>
			<tr class="TB1" align="center" valign="bottom">
				<td nowrap width="20">&nbsp;</td>
				<#list columnlist as column>
				<#if column!=pk>
				<td nowrap align="left"><font color="#ffffff">${column.name}</font></td>
				</#if>
				</#list>
			</tr>       
				<ww:iterator value="pageBean.elements">
				<tr class="TB3" align="center" valign="bottom"
					onmouseover="TableMouseOver(this)" onMouseOut="TableMouseOut(this)">
					<td><ww:checkbox name="id" theme="simple" fieldValue="%{${pkName}}"  /></td>
					<#list columnlist as column>
					<#if column!=pk>
					<td align="left" nowrap><ww:property value="${column.name}"/></td>
					</#if>
					</#list>
				</tr>
				</ww:iterator>                  
			<tr>
				<td colspan="6"></td>
			</tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="3" border="0"
		align="center">
		<tr class="TB2" align="center">
			<td nowrap height="20"><a href=""></a></td>
		</tr>
	</table>
</form>
</body>
</html>