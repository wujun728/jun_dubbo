package com.gf.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: Monkey
 * @Date: Created in 17:23  2019/8/14.
 * @Description:
 */
@Configuration
public class LoadYmlUtils {

    private static Map<String, String> map = new HashMap<String, String>();

    private static String ecPath = null;

    @Autowired
    private Environment environment;

//    @PostConstruct
    public String get() {
        try {

            ecPath = environment.getProperty("spring.config.location");
            RecordLogUtil.info("<===========================================================>");
            RecordLogUtil.info("<=====================初始化配置中心========================>");
            RecordLogUtil.info("<=====================>地址：" + ecPath );
            RecordLogUtil.info(environment.getProperty("jdbc.url"));
            RecordLogUtil.info("<===========================================================>");
            return ecPath;
        } catch (Exception e) {
            RecordLogUtil.error("初始化配置中心地址异常！", e);
        }
        return null;
    }

    /**
     * 读取配置文件
     * @param key
     * @return
     */
    public static String getValue(String key) {
        if (map.size() == 0) {
            String path = null;
            if (StringUtils.isNotBlank(ecPath)) {
                path = ecPath;
            } else {
                //本地启动时，会自动重连172环境
                path = "http://172.16.0.181:8083/config/getConfig.properties/DB/dev/1.0/.properties";
            }

            setRemoteConfig(path, 0);
        }
        if (map.size() > 0) {
            return map.get(key);
        }
        return null;
    }


    /**
     * 读取相对路径匹配名字的方法
     * @param key
     * @return
     */
    public static String LoadValue(String ...key) {
        Properties properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String value = null;
        try {
            if (key.length > 1) {
                properties.load(loader.getResourceAsStream("application" + key[1] + ".yml"));
            } else {
                properties.load(loader.getResourceAsStream("application.yml"));
            }
            value = properties.getProperty(key[0], "");
            RecordLogUtil.info("当前： " + key[0] + "=" + value);
        } catch (Exception e) {
            RecordLogUtil.error("获取字段值异常！", e);
        }
        return value;
    }

    /**
     * 读取全路径的方法,必须是多级才能使用
     * @param signal
     * @param key
     * @return
     */
    public static String ReadValue(String signal,String ...key){
        String line = null;
        try {
            InputStream stream = LoadYmlUtils.class.getClassLoader().getResourceAsStream("application.yml");
            InputStreamReader in = new InputStreamReader(stream, "utf-8");
            BufferedReader reader = new BufferedReader(in);
            boolean flag = false;
            while ((line = reader.readLine()) != null) {
                if(!flag
                        && StringUtils.isNotBlank(line)
                        && line.contains(":")
                        && !line.trim().startsWith("#")
                        && key[0].split(signal)[0].contentEquals(line.trim().substring(0, line.trim().indexOf(":")))){
                    flag = true;
                    continue;
                }
                if (flag) {
                    if (StringUtils.isNotBlank(line)
                            && !line.trim().startsWith("#")
                            && line.contains(":")
                            && line.trim().substring(0, line.trim().indexOf(": ")).startsWith(key[0].split(signal)[1])) {
                        RecordLogUtil.info("当前： " + key[0] + "=" + line.trim().substring(line.trim().indexOf(": ") + 2));
                        //TODO 这里+2 是因为配置文件会在冒号处空格1个
                        return line.trim().substring(line.trim().indexOf(": ") + 1).trim();
                    }
                }
            }
        } catch (Exception e) {
            RecordLogUtil.error("获取字段值异常！line=" + line, e);
        }
        return null;
    }

    /**
     * 设置远程配置文件到本地
     * @param path
     */
    private static void setRemoteConfig(String path, int times) {
        RecordLogUtil.info("<====================================================================>");
        RecordLogUtil.info("远程加载地址=" + path);
        RecordLogUtil.info("<====================================================================>");
        try {
            //此处暂时不需要输出
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            URL url = new URL(path);
            URLConnection uconn = url.openConnection();
            // 设置超时间为3秒
            uconn.setConnectTimeout(3 * 1000);
            // 防止屏蔽程序抓取而返回403错误
            uconn.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            InputStream inputStream = uconn.getInputStream();
            byte data[] = new byte[10240];
            map.clear();
            while ((inputStream.read(data)) != -1) {
                setMap(new String(data));
                //此处暂时不需要输出
//                outputStream.write(data, 0, len);
            }
        } catch (Exception e) {
            RecordLogUtil.error("setRemoteConfig获取远程配置文件失败！", e);
            if (times == 0) {
                RecordLogUtil.info("启动重连模式： 重连中。。。");
                setRemoteConfig(ecPath, ++ times);
            }
        }

    }

    public static void clearMap(){
        map.clear();
    }

    /**
     * 设置map
     * @param s
     */
    private static void  setMap(String s) {
        String str[] = s.split("\n");
        for (String s1 : str) {
            if (StringUtils.isNotBlank(s1) && s1.contains("=")) {
                String key = s1.trim().substring(0, s1.trim().indexOf("="));
                String value = s1.trim().substring(s1.trim().indexOf("=") + 1);
                map.put(key, value);
            }
        }
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(ReadValue("@#@","apaas_properties@#@kubernetes_master_location"));
        String basePath = "http://172.16.0.181:8083/config/getConfig.properties/DB/dev/1.0/.properties";
        setRemoteConfig(basePath, 0);
        System.out.println(map);
        System.out.println(map.get("jdbc.url"));
        System.out.println(getValue("jdbc.url"));
    }
}
