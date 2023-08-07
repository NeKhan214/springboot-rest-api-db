package com.nehak.springbootrestapidb;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "SpringBoot ResfulWebServices Demo App",
                description = "SpringBoot ResfulWebServices Demo App",
                version = "v1.0",
                contact = @Contact(
                        name = "Neha Khan",
                        email = "neha.khan@harman.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://apache/2.0/license"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Reference Documents",
                url = "https://spring.io/blog/2022/05/24/preparing-for-spring-boot-3-0/"
        )
)
public class SpringbootRestDbApplication {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestDbApplication.class, args);
    }

}
