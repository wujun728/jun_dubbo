<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">

<beans>
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<property name="url" value="jdbc:mysql://192.168.1.18:3306/shxbs?useUnicode=true&amp;characterEncoding=gb2312" />
		<property name="username" value="root" />
		<property name="password" value="51766" />
		<property name="maxActive" value="30" />
		<property name="maxIdle" value="5" />
		<property name="maxWait" value="1000" />
		<property name="defaultAutoCommit" value="true" />
	</bean>
	<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
		<property name="dataSource">
			<ref local="dataSource" />
		</property>
	</bean>
	<#list tableList as table>
	<bean id="${table?lower_case?replace("_","")}Dao" class="com.hyj.dao.jdbc.${table?lower_case?cap_first?replace("_","")}Dao"></bean>
	<bean id="${table?lower_case?replace("_","")}Service" class="com.hyj.service.impl.${table?lower_case?cap_first?replace("_","")}Service" parent="baseService">
		<property name="${table?lower_case?replace("_","")}Dao">
			<ref local="${table?lower_case?replace("_","")}Dao"/>
		</property>
	</bean>
	</#list>
</beans>
