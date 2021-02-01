package com.jun.plugin.code.meta.build;

import java.util.Map;

/*****
 *  生成Swagger
 ****/
public class SwaggerBuilder {

    /***
     * ServiceImpl构建
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        //swagger的文件名字
        modelMap.put("Table","swagger");

        //生成ServiceImpl层文件
        BuilderFactory.builder(modelMap,TemplateBuilder.TEMPLATE_NAME+
                "/swagger",
                "swagger.json",
                TemplateBuilder.SWAGGERUI_PATH,
                ".json");
    }
}
