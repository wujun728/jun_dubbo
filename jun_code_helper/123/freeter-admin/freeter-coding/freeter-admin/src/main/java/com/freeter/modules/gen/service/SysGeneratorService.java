package com.freeter.modules.gen.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeter.common.utils.SpringContextUtils;
import com.freeter.modules.gen.dao.SysGeneratorDao;
import com.freeter.modules.gen.entity.ColumnEntity;
import com.freeter.modules.gen.entity.ReferencedTable;
import com.freeter.modules.gen.entity.TableEntity;
import com.freeter.modules.gen.utils.DocMapFactory;
import com.freeter.modules.gen.utils.GenUtils;

/**
 * 飞特超级代码生成器
 * 
 * @author xc
 * @email 171998110@qq.com
 * @date 2018年06月20日 上午10:06:50
 */
@Service
public class SysGeneratorService {
	@Autowired
	private SysGeneratorDao sysGeneratorDao;
	
	public List<TableEntity> queryList(Map<String, Object> map) {

	
		try {
			if(DocMapFactory.isMysql()) {
				return sysGeneratorDao.queryList(map);
			}
			Integer rnum = (Integer)map.get("offset")+
					(Integer) map.get("limit");
			map.put("rnum", rnum);
			return sysGeneratorDao.queryOracleTableList(map);
		} catch (Exception e) {
			return null;
		}
	}

	public int queryTotal(Map<String, Object> map) {
		try {
			if(DocMapFactory.isMysql()) {
				return sysGeneratorDao.queryTotal(map);
			}
		return sysGeneratorDao.queryOracleTotal(map);
		} catch (Exception e) {
			return 0;
		}
		
	}

	 
	
	public TableEntity queryTable(String tableName) {
		try {
			if(DocMapFactory.isMysql()) {
				return sysGeneratorDao.queryTable(tableName);
			}
			return sysGeneratorDao.queryOracleTable(tableName);
		} catch (Exception e) {
			return null;
		}
	}

	public List<ColumnEntity> queryColumns(String tableName) {
		try {
			if(DocMapFactory.isMysql()) {
				return sysGeneratorDao.selectAllColumns(tableName);

			}
			return sysGeneratorDao.selectAllOracleColumns(tableName);
		//	return	sysGeneratorDao.selectAllOracleColumns(tableName);
		}catch (Exception e) {
			return null;
		}
	}

	public List<ReferencedTable> queryReferenced(String tableName) {
		try {
			if(DocMapFactory.isMysql()) {
				return sysGeneratorDao.queryReferenced(tableName);

			}
		return sysGeneratorDao.queryOracleReferenced(tableName);
		}catch (Exception e) {
			return null;
		}
	}

	public byte[] generatorCode(String[] tableNames) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);

		for (String tableName : tableNames) {
			// 查询表信息
			TableEntity table = queryTable(tableName);
			// 查询列信息
			List<ColumnEntity> columns = queryColumns(tableName);
			// 查询关联表的信息
			List<ReferencedTable> listReferencedTable = queryReferenced(tableName);
			// 生成代码
			GenUtils.generatorCode(table, listReferencedTable, columns, zip);
		}
		IOUtils.closeQuietly(zip);
		return outputStream.toByteArray();
	}

	public void generatorAllCode(String[] tableNames,List<String> templates) throws IOException {

		for (String tableName : tableNames) {
			// 查询表信息
			TableEntity table = queryTable(tableName);
			// 查询列信息
			List<ColumnEntity> columns = queryColumns(tableName);
			// 查询关联表的信息
			List<ReferencedTable> listReferencedTable = queryReferenced(tableName);
			// 生成代码
			GenUtils.generatorAllCode(table, listReferencedTable, columns,templates);
		}
	}

	
}
