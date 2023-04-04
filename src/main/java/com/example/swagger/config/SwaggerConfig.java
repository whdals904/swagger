package com.example.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket apiV1() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(true)
                .groupName("v111")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger.controller"))
                .paths(PathSelectors.ant("/v1/api/**"))
                .build()
                .apiInfo(apiInfo());
    }

    @Bean
    public Docket apiV2() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(true)
                .groupName("v222")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger.controller"))
                .paths(PathSelectors.ant("/v2/api/**"))
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger Test")
                .description("SwaggerConfig")
                .version("3.0")
                .build();
    }

}