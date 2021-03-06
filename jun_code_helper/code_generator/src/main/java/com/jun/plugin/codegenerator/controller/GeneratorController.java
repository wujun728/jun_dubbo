package com.jun.plugin.codegenerator.controller;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jun.plugin.codegenerator.model.ClassInfo;
import com.jun.plugin.codegenerator.model.ParamInfo;
import com.jun.plugin.codegenerator.model.ReturnInfo;
import com.jun.plugin.codegenerator.service.GeneratorService;
import com.jun.plugin.codegenerator.util.MapUtil;
import com.jun.plugin.codegenerator.util.TableParseUtil;
import com.jun.plugin.codegenerator.util.ValueUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 代码生成控制器
 * @author zhengkai.blog.csdn.net
 */
@Controller
@Slf4j
public class GeneratorController {
    @Autowired
    private ValueUtil valueUtil;

    @Autowired
    private GeneratorService generatorService;

    @GetMapping("/")
    public ModelAndView defaultPage() {
        return new ModelAndView("index").addObject("value",valueUtil);
    }
    @GetMapping("/index")
    public ModelAndView indexPage() {
        return new ModelAndView("index").addObject("value",valueUtil);
    }
    @GetMapping("/main")
    public ModelAndView mainPage() {
        return new ModelAndView("main").addObject("value",valueUtil);
    }

    @RequestMapping("/template/all")
    @ResponseBody
    public ReturnInfo getAllTemplates() throws Exception {
        String templates = generatorService.getTemplateConfig();
        return ReturnInfo.ok().put("templates",templates);
    }
    @PostMapping("/code/generate")
    @ResponseBody
    public ReturnInfo generateCode(@RequestBody ParamInfo paramInfo) throws Exception {
        //log.info(JSON.toJSONString(paramInfo.getOptions()));
        if (StringUtils.isEmpty(paramInfo.getTableSql())) {
            return ReturnInfo.error("表结构信息为空");
        }

        //1.Parse Table Structure 表结构解析
        ClassInfo classInfo = null;
        String dataType = MapUtil.getString(paramInfo.getOptions(),"dataType");
        if ("sql".equals(dataType)||dataType==null) {
            classInfo = TableParseUtil.processTableIntoClassInfo(paramInfo);
        }else if ("json".equals(dataType)) {
            //JSON模式：parse field from json string
            classInfo = TableParseUtil.processJsonToClassInfo(paramInfo);
            //INSERT SQL模式：parse field from insert sql
        } else if ("insert-sql".equals(dataType)) {
            classInfo = TableParseUtil.processInsertSqlToClassInfo(paramInfo);
            //正则表达式模式（非完善版本）：parse sql by regex
        } else if ("sql-regex".equals(dataType)) {
            classInfo = TableParseUtil.processTableToClassInfoByRegex(paramInfo);
            //默认模式：default parse sql by java
        }

        //2.Set the params 设置表格参数

        paramInfo.getOptions().put("classInfo", classInfo);
        paramInfo.getOptions().put("tableName", classInfo == null ? System.currentTimeMillis() : classInfo.getTableName());

        //log the generated table and filed size记录解析了什么表，有多少个字段
        //log.info("generated table :{} , size :{}",classInfo.getTableName(),(classInfo.getFieldList() == null ? "" : classInfo.getFieldList().size()));

        //3.generate the code by freemarker templates with parameters . Freemarker根据参数和模板生成代码
        Map<String, String> result = generatorService.getResultByParams(paramInfo.getOptions());
        log.info("table:{} - time:{} ", MapUtil.getString(result,"tableName"),new Date());
        return ReturnInfo.ok().put("outputJson",result);
    }

}
