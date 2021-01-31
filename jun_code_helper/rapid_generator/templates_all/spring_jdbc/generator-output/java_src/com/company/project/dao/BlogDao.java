/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

package com.company.project.dao;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.company.project.model.*;
import com.company.project.dao.*;
import com.company.project.service.*;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Component;

@Component
public class BlogDao extends BaseSpringJdbcDao<Blog,java.lang.Long>{
	
	static final String SELECT_PREFIX = "select id,username,birth_date,sex,title,length,content from blog ";
	
	public Class getEntityClass() {
		return Blog.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from blog where id=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return SELECT_PREFIX + " where id=? ";
	}
	
	public void save(Blog entity) {
		String sql = "insert into blog " 
			 + " (id,username,birth_date,sex,title,length,content) " 
			 + " values "
			 + " (:id,:username,:birthDate,:sex,:title,:length,:content)";
		insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"sequenceName",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Blog entity) {
		String sql = "update blog set "
					+ " id=:id,username=:username,birth_date=:birthDate,sex=:sex,title=:title,length=:length,content=:content "
					+ " where id=:id";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = SELECT_PREFIX ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		//XsqlBuilder syntax,please see http://code.google.com/p/rapid-xsqlbuilder
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = SELECT_PREFIX + " t where 1=1 "
				+ "/~ and t.username = '[username]' ~/"
				+ "/~ and t.birth_date = '[birthDate]' ~/"
				+ "/~ and t.sex = '[sex]' ~/"
				+ "/~ and t.title = '[title]' ~/"
				+ "/~ and t.length = '[length]' ~/"
				+ "/~ and t.content = '[content]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	public Blog getByUsername(java.lang.String v) {
		String sql =  SELECT_PREFIX + " where username=?";
		return (Blog)getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), v);
	}	

}
