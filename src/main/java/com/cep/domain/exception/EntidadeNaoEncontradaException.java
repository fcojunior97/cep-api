package com.cep.domain.exception;

public class EntidadeNaoEncontradaException  extends RuntimeException{

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }

    public EntidadeNaoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }
}
