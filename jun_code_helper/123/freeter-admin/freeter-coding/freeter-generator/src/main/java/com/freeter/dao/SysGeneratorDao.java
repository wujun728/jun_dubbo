package com.freeter.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.freeter.entity.ColumnEntity;
import com.freeter.entity.ReferencedTable;
import com.freeter.entity.TableEntity;

/**
 * 飞特超级代码生成器
 * 
 * @author xc
 * @email 171998110@qq.com
 * @date 2018年06月20日 上午9:12:58
 */
@Mapper
public interface SysGeneratorDao {
	
	List<Map<String, Object>> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	Map<String, String> queryTable(String tableName);
	
	List<Map<String, String>> queryColumns(String tableName);
	
	List<ReferencedTable> queryReferenced(String tableName);
	
	String queryDatabaseName();
	
	List<TableEntity> queryTableList(Map<String, Object> map);
	
	List<ColumnEntity>  selectAllColumns(String tableName);
	
	List<TableEntity> queryOracleTableList(Map<String, Object> map);
	
	List<ColumnEntity>  selectAllOracleColumns(String tableName);
}
