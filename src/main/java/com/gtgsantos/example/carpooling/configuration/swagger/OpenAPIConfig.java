package com.gtgsantos.example.carpooling.configuration.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI  openAPIDocumentation() { // configuration for openconfig (former swagger)
        return new OpenAPI().info(new Info()
                .title("Carpool Service")
                .description("Carpool API, just for study and for fun").version("v0.1").contact(new Contact()
                        .name("Guilherme Santos")
                        .email("sendme@a.message.com")
                )
        );
    }


}
