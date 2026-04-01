package com.poli.market.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI marketOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Market API")
                        .description("API REST para la gestión del sistema de mercado: ventas, bodega, proveedores, entregas y recursos humanos.")
                        .version("0.0.1-SNAPSHOT")
                        .contact(new Contact()
                                .name("Poli Market")
                                .email("contacto@poli.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Servidor local de desarrollo")
                ));
    }
}
