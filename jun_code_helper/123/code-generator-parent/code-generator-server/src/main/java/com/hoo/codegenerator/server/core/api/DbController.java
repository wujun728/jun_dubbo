package com.hoo.codegenerator.server.core.api;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.util.DbUtils;
import com.hoo.codegenerator.server.common.model.Res;
import com.hoo.codegenerator.server.core.bean.entity.DbSource;
import com.hoo.codegenerator.server.core.bean.pojo.DatasourceParams;
import com.hoo.codegenerator.server.core.service.IDbSourceService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 数据库操作 Controller
 *
 * @author hank
 * @create 2020-12-31 下午5:03
 **/
@RestController
@RequestMapping("api/db")
public class DbController {

    @Resource private IDbSourceService dbSourceService;

    @GetMapping("/schemas")
    public Res schemas(DatasourceParams params) {
        if (StringUtils.isEmpty(params.getId())) {
            throw new RuntimeException("参数不合法");
        }
        DbSource dataSource = dbSourceService.get(params.getId());
        if (dataSource == null) {
            throw new RuntimeException("数据源不存在或已删除");
        }
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.getDbType(dataSource.getDbType()));
        dsc.setDriverName(dataSource.getDriverName());
        dsc.setUsername(dataSource.getUsername());
        dsc.setPassword(dataSource.getPassword());
        dsc.setUrl(dataSource.getUrl());
        dsc.setSchemaName(dataSource.getSchemaName());

        try {
            return Res.data(DbUtils.querySchemas(dsc));
        } catch (Exception e) {
            e.printStackTrace();
            return Res.error(e.getMessage());
        }
    }

    @GetMapping("tables")
    public Res tables(DatasourceParams params) {
        if (StringUtils.isEmpty(params.getId())) {
            return Res.data(null);
            // throw new RuntimeException("参数不合法");
        }
        DbSource dataSource = dbSourceService.get(params.getId());
        if (dataSource == null) {
            throw new RuntimeException("数据源不存在或已删除");
        }
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.getDbType(dataSource.getDbType()));
        dsc.setDriverName(dataSource.getDriverName());
        dsc.setUsername(dataSource.getUsername());
        dsc.setPassword(dataSource.getPassword());
        dsc.setUrl(dataSource.getUrl());
        dsc.setSchemaName(StringUtils.isEmpty(params.getSchemaName()) ? dataSource.getSchemaName() : params.getSchemaName());

        try {
            List<Map<String,Object>> result = DbUtils.queryTables(dsc);
            return Res.data(result);
        } catch (Exception e) {
            return Res.error(e.getMessage());
        }
    }

}
