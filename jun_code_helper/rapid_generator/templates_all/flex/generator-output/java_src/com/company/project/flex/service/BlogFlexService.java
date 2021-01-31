/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */


package com.company.project.flex.service;

import org.springframework.stereotype.Component;

import cn.org.rapid_framework.util.HibernateBeanSerializer;

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


/**
 * 名称以FlexService结尾并且装载进Spring则会自动导出为BlazeDS的RemoteObject对象
 */
@Component
public class BlogFlexService extends BaseRemoteFlexService<Blog>{

	private BlogManager blogManager;
	/**通过spring注入BlogManager*/
	public void setBlogManager(BlogManager blogManager) {
		this.blogManager = blogManager;
	}
	
	/**通过PageRequest查询列表*/
	public Page list(PageRequest pr) {
		Page page = blogManager.findByPageRequest(pr);
		return convertPageList2BeanSerializerProxy(page);
	}
	
	public  Blog save(Blog vo) {
		blogManager.saveOrUpdate(vo);
		return new HibernateBeanSerializer<Blog>(vo).getProxy();
	}
	
	public void del(java.lang.Long[] ids) {
		for(java.lang.Long id : ids) {
			blogManager.removeById(id);
		}
	}
	
}
