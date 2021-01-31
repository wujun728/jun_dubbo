<#assign ClassName=table?lower_case?cap_first?replace("_","")>
<#assign reference=table?lower_case?replace("_","")>
package com.hyj.dao.jdbc;
import java.util.List;
import java.sql.SQLException;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.dao.DataAccessException;


import com.hyj.model.${ClassName};
import com.hyj.dao.I${ClassName}Dao;
public class ${ClassName}Dao extends BaseDao implements I${ClassName}Dao{
	public ${ClassName}Dao() {
	}
	private class ${ClassName}RowMapper implements RowMapper{
		public Object mapRow(ResultSet rs, int rowNumber) throws SQLException {
			${ClassName} ${reference}= new ${ClassName}();
			<#list columnList as column>
			${reference}.set${column.name?lower_case?cap_first?replace("_","")}(<#if column.sqlType = 4|| column.sqlType=2|| column.sqlType=3>new Integer(rs.getInt("${column.name}"))<#elseif column.sqlType = -5>new Long(rs.getLong("${column.name}"))<#else>rs.getString("${column.name}")</#if>);
			</#list>
			return ${reference};
		}
	}
	public void insert(Object model) throws DataAccessException{
		${ClassName} ${reference} = (${ClassName})model;
		Object[] params = new Object[]{
		<#list columnList as column>
		<#if column!=pk>
		${reference}.get${column.name?lower_case?cap_first?replace("_","")}()<#if column_has_next>,</#if>
		</#if>
		</#list>
		};
		getJdbcTemplate().update("INSERT INTO ${table}(<#list columnList as column><#if column!=pk>${column.name}<#if column_has_next>,</#if></#if></#list>) values(<#list columnList as column><#if column!=pk>?<#if column_has_next>,</#if></#if></#list>)",params);
		}
	public void update(Object model) throws DataAccessException{
		${ClassName} ${reference} = (${ClassName})model;
		String sql="update ${table} SET <#list columnList as column><#if column!=pk>${column.name}=?<#if column_has_next>,</#if></#if></#list> WHERE ${pk.name}="+${reference}.get${pk.name?lower_case?replace("_","")?cap_first}();
		Object[] params = new Object[]{
		<#list columnList as column>
		<#if column!=pk>
		${reference}.get${column.name?lower_case?cap_first?replace("_","")}()<#if column_has_next>,</#if>
		</#if>
		</#list>
		};
		getJdbcTemplate().update(sql,params);
	}
	public void delete(String ids) throws DataAccessException{
			getJdbcTemplate().update("DELETE FROM ${table} WHERE ${pk.name} IN("+ids+")");
	}
	public void delete(Long id){
			getJdbcTemplate().update("DELETE FROM ${table} WHERE ${pk.name}="+id);
	}
	public List getList(String sql) throws DataAccessException{
		List list = getJdbcTemplate().query(sql,new ${ClassName}RowMapper());
		return list;
	}
	public List getList(){
		return getJdbcTemplate().query("SELECT * FROM ${table}",new ${ClassName}RowMapper());
	}
	public Object findByPrimaryKey(Long ID) throws DataAccessException{
		String sql="SELECT * FROM ${table} where ${pk.name}="+ID;
		List list = (List)getJdbcTemplate().query(sql,new ${ClassName}RowMapper());
		${ClassName} ${reference}=null;
		if(list.size()>0){
			${reference}=(${ClassName})list.get(0);
		}
		return ${reference};
	}
}
