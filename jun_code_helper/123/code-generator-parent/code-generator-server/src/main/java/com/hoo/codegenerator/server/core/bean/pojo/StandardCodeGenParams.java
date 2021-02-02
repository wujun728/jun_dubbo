package com.hoo.codegenerator.server.core.bean.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * 代码生成参数模型
 *
 * @author hank
 * @create 2020-01-10 上午10:08
 **/
@Data
public class StandardCodeGenParams {
    /**
     * 作者姓名
     */
    private String author;
    /**
     * 应属包名
     */
    @JsonProperty("package")
    private String pazkage;
    /**
     * 模块名称
     */
    private String moduleName;
    /**
     * 指定统一响应封装对象
     */
    private String resObj;
    /**
     * 指定分页封装对象
     */
    private String queryRequest;

    // 生成策略 - 待处理

    /**
     * sql - ddl 语句， 这里只提取 create table 语句
     */
    private String sqlDdl;

    /**
     * 数据库类型
     */
    private String dbType;
    /**
     * 表前缀，生成时屏蔽该前缀
     */
    private String[] tablePrefix;

    public boolean validate() throws IllegalArgumentException {
        if(StringUtils.isEmpty(sqlDdl) || StringUtils.isEmpty(pazkage)) {
            throw new IllegalArgumentException("请指定包名或输入准确的SQL语句");
        }
        if(dbType == null) {
            throw new IllegalArgumentException("请指定数据库类型");
        }
        if(StringUtils.isEmpty(resObj)) {
            resObj = "Res";
        }
        if(StringUtils.isEmpty(queryRequest)) {
            queryRequest = "QueryRequest";
        }
        return true;
    }

}
