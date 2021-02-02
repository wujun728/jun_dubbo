package com.yuxuntoo.www.generator.service;

import com.yuxuntoo.www.common.exception.BussException;
import com.yuxuntoo.www.common.vo.req.QueryParamReq;
import com.yuxuntoo.www.common.vo.resp.PageInfo;

import java.util.List;
import java.util.Map;

/**
 *
 * @Author Camel
 * @Date 2013/10/15 17:10
 * @Version 1.0
 */
public interface GeneratorService {

    PageInfo queryList(QueryParamReq query);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);

    byte[] generatorCode(String[] tableNames) throws BussException;
}
