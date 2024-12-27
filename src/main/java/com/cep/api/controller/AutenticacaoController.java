package com.cep.api.controller;

import com.cep.api.openapi.AutenticacaoControllerOpenApi;
import com.cep.api.security.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController implements AutenticacaoControllerOpenApi {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping
    public String autenticacao(Authentication authentication) {
        return autenticacaoService.autenticacao(authentication);
    }
}
