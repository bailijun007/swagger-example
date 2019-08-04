package com.blj.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Autowired
    Environment environment;


   /* @Bean
    public Docket docket(){
        //表示当处于开发或者测试环境时可以打开接口文档
        Profiles profiles = Profiles.of("dev", "test");
        boolean b = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.blj.controller")).build()
                .enable(b);
    }*/


   //分组1
    /*@Bean
    public Docket docketUser(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user")//设置分组名
                .select()
                .paths(PathSelectors.ant("/user/**"))//设置扫描哪个路径
                .build();
    }
    //分组2
    @Bean
    public Docket docketHello(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("hello")
                .select()
                .paths(PathSelectors.ant("/hello/**")).build();
    }*/

    //配置全局参数（比如token）
    @Bean
    public Docket docketToken(){
        Parameter token = new ParameterBuilder()
                .name("token")
                .description("用户登录令牌")
                .parameterType("header")
                .modelRef(new ModelRef("String"))
                .required(true)
                .build();

        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(token);
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(parameters);
    }


}
