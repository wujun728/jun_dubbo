package com.jun.plugin.codegenerator.util;


import java.io.IOException;

import com.jun.plugin.codegenerator.model.ClassInfo;

public class CodeGeneratorTool {

	/**
	 * process Table Into ClassInfo
	 *
	 * @param tableSql
	 * @return
	 */
	public static ClassInfo processTableIntoClassInfo(String tableSql) throws IOException {
		return TableParseUtil.processTableIntoClassInfo(tableSql);
	}

}