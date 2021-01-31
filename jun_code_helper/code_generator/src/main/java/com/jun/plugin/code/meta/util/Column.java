package com.jun.plugin.code.meta.util;

import lombok.Data;

/**
 * 用于生成代码的Columb对象.对应数据库表column
 * @author Wujun
 * @email badqiu(a)gmail.com
 */
@Data
public class Column {
	private String columnName;
    private String fieldName;
    private String fieldClass;
    private String fieldComment;
    private String fieldLength;
    
	private String enumString = "";
	private String javaType;
	private String columnAlias;
	private String asType;	
	private String enumClassName;
	private String hibernateValidatorExprssion; 
	
	/**
	 * Reference to the containing table
	 */
	private Table _table;

	/**
	 * The java.sql.Types type
	 */
	private int _sqlType;

	/**
	 * The sql typename. provided by JDBC driver
	 */
	private String _sqlTypeName;

	/**
	 * The name of the column
	 */
	private String _sqlName;

	/**
	 * True if the column is a primary key
	 */
	private boolean _isPk;

	/**
	 * True if the column is a foreign key
	 */
	private boolean _isFk;

	/**
	 * @todo-javadoc Describe the column
	 */
	private int _size;

	/**
	 * @todo-javadoc Describe the column
	 */
	private int _decimalDigits;

	/**
	 * True if the column is nullable
	 */
	private boolean _isNullable;

	/**
	 * True if the column is indexed
	 */
	private boolean _isIndexed;

	/**
	 * True if the column is unique
	 */
	private boolean _isUnique;

	/**
	 * Null if the DB reports no default value
	 */
	private String _defaultValue;
	
	/**
	 * The comments of column
	 */
	private String _remarks;
			
	 
	
}
