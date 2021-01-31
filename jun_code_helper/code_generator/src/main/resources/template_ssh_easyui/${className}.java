package com.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.erp.util.ExcelVOAttribute;

/**
 * ${Table} entity. @author Wujun
 */
@Entity
@Table(name = "${TableName}")
@DynamicUpdate(true)
@DynamicInsert(true)
public class ${Table} implements java.io.Serializable
{
	private static final long serialVersionUID = -5610203466348081933L;
	
	<#list models as model>
		<#if model.id==true>
		@Id
			<#if model.identity=='YES'>
		@GeneratedValue(strategy = GenerationType.IDENTITY)
			</#if>
		</#if>
			<#if model.simpleType=='Date'>
		@Temporal(TemporalType.TIMESTAMP)
			</#if>
	    @Column(name = "${model.column}")
		private ${model.simpleType} ${model.name};//${model.desc!""}
	</#list>
	
	

	<#list models as model>
		//get方法
		public ${model.simpleType} get${model.upperName}() {
			return ${model.name};
		}
	
		//set方法
		public void set${model.upperName}(${model.simpleType} ${model.name}) {
			this.${model.name} = ${model.name};
		}
	</#list>

}