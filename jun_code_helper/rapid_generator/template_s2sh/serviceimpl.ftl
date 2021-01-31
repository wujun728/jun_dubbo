<#assign className=tableName?lower_case?cap_first?replace("_","")/>
<#assign reference=tableName?lower_case?replace("_","")/>
<#assign pkName=pk.name?lower_case?cap_first?replace("_","")/>
package com.hyj.service.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hyj.dao.I${className}Dao;
import com.hyj.service.I${className}Service;

public class ${className}Service extends BaseService implements I${className}Service {

	I${className}Dao ${reference}Dao;
	
	public I${className}Dao get${className}Dao() {
		return ${reference}Dao;
	}

	public void set${className}Dao(I${className}Dao ${reference}Dao) {
		this.${reference}Dao = ${reference}Dao;
	}

	public void insert(Object model) throws DataAccessException {
		${reference}Dao.insert(model);
	}

	public void update(Object model) throws DataAccessException {
		${reference}Dao.update(model);
		
	}

	public void delete(Long id) throws DataAccessException {
		${reference}Dao.delete(id);
	}

	public void delete(String ids) throws DataAccessException {
		${reference}Dao.delete(ids);
		
	}

	public List getList(String sql) throws DataAccessException {
		// TODO Auto-generated method stub
		return ${reference}Dao.getList(sql);
	}

	public Object findByPrimaryKey(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return ${reference}Dao.findByPrimaryKey(id);
	}

}
