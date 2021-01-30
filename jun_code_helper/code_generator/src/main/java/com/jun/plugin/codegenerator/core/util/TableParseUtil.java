package com.jun.plugin.codegenerator.core.util;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLLimit;
import com.alibaba.druid.sql.ast.SQLOrderBy;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.expr.SQLBinaryOpExpr;
import com.alibaba.druid.sql.ast.expr.SQLBinaryOperator;
import com.alibaba.druid.sql.ast.expr.SQLInSubQueryExpr;
import com.alibaba.druid.sql.ast.statement.SQLColumnDefinition;
import com.alibaba.druid.sql.ast.statement.SQLExprTableSource;
import com.alibaba.druid.sql.ast.statement.SQLJoinTableSource;
import com.alibaba.druid.sql.ast.statement.SQLSelectGroupByClause;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectQuery;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.ast.statement.SQLSubqueryTableSource;
import com.alibaba.druid.sql.ast.statement.SQLTableSource;
import com.alibaba.druid.sql.ast.statement.SQLUnionQuery;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlDeleteStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlInsertStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlUpdateStatement;
import com.alibaba.druid.util.JdbcConstants;
import com.jun.plugin.codegenerator.core.exception.CodeGenerateException;
import com.jun.plugin.codegenerator.core.model.ClassInfo;
import com.jun.plugin.codegenerator.core.model.FieldInfo;

/**
 * @author xuxueli 2018-05-02 21:10:45
 */
public class TableParseUtil {

    /**
     * 解析建表SQL生成代码（model-dao-xml）
     *
     * @param tableSql
     * @return
     */
    public static ClassInfo processTableIntoClassInfo(String tableSql) throws IOException {
        if (tableSql==null || tableSql.trim().length()==0) {
            throw new CodeGenerateException("Table structure can not be empty.");
        }
        tableSql = tableSql.trim();

        // table Name
        String tableName = null;
        if (tableSql.contains("TABLE") && tableSql.contains("(")) {
            tableName = tableSql.substring(tableSql.indexOf("TABLE")+5, tableSql.indexOf("("));
        } else if (tableSql.contains("table") && tableSql.contains("(")) {
            tableName = tableSql.substring(tableSql.indexOf("table")+5, tableSql.indexOf("("));
        } else {
            throw new CodeGenerateException("Table structure anomaly.");
        }

        if (tableName.contains("`")) {
            tableName = tableName.substring(tableName.indexOf("`")+1, tableName.lastIndexOf("`"));
        }

        // class Name
        String className = StringUtils.upperCaseFirst(StringUtils.underlineToCamelCase(tableName));
        if (className.contains("_")) {
            className = className.replaceAll("_", "");
        }

        // class Comment
        String classComment = "";
        if (tableSql.contains("COMMENT=")) {
            String classCommentTmp = tableSql.substring(tableSql.lastIndexOf("COMMENT=")+8).trim();
            if (classCommentTmp.contains("'") || classCommentTmp.indexOf("'")!=classCommentTmp.lastIndexOf("'")) {
                classCommentTmp = classCommentTmp.substring(classCommentTmp.indexOf("'")+1, classCommentTmp.lastIndexOf("'"));
            }
            if (classCommentTmp!=null && classCommentTmp.trim().length()>0) {
                classComment = classCommentTmp;
            }
        }

        // field List
        List<FieldInfo> fieldList = new ArrayList<FieldInfo>();

        String fieldListTmp = tableSql.substring(tableSql.indexOf("(")+1, tableSql.lastIndexOf(")"));

        // replave "," by "，" in comment
        Matcher matcher = Pattern.compile("\\ COMMENT '(.*?)\\'").matcher(fieldListTmp);     // "\\{(.*?)\\}"
        while(matcher.find()){

            String commentTmp = matcher.group();
            commentTmp = commentTmp.replaceAll("\\ COMMENT '|\\'", "");      // "\\{|\\}"

            if (commentTmp.contains(",")) {
                String commentTmpFinal = commentTmp.replaceAll(",", "，");
                fieldListTmp = fieldListTmp.replace(commentTmp, commentTmpFinal);
            }
        }

        // remove invalid data
        for (Pattern pattern: Arrays.asList(
                Pattern.compile("[\\s]*PRIMARY KEY .*(\\),|\\))"),      // remove PRIMARY KEY
                Pattern.compile("[\\s]*UNIQUE KEY .*(\\),|\\))"),       // remove UNIQUE KEY
                Pattern.compile("[\\s]*KEY .*(\\),|\\))")               // remove KEY
        )) {
            Matcher patternMatcher = pattern.matcher(fieldListTmp);
            while(patternMatcher.find()){
                fieldListTmp = fieldListTmp.replace(patternMatcher.group(),"");
            }
        }

        String[] fieldLineList = fieldListTmp.split(",");
        if (fieldLineList.length > 0) {
            for (String columnLine :fieldLineList) {
                columnLine = columnLine.trim();		                                        // `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                if (columnLine.startsWith("`")){

                    // column Name
                    columnLine = columnLine.substring(1);			                        // userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                    String columnName = columnLine.substring(0, columnLine.indexOf("`"));	// userid

                    // field Name
                    String fieldName = StringUtils.lowerCaseFirst(StringUtils.underlineToCamelCase(columnName));
                    if (fieldName.contains("_")) {
                        fieldName = fieldName.replaceAll("_", "");
                    }

                    // field class
                    columnLine = columnLine.substring(columnLine.indexOf("`")+1).trim();	// int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                    String fieldClass = Object.class.getSimpleName();
                    if (columnLine.startsWith("int") || columnLine.startsWith("tinyint") || columnLine.startsWith("smallint")) {
                        fieldClass = Integer.TYPE.getSimpleName();
                    } else if (columnLine.startsWith("bigint")) {
                        fieldClass = Long.TYPE.getSimpleName();
                    } else if (columnLine.startsWith("float")) {
                        fieldClass = Float.TYPE.getSimpleName();
                    } else if (columnLine.startsWith("double")) {
                        fieldClass = Double.TYPE.getSimpleName();
                    } else if (columnLine.startsWith("datetime") || columnLine.startsWith("timestamp")) {
                        fieldClass = Date.class.getSimpleName();
                    } else if (columnLine.startsWith("varchar") || columnLine.startsWith("text") || columnLine.startsWith("char")) {
                        fieldClass = String.class.getSimpleName();
                    } else if (columnLine.startsWith("decimal")) {
                        fieldClass = BigDecimal.class.getSimpleName();
                    }

                    // field comment
                    String fieldComment = "";
                    if (columnLine.contains("COMMENT")) {
                        String commentTmp = fieldComment = columnLine.substring(columnLine.indexOf("COMMENT")+7).trim();	// '用户ID',
                        if (commentTmp.contains("'") || commentTmp.indexOf("'")!=commentTmp.lastIndexOf("'")) {
                            commentTmp = commentTmp.substring(commentTmp.indexOf("'")+1, commentTmp.lastIndexOf("'"));
                        }
                        fieldComment = commentTmp;
                    }

                    FieldInfo fieldInfo = new FieldInfo();
                    fieldInfo.setColumnName(columnName);
                    fieldInfo.setFieldName(fieldName);
                    fieldInfo.setFieldClass(fieldClass);
                    fieldInfo.setFieldComment(fieldComment);

                    fieldList.add(fieldInfo);
                }
            }
        }

