package com.diet.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Diet Stats API")
                                .version("1.0")
                                .description("Daily Diet Statistics API")
                                .termsOfService("https://github.com/rahulraogrr/diet")
                                .contact(
                                        new Contact()
                                                .name("Rahul Rao Gonda")
                                                .url("https://github.com/rahulraogrr")
                                                .email("rahulrao.grr@gmail.com")
                                )
                );
    }
}