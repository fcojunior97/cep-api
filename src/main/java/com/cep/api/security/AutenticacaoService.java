package com.cep.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    @Autowired
    private JwtService jwtService;

    public String autenticacao(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }
}
