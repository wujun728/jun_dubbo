package com.freeter.modules.gen.dao;

import java.util.List;
import java.util.Map;

import com.freeter.modules.gen.entity.ColumnEntity;
import com.freeter.modules.gen.entity.ReferencedTable;
import com.freeter.modules.gen.entity.TableEntity;

/**
 * 飞特超级代码生成器
 * 
 * @author xc
 * @email 171998110@qq.com
 * @date 2018年06月20日 上午9:12:58
 */
public interface SysGeneratorDao {
	
	List<TableEntity> queryList(Map<String, Object> map);
	
	List<TableEntity> queryOracleList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	int queryOracleTotal(Map<String, Object> map);
	
	TableEntity queryTable(String tableName);
		
	List<ReferencedTable> queryReferenced(String tableName);
	
	List<ReferencedTable> queryOracleReferenced(String tableName); 
	String queryDatabaseName();
	
	List<TableEntity> queryTableList(Map<String, Object> map);
	
	List<ColumnEntity>  selectAllColumns(String tableName);
	
	List<TableEntity> queryOracleTableList(Map<String, Object> map);
	
	List<ColumnEntity>  selectAllOracleColumns(String tableName);
	
	TableEntity queryOracleTable(String tableName);
}
