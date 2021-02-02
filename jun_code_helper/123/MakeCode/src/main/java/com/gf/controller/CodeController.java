package com.gf.controller;

import com.gf.config.CodeGenerator;
import com.gf.util.FileToZip;
import com.gf.util.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * ScLoginUserController控制器
 *
 * @author monkey
 * @Date 2021-01-08
 */
@Controller
@RequestMapping("/code")
@Api(tags = "代码生成工具")
public class CodeController {


    @Value("${zipPath}")
    private String zipPath;

    /**
     * 获取ScLoginUser列表
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "生成代码工具", notes = "生成代码工具", produces = 	MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void list(  @ApiParam(value = "作者", defaultValue = "Monkey") @RequestParam("author") String author,
                       @ApiParam(value = "数据库地址", defaultValue = "127.0.0.1")  @RequestParam("ip") String ip,
                       @ApiParam(value = "数据库端口", defaultValue = "3306")  @RequestParam("port") String port,
                       @ApiParam(value = "数据库名称", defaultValue = "nncloud")  @RequestParam("schema") String schema,
                       @ApiParam(value = "数据库账号", defaultValue = "root")  @RequestParam("userName") String userName,
                       @ApiParam(value = "数据库密码", defaultValue = "123456")  @RequestParam("pwd") String pwd,
                       @ApiParam(value = "你希望生成的项目名称（英文）")  @RequestParam("productName") String productName,
                       @ApiParam(value = "你希望生成的代码包名")  @RequestParam("packageName") String packageName,
                       @ApiParam(value = "你希望生成的表名集合，例如：tab1，tab2;（为空则生成所有表）", defaultValue = "")
                       @RequestParam(value = "tables",defaultValue = "") String tables,
                       HttpServletResponse response) {

        try {

            String localPath = zipPath + productName;

            String[] tabs = null;

            if (StringUtils.isNotBlank(tables)) {
                tabs = tables.split(",");
            }

            CodeGenerator.makeCode(author, ip, port, schema, userName, pwd, packageName, localPath, tabs);

            String msg = "========代码生成完毕============";
            System.out.println(msg);

            //开始下载
            String sourceFilePath = localPath;
            String zipFilePath = zipPath;
            String fileName = productName + "-" + UUID.randomUUID().toString().replaceAll("-", "");
            boolean flag = FileToZip.fileToZip(sourceFilePath, zipFilePath, fileName);
            if(flag) {
                System.out.println(">>>>>> 文件打包成功." + fileName + " <<<<<<");
            } else {
                System.out.println(">>>>>> 文件打包失败. <<<<<<");
            }

            FileInputStream fis = new FileInputStream(zipPath + "/" + fileName + ".zip");
            FileUtil.downloadFile(response, fileName + ".zip", fis);
            System.out.println(">>>>>> 下载完成. <<<<<<");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
