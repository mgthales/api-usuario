package com.thalesmonteiro.user_service.user_service.swaggerconf;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "API de Usuários", version = "1.0", description = "Documentação da API de Usuários"))
@SpringBootApplication
public class SwaggerConfig {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerConfig.class, args);
    }
}
