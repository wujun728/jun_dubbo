package com.freeter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeter.dao.SysGeneratorDao;
import com.freeter.entity.ColumnEntity;
import com.freeter.entity.TableEntity;

/** 
* @author  作者  freeter E-mail: 171998110@qq.com
* @date 创建时间：2018年7月9日 上午10:30:15 
* @version 1.0 
* @parameter  
* @since  
* @return  
* 
* 获取mysql数据库信息
*/
 

@Service("mysqlDataBaseService")
public class MysqlDataBaseService extends DataBaseInfo {

	@Autowired
	private SysGeneratorDao sysGeneratorDao;

	 
	public String queryDatabaseName() {
  		return sysGeneratorDao.queryDatabaseName();
	}

 	public List<TableEntity> getTableList() {
		List<TableEntity> tables = sysGeneratorDao.queryTableList(null);
	 
		 
		tables.stream().forEach((tableInfo) -> {
			List<ColumnEntity> columns = sysGeneratorDao.selectAllColumns(tableInfo.getTableName());
			tableInfo.setColumns(columns);
		});
		return tables;
	}

	 
 

}
