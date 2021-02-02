package com.yuxuntoo.www.generator.entity;

/**
 * 列的属性
 * 
 * @author Camel
 * @email 503709917@qq.com
 */
public class ColumnEntity {
	/**
	 * 	列名
	 */
    private String columnName;
	/**
	 *	列名类型，大写
	 */
    private String capitalizeDataType;
	/**
	 * 列明类型
	 */
	private String dataType;
	/**
	 *	列名备注
	 */
    private String comments;

	/**
	 *	属性名称(第一个字母大写)，如：create_time => CreateTime
	 */
    private String attrName;
	/**
	 * 属性名称(第一个字母小写)，如：create_time => createTime
	 */
	private String attrname;
	/**
	 *	属性类型
	 */
    private String attrType;
	/**
	 *	auto_increment
	 */
    private String extra;
	/**
	 * 是否主键信息 pri 为主键
	 */
	private String pk;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getCapitalizeDataType() {
		return capitalizeDataType;
	}

	public void setCapitalizeDataType(String capitalizeDataType) {
		this.capitalizeDataType = capitalizeDataType;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrname() {
		return attrname;
	}

	public void setAttrname(String attrname) {
		this.attrname = attrname;
	}

	public String getAttrType() {
		return attrType;
	}

	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}
}
