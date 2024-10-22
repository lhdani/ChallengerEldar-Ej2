package com.eldar.challenger.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Tarjetas de Crédito")
                        .version("1.0")
                        .description("Documentación de API para la gestión de tarjetas de crédito y operaciones"));
    }
}
