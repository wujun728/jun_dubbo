package com.jun.plugin.codegenerator.core;


import java.io.IOException;

import com.jun.plugin.codegenerator.core.model.ClassInfo;
import com.jun.plugin.codegenerator.core.util.TableParseUtil;

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