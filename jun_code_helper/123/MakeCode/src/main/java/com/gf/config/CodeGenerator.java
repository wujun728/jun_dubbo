package com.gf.config;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CodeGenerator {

    public static boolean makeCode(String author, String ip, String port,
                                   String schema, String userName, String pwd,
                                   String packageName, String productName, String[] tables) throws Exception{
        final String projectPath = productName;
        delete(projectPath, true);

        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setOpen(false);
        gc.setAuthor(author);


        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType( DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://"+ip+":"+port+"/"+schema+"?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowMultiQueries=true&serverTimezone=GMT");
//        dsc.setUrl("jdbc:mysql://10.58.237.11:3306/rsbi?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowMultiQueries=true&serverTimezone=GMT");
        dsc.setUsername(userName);
        dsc.setPassword(pwd);
        mpg.setDataSource(dsc);

        // 包配置
        String parantPath = packageName;
        PackageConfig pc = new PackageConfig();
        pc.setParent(parantPath);
        pc.setController( "controller");
        pc.setEntity( "entity" );
        //pc.setModuleName("test");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //此处可以修改为您的表前缀
//        strategy.setTablePrefix(new String[] { "tb_"});
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表
//        strategy.setInclude(new String[] {"dept","etl_dataset","dept_datasource"});
        strategy.setInclude(tables);
        // 排除生成的表
        //strategy.setExclude(new String[]{"test"});
        strategy.setEntityLombokModel( true );

        mpg.setStrategy(strategy);

        // 执行生成
        mpg.execute();


        addStartApp(gc.getOutputDir() + "/" + parantPath.replaceAll("\\.", "/"), parantPath, productName);
        addYaml(gc.getOutputDir().replaceAll("java", "resources"), ip, port, schema, userName, pwd);
        addPom(projectPath, packageName, productName);
        addSettings(projectPath + "/maven_settings");
        addSwagger(gc.getOutputDir() + "/" + parantPath.replaceAll("\\.", "/") + "/" + "config",
                parantPath + ".config");
        addJava(gc.getOutputDir() + "/" + parantPath.replaceAll("\\.", "/") + "/" + "util", parantPath + ".util");

        return true;
    }


    public static void main(String[] args) throws Exception {
        AutoGenerator mpg = new AutoGenerator();

        String author = "monkey";
        String ip = "127.0.0.1";
        String port = "3306";
        String schema = "rsbi";
        String userName = "root";
        String pwd = "123456";
        String[] tables = new String[] {"sc_role","sc_login_user"   };
        String packageName = "com.ruisitech.mas";
        String productName = "mas";

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
        String projectPath = "f:/big2/springboot-mybatis";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setOpen(false);
        gc.setAuthor(author);


        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType( DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://"+ip+":"+port+"/"+schema+"?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowMultiQueries=true&serverTimezone=GMT");
//        dsc.setUrl("jdbc:mysql://10.58.237.11:3306/rsbi?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowMultiQueries=true&serverTimezone=GMT");
        dsc.setUsername(userName);
        dsc.setPassword(pwd);
        mpg.setDataSource(dsc);

        // 包配置
        String parantPath = packageName;
        PackageConfig pc = new PackageConfig();
        pc.setParent(parantPath);
        pc.setController( "controller");
        pc.setEntity( "entity" );
        //pc.setModuleName("test");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //此处可以修改为您的表前缀
//        strategy.setTablePrefix(new String[] { "tb_"});
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表
        strategy.setInclude(tables);
        // 排除生成的表
        //strategy.setExclude(new String[]{"test"});
        strategy.setEntityLombokModel( true );

        mpg.setStrategy(strategy);

        delete(projectPath, false);

        // 执行生成
        mpg.execute();


        addStartApp(gc.getOutputDir() + "/" + parantPath.replaceAll("\\.", "/"), parantPath, productName);
        addYaml(gc.getOutputDir().replaceAll("java", "resources"), ip, port, schema, userName, pwd);
        addPom(projectPath, packageName, productName);
        addSettings(projectPath + "/maven_settings");
        addSwagger(gc.getOutputDir() + "/" + parantPath.replaceAll("\\.", "/") + "/" + "config",
                parantPath + ".config");
        addJava(gc.getOutputDir() + "/" + parantPath.replaceAll("\\.", "/") + "/" + "util",
                parantPath + ".util");
    }

    public static void  delete(String projectPath, boolean flag) {
        File file = new File(projectPath);
        String[] list = file.list();

        if (list != null && list.length > 0) {
            for (String str : list) {
                String path = projectPath + "/" + str;
                if (new File(path).isFile()) {
                    if (!path.contains(".idea") || flag){
                        System.out.println("删除目录：" + path);
                        new File(path).delete();
                    }
                } else {
                    delete(path, flag);
                    new File(path).delete();
                }
            }
        }


    }


    public static void addStartApp (String path, String packageName, String productName) throws Exception {

        System.out.println("addStartApp=" + path);
        String target = "/doc/SpringbootMybatisApplication.java";
        InputStream resourceAsStream = CodeGenerator.class.getResourceAsStream(target);
        productName = productName.substring(productName.lastIndexOf("/") + 1);
        String appName = productName.substring(0, 1).toUpperCase() + productName.substring(1);
        FileOutputStream fos = new FileOutputStream(path + "/" + appName + "Application.java");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);

        dos.write(("package " + packageName + ";\n").getBytes());
        int temp;

        while((temp=resourceAsStream.read()) != -1){
            dos.write(temp);
        }
        dos.flush();
        fos.close();
        bos.close();
        dos.close();

        FileInputStream fis = new FileInputStream(path + "/" + appName + "Application.java");
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);

        StringBuffer sb = new StringBuffer();
        String str = dis.readLine();
        while (StringUtils.isNotBlank(str) && StringUtils.isNotBlank(str=new String(str.getBytes("ISO-8859-1"),"GBK"))) {

            str = str.replaceAll("\\$\\{productName\\}", appName);
            sb.append(str).append("\n");
            str = dis.readLine();
        }

        fis.close();
        bis.close();
        dis.close();

        if (StringUtils.isNotBlank(sb)) {
            new File(path + "/" + appName + "Application.java").delete();
            FileWriter fileWriter = new FileWriter(path + "/" + appName + "Application.java");
            fileWriter.write(sb.toString());
            fileWriter.flush();
            fileWriter.close();
        }

    }


    public static void addYaml (String path, String ip, String port, String schema, String userName, String pwd) throws Exception {

        System.out.println("addYaml=" + path);

        String target = "/doc/application.yml";
        InputStream resourceAsStream = CodeGenerator.class.getResourceAsStream(target);

        FileOutputStream fos = new FileOutputStream(path + "/application.yml");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);

        int temp;
        while((temp=resourceAsStream.read()) != -1){
            dos.write(temp);
        }
        dos.flush();
        fos.close();
        bos.close();
        dos.close();

        FileInputStream fis = new FileInputStream(path + "/application.yml");
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);

        StringBuffer sb = new StringBuffer();
        String str = dis.readLine();
        while (StringUtils.isNotBlank(str) && StringUtils.isNotBlank(str=new String(str.getBytes("ISO-8859-1"),"GBK"))) {

             str = str.replaceAll("\\$\\{DB_IP\\}", ip);
             str = str.replaceAll("\\$\\{DB_PORT\\}", port);
             str = str.replaceAll("\\$\\{DB_SCHEMA\\}", schema);
             str = str.replaceAll("\\$\\{DB_NAME\\}", userName);
             str = str.replaceAll("\\$\\{DB_PWD\\}", pwd);
             sb.append(str).append("\n");
             str = dis.readLine();
        }

        fis.close();
        bis.close();
        dis.close();

        if (StringUtils.isNotBlank(sb)) {
            new File(path + "/application.yml").delete();
            FileWriter fileWriter = new FileWriter(path + "/application.yml");
            fileWriter.write(sb.toString());
            fileWriter.flush();
            fileWriter.close();
        }


    }

    public static void addPom (String path, String packageName, String productName) throws Exception {

        System.out.println("addPom=" + path);
        String target = "/doc/pom.xml";
        InputStream resourceAsStream = CodeGenerator.class.getResourceAsStream(target);

        FileOutputStream fos = new FileOutputStream(path + "/pom.xml");
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        DataOutputStream dos=new DataOutputStream(bos);

        int temp;
        while((temp=resourceAsStream.read()) != -1){
            dos.write(temp);
        }
        dos.flush();
        fos.close();
        bos.close();
        dos.close();

        FileInputStream fis = new FileInputStream(path + "/pom.xml");
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);

        StringBuffer sb = new StringBuffer();
        String str = dis.readLine();
        while (StringUtils.isNotBlank(str) && StringUtils.isNotBlank(str=new String(str.getBytes("ISO-8859-1"),"GBK"))) {
            str = str.replaceAll("\\$\\{packageName\\}", packageName);
            str = str.replaceAll("\\$\\{artifactId\\}", packageName.substring(packageName.lastIndexOf(".") + 1));
            str = str.replaceAll("\\$\\{proName\\}", productName.substring(productName.lastIndexOf("/") + 1));
            sb.append(str).append("\n");
            str = dis.readLine();
        }
        fis.close();
        bis.close();
        dis.close();

        if (StringUtils.isNotBlank(sb)) {
            new File(path + "/pom.xml").delete();
            FileWriter fileWriter = new FileWriter(path + "/pom.xml");
            fileWriter.write(sb.toString());
            fileWriter.flush();
            fileWriter.close();
        }


    }

    public static void addSettings (String path) throws Exception {
        mkdirFile(path);
        System.out.println("addSettings=" + path);
        String target = "/doc/settings.xml";
        InputStream resourceAsStream = CodeGenerator.class.getResourceAsStream(target);

        FileOutputStream fos = new FileOutputStream(path + "/settings.xml");
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        DataOutputStream dos=new DataOutputStream(bos);

        int temp;
        while((temp=resourceAsStream.read()) != -1){
            dos.write(temp);
        }
        dos.flush();
        fos.close();
        bos.close();
        dos.close();

    }

    public static void addSwagger (String path, String packageName) throws Exception {
        mkdirFile(path);
        System.out.println("addSwagger=" + path);
        String target = "/doc/SwaggerConfig.java";
        InputStream resourceAsStream = CodeGenerator.class.getResourceAsStream(target);

        FileOutputStream fos = new FileOutputStream(path + "/SwaggerConfig.java");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);

        dos.write(("package " + packageName + ";\n").getBytes());
        int temp;

        while((temp=resourceAsStream.read()) != -1){
            dos.write(temp);
        }
        dos.flush();
        fos.close();
        bos.close();
        dos.close();
    }

    public static void addJava (String path, String packageName) throws Exception {
        mkdirFile(path);
        System.out.println("addJava=" + path);
        String target = "/doc/JsonUtil.java";
        InputStream resourceAsStream = CodeGenerator.class.getResourceAsStream(target);

        FileOutputStream fos = new FileOutputStream(path + "/JsonUtil.java");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);

        dos.write(("package " + packageName + ";\n").getBytes());
        int temp;

        while((temp=resourceAsStream.read()) != -1){
            dos.write(temp);
        }
        dos.flush();
        fos.close();
        bos.close();
        dos.close();
    }

    public static void deleteFile(String path) {
        new File(path).delete();
    }

    public static void mkdirFile(String path) {
        new File(path).mkdirs();
    }
}
