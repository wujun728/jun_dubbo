package com.jun.plugin.code.meta;

import java.util.logging.Logger;

import com.jun.plugin.code.meta.build.TemplateBuilder;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/14 23:43
 *****/
public class Main {

	public static Logger log = Logger.getLogger(Main.class.toString());
    public static void main(String[] args) {
        //调用该方法即可
    	log.info("开始生成代码");
        TemplateBuilder.builder();
        log.info("代码生成完成");
    }
}
