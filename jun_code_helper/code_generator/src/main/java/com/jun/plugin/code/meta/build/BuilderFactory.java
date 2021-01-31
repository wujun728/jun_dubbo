package com.jun.plugin.code.meta.build;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import freemarker.template.Template;

/****
 * @author Wujun
 * @Description:构建对象的工厂
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
	/***
	 * 构建 
	 * @param modelMap
	 */
	public static void batchBuilderV2(Map<String, Object> modelMap) {
		List<Map<String,Object>> srcFiles = new ArrayList<Map<String,Object>>();
		getFile(TemplateBuilder.TEMPLATE_PATH,srcFiles);
		
		for(int i = 0; i < srcFiles.size(); i++) {
            HashMap<String, Object> m = (HashMap<String, Object>) srcFiles.get(i);
            Set<String> set = m.keySet();
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                if(key.contains(".json")) {
                	continue;
                }
                String templateFileName = key;
//                String templateFileNameSuffix = key.substring(key.lastIndexOf("."), key.length());
                String templateFileNamePrefix = key.substring(0,key.lastIndexOf("."));
                String templateFilePathAndName = String.valueOf(m.get(key));
                String templateFilePath = templateFilePathAndName.replace(templateFileName, "");
                try {
					// 获取模板对象
					Template template = TemplateUtil.loadTemplate(templateFilePath, templateFileName);
					
					// 创建文件夹
					String path = TemplateBuilder.PROJECT_PATH+"/" + TemplateBuilder.PACKAGE_BASE.replace(".", "/")+"/"+templateFileNamePrefix.toLowerCase();
					File file = new File(path);
					if (!file.exists()) {
						file.mkdirs();
					}

					// 创建文件
					TemplateUtil.writer(template, modelMap, path + "/" + modelMap.get("Table") + ".java");
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
		}
	}
	
	public static void main(String[] args) {
        // This is the path where the file's name you want to take.
        String path = "D:\\workspace\\github\\jun_code_generator\\jun_code_helper\\code_generator\\src\\main\\resources\\template_ds";
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        getFile(path,list);
    }
	
	 private static void getFile(String path,List<Map<String,Object>> list) {
	        File file = new File(path);
	        File[] array = file.listFiles();
	        for (int i = 0; i < array.length; i++) {
	            if (array[i].isFile()) {
	            	Map<String,Object> map = new HashMap<String,Object>();
	                // only take file name
	                System.out.println("^^^^^" + array[i].getName());
	                // take file path and name
	                System.out.println("*****" + array[i].getPath());
	                map.put(array[i].getName(), array[i].getPath());
	                list.add(map);
	            } else if (array[i].isDirectory()) {
	                getFile(array[i].getPath(),list);
	            }
	        }
	    }
}
