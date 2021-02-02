package com.freeter.utils;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import freemarker.template.Configuration;
import freemarker.template.Template;

/** 
* @author  作者  freeter E-mail: 171998110@qq.com
* @date 创建时间：2018年7月9日 上午10:30:15 
* @version 1.0 
* @parameter  
* @since  
* @return  
* 
* FreemarkerUtil
*/
public class FreemarkerUtils {
	
	/**
	 * 通过文件名加载模版
	 * 
	 * @param ftlName
	 */
	public static Template getTemplate(String ftlName) throws Exception {
		try {
			 
			Configuration cfg = new Configuration(Configuration.getVersion());
			cfg.setEncoding(Locale.CHINA, "utf-8");
			File file = new File(getClassResources()); // 这里表示从jar同级目录加载
			if (!file.exists()) { // 如果同级目录没有，则去config下面找
				file = new File("config");
			}
			if (!file.exists()) {
				file =new File("");
			}
			cfg.setDirectoryForTemplateLoading(file);
		 
			Template temp = cfg.getTemplate(ftlName);
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getClassResources() {
		String path = (String.valueOf(Thread.currentThread().getContextClassLoader().getResource("")))
				.replaceAll("file:/", "").replaceAll("%20", " ").trim();
		if (path.indexOf(":") != 1) {
			path = File.separator + path;
		}
		return path;
	}
	
}
