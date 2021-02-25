package com.hoo.codegenerator.server.core.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.hoo.codegenerator.server.core.bean.dto.TplDto;
import com.hoo.codegenerator.server.core.service.TplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * 模版服务实现类
 *
 * @author hank
 * @create 2020-12-29 上午10:27
 **/
@Service
public class TplServiceImpl implements TplService {
    @Autowired JdbcTemplate jdbcTemplate;

    @Override
    public Object queryAll() {
        // 实现由 h2 转为 读取文件, 避免特殊字符问题
        InputStream inputStream = null;
        try {
            ClassPathResource classPathResource = new ClassPathResource("data.json");
            inputStream =classPathResource.getInputStream();

            HashMap<String, Object> object =  (HashMap<String, Object>)JSONUtils.parse(toString(inputStream));
            return object.get("data");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }catch (IOException e){}
            }
        }
        // return jdbcTemplate.query("SELECT a.title,a.content,a.suffix,a.tpl_id,a.group_id,b.group_name FROM T_CODEGEN_TPL a LEFT JOIN T_CODEGEN_TPL_GROUP b ON a.group_id = b.group_id", new BeanPropertyRowMapper(TplDto.class));
        return null;
    }

    public static String toString(InputStream is) {

        try {
            ByteArrayOutputStream boa=new ByteArrayOutputStream();
            int len=0;
            byte[] buffer=new byte[1024];

            while((len=is.read(buffer))!=-1){
                boa.write(buffer,0,len);
            }
            is.close();
            boa.close();
            byte[] result=boa.toByteArray();

            String temp=new String(result);

            //识别编码
            if(temp.contains("utf-8")){
                return new String(result,"utf-8");
            }else if(temp.contains("gb2312")){
                return new String(result,"gb2312");
            }else{
                return new String(result,"utf-8");
            }


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
