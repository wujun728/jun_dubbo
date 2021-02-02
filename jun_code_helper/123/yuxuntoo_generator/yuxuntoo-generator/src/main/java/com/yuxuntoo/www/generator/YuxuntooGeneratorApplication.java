package com.yuxuntoo.www.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yuxuntoo.www.generator.dao")
@SpringBootApplication
public class YuxuntooGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuxuntooGeneratorApplication.class, args);
    }

}
