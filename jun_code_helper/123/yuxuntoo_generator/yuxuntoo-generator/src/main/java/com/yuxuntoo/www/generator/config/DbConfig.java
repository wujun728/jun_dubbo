package com.yuxuntoo.www.generator.config;

import com.yuxuntoo.www.generator.dao.GeneratorDao;
import com.yuxuntoo.www.generator.dao.MySQLGeneratorDao;
import com.yuxuntoo.www.common.exception.BussException;
import com.yuxuntoo.www.common.vo.resp.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 数据库配置
 * @Author Camel
 * @Date 2013/10/15 13:10
 * @Version 1.0
 */
@Configuration
public class DbConfig {
    /**
     * 数据库类型
     */
    @Value("${yuxuntoo.datatype:mysql}")
    private String dataType;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MySQLGeneratorDao mySQLGeneratorDao;

    @Bean
    @Primary
    public GeneratorDao initGeneratorDao() throws BussException {
        logger.info("DbConfig中的dataType:{}",dataType);
        if ("mysql".equalsIgnoreCase(dataType)) {
            return mySQLGeneratorDao;
        } else {
            throw new BussException(ApiResponse.SYSTEM_ERROR);
        }
    }
}
