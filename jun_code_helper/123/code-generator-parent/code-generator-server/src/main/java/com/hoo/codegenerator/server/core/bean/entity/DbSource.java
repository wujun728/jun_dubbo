package com.hoo.codegenerator.server.core.bean.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 数据源管理表
 * @author hank
 * @date 2020-12-31 11:05:10
 */
@Data
public class DbSource implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 连接名称
     */
    private String connectionName;
    /**
     * 数据库类型[枚举值]
     */
    private String dbType;
    /**
     * 驱动信息
     */
    private String driverName;
    /**
     * Schame 模式
     */
    private String schemaName;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密钥
     */
    private String password;
    /**
     * 连接地址
     */
    private String url;
}