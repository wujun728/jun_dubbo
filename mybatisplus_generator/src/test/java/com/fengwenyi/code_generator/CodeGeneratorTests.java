package com.fengwenyi.code_generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.jun.plugin.code_generator.util.CommonUtils;

import org.junit.Test;

/**
 * @author Erwin Feng
 * @since 2020/5/29
 */
public class CodeGeneratorTests {

    @Test
    public void testMySQLCodeGenerator() {
        DbType dbType = DbType.MYSQL;
        String dbUrl = "jdbc:mysql://localhost:3306/mybatis-plus-example";
        String username = "root";
        String password = "123456";
        String driver = "com.mysql.cj.jdbc.Driver";
        // 表前缀，生成的实体类，不含前缀
        String [] tablePrefixes = {"t_"};
        // 表名，为空，生成所有的表
        String [] tableNames = {};
        // 字段前缀
        String [] fieldPrefixes = {};
        // 基础包名
        String packageName = "com.fengwenyi.mybatis_plus_example.db";
        CommonUtils.execute(dbType, dbUrl, username, password, driver, tablePrefixes, tableNames, packageName, fieldPrefixes);
    }

}
