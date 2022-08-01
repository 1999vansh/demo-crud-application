package com.vansh.crudDemo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("My First SpringBoot CRUD Application")
                        .description("Spring Boot Crud Application designed to access different Course Details.")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }

    //    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.vansh.crudDemo"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(getInfo());
//    }
//
//    private ApiInfo getInfo() {
//        return new ApiInfo(
//                "My First SpringBoot CRUD Application",
//                "Spring Boot Crud Application designed to access different Course Details.",
//                "1.0",
//                "Terms of service",
//                new Contact("Vansh Garg", "https://localhost:8080/courses/", "vansh.garg@geminisolutions.com"),
//                "Apache License Version 2.0",
//                "Apache License", new ArrayList<>());
//    }
}

