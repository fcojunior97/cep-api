package com.cep.api.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;

@Tag(name = "Autenticacao")
public interface AutenticacaoControllerOpenApi {

    @Operation(summary = "Autenticacao de usuario")
    public String autenticacao(Authentication authentication);
}
