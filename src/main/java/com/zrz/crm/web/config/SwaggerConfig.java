package com.zrz.crm.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2接口文档配置
 *
 * @author qcdl
 * @date 2019/6/5
 */
@Configuration
@EnableSwagger2
@Profile(value = {"dev"})
public class SwaggerConfig {

    /**
     * Swagger2 url标识符: swagger
     */
    public final static String SWAGGER_NAME_SYMBOL = "swagger";

    /**
     * Swagger2 url标识符: api-docs
     */
    public final static String SWAGGER_API_DOCS_SYMBOL = "api-docs";


    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("周瑞忠")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zrz.crm.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("CRM")
                .description("CRM")
                .contact(new Contact("周瑞忠", "", "528441592@qq.com"))
                .version("1.0")
                .build();
    }

}
