package br.com.ll.grupo03capitao.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "GRUPO 03",
        version = "1.0",
        description = "API do Projeto Grupo 03 - 2026"
    )
)
public class OpenApiConfig {
}