package com.hoo.codegenerator.server.core.bean.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据源查询参数
 *
 * @author hank
 * @create 2020-12-31 下午5:05
 **/
@Data
public class DatasourceParams implements Serializable {
    /**
     * 数据源ID
     */
    private Serializable id;
    /**
     * PostgreSQL/ORACLE/DB2 schemaName
     */
    private String schemaName;
}
