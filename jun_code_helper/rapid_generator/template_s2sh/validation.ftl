<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE validators PUBLIC "-//OpenSymphony Group//XWork Validator 1.0//EN" "http://www.opensymphony.com/xwork/xwork-validator-1.0.dtd">
<validators>
<#list columnlist as column>
	<#if column!=pk>
	<field name="${column.name}">
		<field-validator type="requiredstring">
			<message key="${table?replace("_","")?lower_case}.${column.name}"/>
		</field-validator>
	</field>
	</#if>
</#list>
</validators>
