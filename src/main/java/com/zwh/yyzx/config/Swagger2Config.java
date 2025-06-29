package com.zwh.yyzx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket getDocket(){
//创建封面信息对象
        ApiInfoBuilder apiInfoBuilder= new ApiInfoBuilder();
        apiInfoBuilder.title("《东软颐养中心》后端接口说明")//文档标题
                .description("文档说明：《东软颐养中心》后端接口文档")//文档说明
                .version("v2.1.1")//版本
                .contact(new Contact("zwh",null,"1141652138@qq.com"));//作者
        ApiInfo apiInfo =apiInfoBuilder.build();
//DocumentationType.SWAG6ER_2指定文档风格
        Docket docket= new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)//指定生成的义档中的封面信息：文档标题、版本、作者
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zwh.yyzx.controller"))//为指定的处理器方法生成接口文档
                .paths(PathSelectors.any())//指定com.nevedu.yyzx.controller中所有路有
                .build();
        return docket;
    }
}
