package com.freeter.service;

import java.util.List;

import com.freeter.entity.TableEntity;


/** 
* @author  作者  freeter E-mail: 171998110@qq.com
* @date 创建时间：2018年7月9日 上午10:30:15 
* @version 1.0 
* @parameter  
* @since  
* @return  
* 
* 获取数据库信息
*/
public abstract class DataBaseInfo {

	/****
	 * 获取数据库名称
	 * 
	 * @return
	 */
	public abstract String queryDatabaseName();

	/***
	 * 获取表的信息
	 * 
	 * @return
	 */
	public  abstract List<TableEntity> getTableList();

}
