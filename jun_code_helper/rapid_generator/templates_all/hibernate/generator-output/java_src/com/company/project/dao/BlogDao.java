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


import org.springframework.stereotype.Component;

@Component
public class BlogDao extends BaseHibernateDao<Blog,java.lang.Long>{

	public Class getEntityClass() {
		return Blog.class;
	}
	
	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		//XsqlBuilder syntax,please see http://code.google.com/p/rapid-xsqlbuilder
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = "select t from Blog t where 1=1 "
				+ "/~ and t.username = '[username]' ~/"
				+ "/~ and t.birthDate = '[birthDate]' ~/"
				+ "/~ and t.sex = '[sex]' ~/"
				+ "/~ and t.title = '[title]' ~/"
				+ "/~ and t.length = '[length]' ~/"
				+ "/~ and t.content = '[content]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	public Blog getByUsername(java.lang.String v) {
		return (Blog) findByProperty("username",v);
	}	

}
