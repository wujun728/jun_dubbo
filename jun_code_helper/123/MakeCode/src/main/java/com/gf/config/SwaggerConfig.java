package com.gf.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


/**
 * swagger配置类
 *
 * @author fengshuonan
 * @date 2017年6月1日19:42:59
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.key:key}")
    private String key;

    @Value("${swagger.tokenSwitch:true}")
    private boolean tokenSwitch;

    @Value("${swagger.defaultValue:123456}")
    private String defaultValue;


    @Bean
    public Docket createRestApi() {

        List<Parameter> parameters = new ArrayList<>();
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder.name(key)
                .description("认证token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(tokenSwitch)
                .defaultValue(defaultValue);

        parameters.add(parameterBuilder.build());


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalOperationParameters(parameters)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))                         //这里采用包含注解的方式来确定要显示的接口
                //.apis(RequestHandlerSelectors.basePackage("com.youedata.edu.modular.system.controller"))    //这里采用包扫描的方式来确定要显示的接口
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Guns Doc")
                .description("Guns Api文档")
                .termsOfServiceUrl("http://git.oschina.net/naan1993/guns")
                .contact("Monkey")
                .version("2.0")
                .build();
    }

}
