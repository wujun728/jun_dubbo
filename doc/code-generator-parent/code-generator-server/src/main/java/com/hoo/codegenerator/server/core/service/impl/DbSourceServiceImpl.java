package com.hoo.codegenerator.server.core.service.impl;

import com.hoo.codegenerator.server.core.bean.dto.DbSourceDto;
import com.hoo.codegenerator.server.core.bean.entity.DbSource;
import com.hoo.codegenerator.server.core.service.IDbSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 数据源管理表 服务实现类
 *
 * @author hank
 * @create 2020-12-31 上午11:14
 **/

@Service
public class DbSourceServiceImpl implements IDbSourceService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean add(DbSource entity){
        return jdbcTemplate.update("INSERT INTO t_db_source(connection_name, db_type, driver_name, schema_name, username, password, url) VALUES(?, ?, ?, ?, ?, ?, ?)", entity.getConnectionName(), entity.getDbType(), entity.getDriverName(), entity.getSchemaName(), entity.getUsername(), entity.getPassword(), entity.getUrl()) > 0;
    }

    @Override
    public boolean update(DbSource entity) {
        DbSource temp = this.get(entity.getId());
        if (temp == null) {
            throw new RuntimeException("原数据不存在或已删除");
        }
        if (StringUtils.isEmpty(entity.getPassword())) {
            entity.setPassword(temp.getPassword());
        }
        return jdbcTemplate.update("UPDATE t_db_source SET id = ? ,connection_name = ? ,db_type = ? ,driver_name = ? ,schema_name = ? ,username = ? ,password = ? ,url = ?  WHERE id = ?", entity.getId(), entity.getConnectionName(), entity.getDbType(), entity.getDriverName(), entity.getSchemaName(), entity.getUsername(), entity.getPassword(), entity.getUrl(), entity.getId()) > 0;
    }

    @Override
    public boolean delete(Serializable id){
        return id == null ? false : jdbcTemplate.update("DELETE FROM t_db_source WHERE id = ?", id) > 0;
    }

    @Override
    public boolean batchDelete(List<Long> ids) {
        String sql="DELETE FROM t_db_source WHERE id = ?";
        List< Object[] > batchArgs = new ArrayList<>();
        for(Object id : ids) {
            batchArgs.add(new Object[]{id});
        }
        return jdbcTemplate.batchUpdate(sql, batchArgs).length == ids.size();
    }

    @Override
    public DbSource get(Serializable id) {
        if (id == null || StringUtils.isEmpty(id)) {
            return null;
        }
        List<DbSource> list = jdbcTemplate.query("SELECT id, connection_name, db_type, driver_name, schema_name, username, password, url FROM t_db_source WHERE id = ? ", new Object[]{ id }, new BeanPropertyRowMapper<DbSource>(DbSource.class));
        if(list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<DbSourceDto> findAll(Map< String, Object> params) {
        StringBuffer where = new StringBuffer("WHERE 1=1 ");
        List<Object> args = new ArrayList<>();
        if (params.get("dbType") != null) {
            where.append(" AND db_type = ?");
            args.add(params.get("dbType"));
        }
        if (params.get("searchWord") != null) {
            // connection_name username url
            where.append(" AND (connection_name LIKE ? OR username LIKE ? OR url LIKE ?)");
            args.add("%" + params.get("searchWord") + "%");
            args.add("%" + params.get("searchWord") + "%");
            args.add("%" + params.get("searchWord") + "%");
        }
        List<DbSourceDto> list = jdbcTemplate.query("SELECT id, connection_name, db_type, driver_name, schema_name, username, password, url FROM t_db_source "  + where.toString(), args.toArray(), new BeanPropertyRowMapper<>(DbSourceDto.class));
        if(list != null && list.size() > 0) {
            return list;
        }else{
            return new ArrayList<>();
        }
    }
}
