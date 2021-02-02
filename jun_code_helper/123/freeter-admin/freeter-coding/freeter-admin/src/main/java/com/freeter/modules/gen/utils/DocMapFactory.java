package com.freeter.modules.gen.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.freeter.common.utils.SpringContextUtils;
import com.freeter.modules.gen.entity.TableEntity;
import com.freeter.modules.gen.service.MysqlDataBaseService;
import com.freeter.modules.gen.service.OracleDataBaseService;

@Component
public class DocMapFactory {

	
	
	public static Map build() throws SQLException {
		Map map = new HashMap();
		String databaseProductName = getDatabaseProductName();
		if (("MySQL").equals(databaseProductName)) {

			MysqlDataBaseService mysqlDataBaseService = (MysqlDataBaseService) SpringContextUtils
					.getBean("mysqlDataBaseService");
			String databaseName = mysqlDataBaseService.queryDatabaseName();
			List<TableEntity> tableInfos = mysqlDataBaseService.getTableList();

			map.put("tableInfos", tableInfos);
			map.put("databaseName", databaseName);

		} else if (("Oracle").equals(databaseProductName)) {

			OracleDataBaseService oracleDataBaseService = (OracleDataBaseService) SpringContextUtils
					.getBean("oracleDataBaseService");
			String databaseName = oracleDataBaseService.queryDatabaseName();
			List<TableEntity> tableInfos = oracleDataBaseService.getTableList();

			map.put("tableInfos", tableInfos);
			map.put("databaseName", databaseName);

		}

		return map;
	}

	public static String getDatabaseProductName() throws SQLException {
		DataSource dataSource = (DataSource) SpringContextUtils.getBean("dataSource");
		Connection connection = dataSource.getConnection();
		System.out.println(connection.isClosed());
		String databaseProductName = connection.getMetaData().getDatabaseProductName();
		connection.close();
		
		return databaseProductName;
	}
	
	public static Boolean isMysql() throws Exception {
		if (("MySQL").equals(new DocMapFactory().getDatabaseProductName())) {
			return true;
		}
		return false;
}
}
