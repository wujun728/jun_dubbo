package com.hoo.codegenerator.server.core.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hoo.codegenerator.server.core.bean.dto.DbSourceDto;
import com.hoo.codegenerator.server.core.bean.entity.DbSource;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IDbSourceService {

    /**
     * 新增 - 数据源管理表
     */
    boolean add(DbSource entity);

    /**
     * 修改 - 数据源管理表
     */
    boolean update(DbSource entity);

    /**
     * 删除 - 数据源管理表
     */
    boolean delete(Serializable id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    boolean batchDelete(List<Long> ids);

    /**
     * 根据主键 获取记录
     */
    DbSource get(Serializable id);

    /**
     * 根据条件查询所有记录
     */
    List<DbSourceDto> findAll(Map< String, Object> params);
}
