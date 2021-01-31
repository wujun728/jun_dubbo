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
public class BlogDao extends BaseIbatisDao<Blog,java.lang.Long>{

	public Class getEntityClass() {
		return Blog.class;
	}
	
	public void saveOrUpdate(Blog entity) {
		if(entity.getId() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findByPageRequest(PageRequest pageRequest) {
		return pageQuery("Blog.pageSelect",pageRequest);
	}
	
	public Blog getByUsername(java.lang.String v) {
		return (Blog)getSqlMapClientTemplate().queryForObject("Blog.getByUsername",v);
	}	

}
