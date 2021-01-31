<#assign className=table?lower_case?cap_first?replace("_","")/>
<#assign reference=table?lower_case?replace("_","")/>
<#assign pkName=pk.name?lower_case?replace("_","")/>
<!DOCTYPE xwork PUBLIC "-//OpenSymphony Group//XWork 1.1.1//EN" "http://www.opensymphony.com/xwork/xwork-1.1.1.dtd">

<!-- START SNIPPET: xworkSample -->

<xwork>
	<include file="webwork-default.xml" />
	<package name="${reference}" extends="webwork-default" namespace="/admin">
		<action name="${reference}" class="com.hyj.action.${className}Action">
			<result name="input">/admin/${reference}_add.jsp</result>
			<result name="success">/admin/${reference}_list.jsp</result>
			<interceptor-ref name="model-driven"/>
			<interceptor-ref name="params"/>
			<interceptor-ref name="validationWorkflowStack" >
				<param name="validation.excludeMethods">execute,input,delete,modify</param>
			</interceptor-ref>
		</action>
	</package>
	
</xwork>