        if (fieldList.size() < 1) {
            throw new CodeGenerateException("Table structure anomaly.");
        }

        ClassInfo codeJavaInfo = new ClassInfo();
        codeJavaInfo.setTableName(tableName);
        codeJavaInfo.setClassName(className);
        codeJavaInfo.setClassComment(classComment);
        codeJavaInfo.setFieldList(fieldList);

        return codeJavaInfo;
    }
    

    public static ClassInfo processTableIntoClassInfoDruid(String sql) throws IOException {
       DbType dbType = JdbcConstants.MYSQL;
       ClassInfo codeJavaInfo = new ClassInfo();
       //格式化输出
       String result = SQLUtils.format(sql, dbType);
       System.out.println(result); // 缺省大写格式
       List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);
       
       //解析出的独立语句的个数
       System.err.println("size is:" + stmtList.size());
       for (int i = 0; i < stmtList.size(); i++) {
           SQLStatement stmt = stmtList.get(i);
           if(stmt instanceof SQLSelectStatement) {
               if(stmt instanceof MySqlInsertStatement) {
                   System.err.println("carete ------------------------------------------------------------------------------- ");
                   MySqlCreateTableStatement statement= (MySqlCreateTableStatement) stmt;
                   System.out.println("SQL : " + stmt.toString());
                   System.out.println("getTableName : " + statement.getTableName());
                   System.out.println("getComment : " + statement.getComment());
                   System.out.println("getPrimaryKeyNames : " + statement.getPrimaryKeyNames());
                   System.out.println("getColumnNames : " + statement.getColumnNames(false));
                   System.out.println("getColumnComments : " + statement.getColumnComments());
                       
                   // table Name
                   String tableName = statement.getTableName().toString();
                   codeJavaInfo.setTableName(tableName);
                   // class Name
                   String className = StringUtils.upperCaseFirst(StringUtils.underlineToCamelCase(tableName));
                   if (className.contains("_")) {
                       className = className.replaceAll("_", "");
                   }
                   codeJavaInfo.setClassName(className);
                   String classComment = statement.getComment().toString();
                   codeJavaInfo.setClassComment(classComment);
                   codeJavaInfo.setFieldList(getFieldLis(statement.getColumnDefinitions()));
               }
           }
       }
       return codeJavaInfo;
    }
    public static List<FieldInfo> getFieldLis(List<SQLColumnDefinition> fieldLineList) {
        // field List
        List<FieldInfo> fieldList = new ArrayList<FieldInfo>();
        if (fieldLineList.size() > 0) {
            for (SQLColumnDefinition columnLine :fieldLineList) {
                // column Name
                String columnName = columnLine.getColumnName();   // userid

                // field Name
                String fieldName = StringUtils.lowerCaseFirst(StringUtils.underlineToCamelCase(columnName));
                if (fieldName.contains("_")) {
                    fieldName = fieldName.replaceAll("_", "");
                }
                String fieldType = columnLine.getDataType().getName();
                String fieldClass = Object.class.getSimpleName();
                if (fieldType.startsWith("int") || fieldType.startsWith("tinyint") || fieldType.startsWith("smallint")) {
                    fieldClass = Integer.TYPE.getSimpleName();
                } else if (fieldType.startsWith("bigint")) {
                    fieldClass = Long.TYPE.getSimpleName();
                } else if (fieldType.startsWith("float")) {
                    fieldClass = Float.TYPE.getSimpleName();
                } else if (fieldType.startsWith("double")) {
                    fieldClass = Double.TYPE.getSimpleName();
                } else if (fieldType.startsWith("datetime") || fieldType.startsWith("timestamp")) {
                    fieldClass = Date.class.getSimpleName();
                } else if (fieldType.startsWith("varchar") || fieldType.startsWith("text") || fieldType.startsWith("char")) {
                    fieldClass = String.class.getSimpleName();
                } else if (fieldType.startsWith("decimal")) {
                    fieldClass = BigDecimal.class.getSimpleName();
                }
                // field comment
                String fieldComment = columnLine.getComment().toString();
                String fieldLength = columnLine.getDataType().getArguments().get(0).toString();
                boolean isAutoIncrement = columnLine.isAutoIncrement();
                boolean isPrimaryKey = columnLine.isPrimaryKey();

                FieldInfo fieldInfo = new FieldInfo();
                fieldInfo.setColumnName(columnName);
                fieldInfo.setFieldName(fieldName);
                fieldInfo.setFieldClass(fieldClass);
                fieldInfo.setFieldComment(fieldComment);
                fieldInfo.setFieldLength(fieldLength);
                fieldList.add(fieldInfo);
            }
        }

        if (fieldList.size() < 1) {
            throw new CodeGenerateException("Table structure anomaly.");
        }
        return fieldList;
    }
    
 
    
    public static void main(String[] args) {
         String sql1 = "update tabes12321 set name = 'x' where id < 100 limit 10;";
         String sql2 = "insert into T_UPGRADERECORD (ID, CASEID, CASENAME)\n" + 
             "values (12245, 50047319, '楠?--123-base(2)-base');";
         String sql3 = "delete from tablename1 where id = 10;";
         String sql4 = "CREATE TABLE `userinfo` (\n" + 
              "  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',\n" + 
              "  `username` varchar(255) NOT NULL COMMENT '用户名',\n" + 
              "  `addtime` datetime NOT NULL COMMENT '创建时间',\n" + 
              "  PRIMARY KEY (`user_id`)\n" + 
              ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息';";
 
        String sql = "select user,userid from emp_table;";
        DbType dbType = JdbcConstants.MYSQL;
        sql=sql+sql1+sql2+sql3+sql4;
        //格式化输出
        String result = SQLUtils.format(sql, dbType);
        System.out.println(result); // 缺省大写格式
        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);
 
        //解析出的独立语句的个数
        System.err.println("size is:" + stmtList.size());
        for (int i = 0; i < stmtList.size(); i++) {
            SQLStatement stmt = stmtList.get(i);
            if(stmt instanceof SQLSelectStatement) {
                System.err.println("select ---------------------------------------------- ");
                SQLSelectStatement statement= (SQLSelectStatement) stmt;
                SQLSelectQuery sqlSelectQuery= statement.getSelect().getQuery();
                // 非union的查询语句
                if (sqlSelectQuery instanceof SQLSelectQueryBlock) {
                    SQLSelectQueryBlock sqlSelectQueryBlock = (SQLSelectQueryBlock) sqlSelectQuery;
                    // 获取字段列表
                    List<SQLSelectItem> selectItems         = sqlSelectQueryBlock.getSelectList();
                    selectItems.forEach(x -> {
                        System.out.println(" Tables getSelectList : " +x);
                    });
                    // 获取表
                    SQLTableSource table = sqlSelectQueryBlock.getFrom();
                    System.out.println(" Tables : " + table);
                    if (table instanceof SQLExprTableSource) {
                    // join多表
                    } else if (table instanceof SQLJoinTableSource) {
                    // 子查询作为表
                    } else if (table instanceof SQLSubqueryTableSource) {
                    }
                    // 获取where条件
                    SQLExpr where = sqlSelectQueryBlock.getWhere();
                    // 如果是二元表达式
                    if (where instanceof SQLBinaryOpExpr) {
                        SQLBinaryOpExpr   sqlBinaryOpExpr = (SQLBinaryOpExpr) where;
                        SQLExpr           left            = sqlBinaryOpExpr.getLeft();
                        SQLBinaryOperator operator        = sqlBinaryOpExpr.getOperator();
                        SQLExpr           right           = sqlBinaryOpExpr.getRight();
                    // 如果是子查询
                    } else if (where instanceof SQLInSubQueryExpr) {
                        SQLInSubQueryExpr sqlInSubQueryExpr = (SQLInSubQueryExpr) where;
                    }
                    // 获取分组
                    SQLSelectGroupByClause groupBy = sqlSelectQueryBlock.getGroupBy();
                    // 获取排序
                    SQLOrderBy orderBy = sqlSelectQueryBlock.getOrderBy();
                    // 获取分页
                    SQLLimit limit = sqlSelectQueryBlock.getLimit();
                // union的查询语句
                } else if (sqlSelectQuery instanceof SQLUnionQuery) {
                    // union处理---------------------
                }
            }else if(stmt instanceof MySqlCreateTableStatement) {
                System.err.println("carete ------------------------------------------------------------------------------- ");
                MySqlCreateTableStatement statement= (MySqlCreateTableStatement) stmt;
                System.out.println("SQL : " + stmt.toString());
                System.out.println("getTableName : " + statement.getTableName());
                System.out.println("getComment : " + statement.getComment());
                System.out.println("getPrimaryKeyNames : " + statement.getPrimaryKeyNames());
                System.out.println("getColumnNames : " + statement.getColumnNames(false));
                System.out.println("getColumnComments : " + statement.getColumnComments());
                System.out.println("getColumnName : " + statement.getColumnDefinitions().get(0).getColumnName());
                System.out.println("getComment : " + statement.getColumnDefinitions().get(0).getComment());
                System.out.println("isAutoIncrement : " + statement.getColumnDefinitions().get(0).isAutoIncrement());
                System.out.println("isPrimaryKey : " + statement.getColumnDefinitions().get(0).isPrimaryKey());
                System.out.println("getDataType : " + statement.getColumnDefinitions().get(0).getDataType().getName());
                System.out.println("getDataType-getArguments : " + statement.getColumnDefinitions().get(0).getDataType().getArguments());
            }else  if(stmt instanceof MySqlDeleteStatement) {
                System.err.println("delete ------------------------------------------------------------------------------- ");
                MySqlDeleteStatement statement= (MySqlDeleteStatement) stmt;
                System.out.println("SQL : " + stmt.toString());
                System.out.println("getTableName : " + statement.getTableName());
                System.out.println("getWhere : " + statement.getWhere());
                System.out.println("getUsing : " + statement.getUsing());
                System.out.println("getWith : " + statement.getWith());
            }else  if(stmt instanceof MySqlUpdateStatement) {
                MySqlUpdateStatement statement= (MySqlUpdateStatement) stmt;
                System.err.println("update ------------------------------------------------------------------------------- ");
                System.out.println("SQL : " + stmt.toString());
                System.out.println("getTableName : " + statement.getTableName());
                System.out.println("getHints : " + statement.getHints());
                System.out.println("getItems : " + statement.getItems());
                System.out.println("getLimit : " + statement.getLimit());
            }else  if(stmt instanceof MySqlInsertStatement) {
                MySqlInsertStatement statement= (MySqlInsertStatement) stmt;
                System.err.println("update ------------------------------------------------------------------------------- ");
                System.out.println("SQL : " + stmt.toString());
                System.out.println("getTableName : " + statement.getTableName());
                System.out.println("getColumns : " + statement.getColumns());
                System.out.println("getValues : " + statement.getValues());
                System.out.println("getColumnsString : " + statement.getColumnsString());
            }
        }
    } 

}
