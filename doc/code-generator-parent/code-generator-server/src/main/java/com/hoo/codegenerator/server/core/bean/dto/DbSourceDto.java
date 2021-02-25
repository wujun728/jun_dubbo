package com.hoo.codegenerator.server.core.bean.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hoo.codegenerator.server.core.bean.entity.DbSource;
import lombok.Data;

/**
 * 数据源管理DTO类
 *
 * @author hank
 * @create 2020-12-31 上午11:07
 **/
@Data
public class DbSourceDto extends DbSource {
    /**
     * 安全脱敏处理 密钥
     */
    @JsonIgnore
    private String password;
}
