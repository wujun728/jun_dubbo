package com.gf.util;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * <li>文件名称: 题目名称</li>
 * <li>文件描述: 文件描述</li>
 * <li>版权所有: 版权所有© 2005-2017</li>
 * <li>公 司: </li>
 * <li>内容摘要: 无</li>
 * <li>其他说明:无</li>
 * <li>完成日期： 2019/7/14</li>
 * <li>修改记录: 无</li>
 *
 * @author lij
 * @version 版本号
 */
public class FileUtil {

    /**
     * 下载文件
     * @param response
     * @param fileName
     *      文件名
     * @param data
     *      下载数据
     * @throws Exception
     */
    public static void downloadFile(HttpServletResponse response, String fileName, byte[] data) throws Exception{
        downloadSetting(response,fileName);
        //实现下载
        OutputStream os = response.getOutputStream();
        os.write(data);
        os.flush();
    }

    /**
     * 下载文件
     * @param response
     * @param fileName
     *      文件名
     * @param inputStream
     *      数据流
     * @throws Exception
     */
    public static void downloadFile(HttpServletResponse response, String fileName, InputStream inputStream) throws Exception{
//        downloadSetting(response,fileName);
//        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        //实现下载
        OutputStream os = response.getOutputStream();

        byte[] temp = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(temp)) != -1){
            os.write(temp,0, len);
        }
        os.flush();
    }

    /**
     * 下载公共配置
     * @param response
     * @param fileName
     * @throws Exception
     */
    private static void downloadSetting(HttpServletResponse response, String fileName) throws Exception{
        // 配置文件下载
//        response.setHeader("content-type", "application/octet-stream");
//        response.setContentType("application/octet-stream"); swagger需要注释这句
        // 下载文件能正常显示中文
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
    }

}
