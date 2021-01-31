<#assign reference=table?lower_case?replace("_","")/>
<#assign pkName=pk.name?lower_case?replace("_","")/>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hyj.util.*"%>
<%@taglib uri="webwork" prefix="ww"%>
<HTML>
<TITLE></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<LINK href="css.css" type=text/css rel=stylesheet>
<ww:head theme="ajax" />
<body class="body_bg_color">

<table width="778" height="100%" align="center"  cellpadding="0" cellspacing="0" border="0" bgcolor="ffffff" >
  <tr>
    <td valign="top" height="24">
      <TABLE  cellSpacing=0 cellPadding=0 width="100%"  border=0 >
        <TR class="TB1">
          <TD align=center  height="24"><strong><ww:if test="\"insert\".equals(action)">          
           添加 
            </ww:if>       
            <ww:elseif test="\"update\".equals(action)">
          修改
            </ww:elseif> ${reference}</strong></TD>
        </TR>
      </TABLE>
    </td>
  </tr>
  <tr>
    <td  height="100%" valign="top">
      <ww:form action="${reference}!%{action}.action" method="post"> 
      <ww:hidden name="action" theme="simple"/>
      <TABLE width="100%" height="256"  border=0 cellPadding=0  cellSpacing=0 >
	  	<TR valign="top" class="TB3" bgcolor="#FFFFFF">
          <TD  colspan="2" align=middle >
            <table width="100%" align="center"   border="0" cellspacing="1" cellpadding="6" bgcolor="#CCCCCC"  >
            <#list columnList as column>
            <#if column=pk>
            <ww:hidden name="${pk.name}" theme="simple" />	
            <#else>
              <tr bgcolor="#FFFFFF">
                <td width="20%" height="20" align="right" bgcolor="#f5f5f5" class="TB5">${column.name}：</td>
                <td width="80%">
                  <ww:textfield name="${column.name}"  theme="simple" cssClass="inputStyle"/>
                  <span class="errorMessage">*</span><ww:fielderror><ww:param>${column.name}</ww:param></ww:fielderror></td>
              </tr>
            </#if>    
            </#list>          
            </table>
          </TD>
        </TR>	
        <tr>
          <td align="center" colspan="2"><br>
			<ww:if test="\"insert\".equals(action)">          
            <ww:submit cssClass="buttonstyle" value="保存" theme="simple"/> 
            </ww:if>       
            <ww:elseif test="\"update\".equals(action)">
            <ww:submit cssClass="buttonstyle" value="修改" theme="simple"/>    
            </ww:elseif>
            
            &nbsp;&nbsp;
            <ww:reset cssClass="buttonstyle" value="重填" theme="simple"/>
          </td>
        </tr>
       </table>
	</ww:form> 	
</table>

</BODY>
</HTML>
