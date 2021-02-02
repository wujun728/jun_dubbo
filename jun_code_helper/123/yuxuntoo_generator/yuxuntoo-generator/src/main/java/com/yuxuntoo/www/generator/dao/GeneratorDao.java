package com.yuxuntoo.www.generator.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 操作数据库接口
 * @Author Camel
 * @Date 2013/10/15 13:20
 * @Version 1.0
 */
@Repository
public interface GeneratorDao {

    List<Map<String, Object>> queryList(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}
