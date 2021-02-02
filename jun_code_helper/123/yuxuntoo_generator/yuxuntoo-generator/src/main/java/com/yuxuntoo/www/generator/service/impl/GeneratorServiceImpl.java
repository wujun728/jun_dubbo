package com.yuxuntoo.www.generator.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yuxuntoo.www.generator.dao.GeneratorDao;
import com.yuxuntoo.www.common.exception.BussException;
import com.yuxuntoo.www.generator.service.GeneratorService;
import com.yuxuntoo.www.common.vo.req.QueryParamReq;
import com.yuxuntoo.www.common.vo.resp.PageInfo;
import com.yuxuntoo.www.generator.utils.GenUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成工具实现
 * @Author Camel
 * @Date 2013/10/15 17:37
 * @Version 1.0
 */
@Service
public class GeneratorServiceImpl implements GeneratorService {
    @Autowired
    private GeneratorDao generatorDao;

    @Override
    public PageInfo queryList(QueryParamReq query) {
        Page<?> page = PageHelper.startPage(query.getPage(), query.getLimit());
        List<Map<String, Object>> list = generatorDao.queryList(query);
        int total = (int) page.getTotal();
        // TODO 如果是Mogon需要单独处理一下
        return new PageInfo(list, total, query.getLimit(), query.getPage());
    }

    @Override
    public Map<String, String> queryTable(String tableName) {
        return generatorDao.queryTable(tableName);
    }

    @Override
    public List<Map<String, String>> queryColumns(String tableName) {
        return generatorDao.queryColumns(tableName);
    }

    @Override
    public byte[] generatorCode(String[] tableNames) throws BussException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        for (String tableName : tableNames) {
            //查询表信息
            Map<String, String> table = queryTable(tableName);
            //查询列信息
            List<Map<String, String>> columns = queryColumns(tableName);
            //生成代码
            GenUtils.generatorCode(table, columns, zip);
        }
        // TODO Mongon需要处理一下
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
