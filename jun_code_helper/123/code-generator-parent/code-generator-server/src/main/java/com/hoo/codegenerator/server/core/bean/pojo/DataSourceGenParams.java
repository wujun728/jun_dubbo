package com.hoo.codegenerator.server.core.bean.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据源生成参数
 *
 * @author hank
 * @create 2020-12-31 下午8:52
 **/
@Data
public class DataSourceGenParams extends StandardCodeGenParams {

    /**
     * 待生成表集合
     */
    private String[] tables;
    /**
     * schema
     */
    private String schemaName;
    /**
     * 数据源ID
     */
    private Serializable datasourceId;

}
