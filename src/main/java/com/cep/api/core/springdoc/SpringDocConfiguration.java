package com.cep.api.core.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cep API")
                        .version("v1")
                        .description("API para consulta e cadastro de dados de cep")
                )
                .tags((
                        Arrays.asList(
                                new Tag().name("Cep").description("Cep endpoints"),
                                new Tag().name("Autenticacao").description("Autenticacao endpoints"))
                        )
                );
    }

}
