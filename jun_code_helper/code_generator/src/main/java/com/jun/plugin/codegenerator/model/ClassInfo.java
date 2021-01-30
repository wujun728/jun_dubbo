package com.jun.plugin.codegenerator.model;

import java.util.List;

import lombok.Data;

@Data
public class ClassInfo {

    private String tableName;
    private String className;
	private String classComment;

	private List<FieldInfo> fieldList;


}