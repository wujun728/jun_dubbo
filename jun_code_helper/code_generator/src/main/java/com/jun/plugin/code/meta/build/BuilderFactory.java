package com.jun.plugin.code.meta.build;

import freemarker.template.Template;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/****
 * @Author:shenkunlin
 * @Description:构建对象的工厂
 * @Date 2019/6/14 23:21
 *****/
public class BuilderFactory {

	/***
	 * 构建Controller
	 * 
	 * @param modelMap
	 */
	public static void builder(Map<String, Object> modelMap, // 数据模型
			String templatePath, // 模板路径
			String templateFile, // 模板文件
			String storePath, // 存储路径
			String suffix) { // 生成文件后缀名字
		try {
			// 获取模板对象
			Template template = TemplateUtil.loadTemplate(BuilderFactory.class.getResource(templatePath).getPath(),
					templateFile);

			// 创建文件夹
			String path = TemplateBuilder.PROJECT_PATH + storePath.replace(".", "/");
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}

			// 创建文件
			TemplateUtil.writer(template, modelMap, path + "/" + modelMap.get("Table") + suffix);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void builder(Map<String, Object> modelMap, String templatePath, String templateFile) {
		String templateName = templateFile.substring(0, templateFile.lastIndexOf("."));
		String storePath = TemplateBuilder.PACKAGE_BASE + "." + templateName; // 存储路径
		String suffix = templateName + ".java"; // 生成文件后缀名字
		BuilderFactory.builder(modelMap, templatePath, templateFile, storePath, suffix);
	}

	/***
	 * 构建 
	 * @param modelMap
	 */
	public static void batchBuilder(Map<String, Object> modelMap) {
		// 生成Controller层文件
		BuilderFactory.builder(modelMap, "/template_ds/controller", "Controller.java");
		// 生成Dao层文件
		BuilderFactory.builder(modelMap, "/template_ds/dao", "Mapper.java");
		// 生成Feign层文件
		BuilderFactory.builder(modelMap, "/template_ds/feign", "Feign.java");
		// 生成Pojo层文件
		BuilderFactory.builder(modelMap, "/template_ds/pojo", "Pojo.java");
		// 生成Service层文件
		BuilderFactory.builder(modelMap, "/template_ds/service", "Service.java");
		// 生成ServiceImpl层文件
		BuilderFactory.builder(modelMap, "/template_ds/service/impl", "ServiceImpl.java");

	}

}
