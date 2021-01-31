package com.jun.plugin.code.meta;

import java.io.IOException;
import java.util.logging.Logger;

import com.jun.plugin.code.meta.build.TemplateBuilder;

public class Main {

	public static Logger log = Logger.getLogger(Main.class.toString());
    public static void main(String[] args) throws IOException {
        //调用该方法即可
    	log.info("开始生成代码");
        TemplateBuilder.builder();
        //打开文件夹
        Runtime.getRuntime().exec("cmd.exe /c start "+TemplateBuilder.PROJECT_PATH + TemplateBuilder.PACKAGE_BASE.replace(".", "/"));
        log.info("代码生成完成");
    }
}
