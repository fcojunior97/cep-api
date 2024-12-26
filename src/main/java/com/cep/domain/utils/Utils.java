package com.cep.domain.utils;

import com.cep.domain.repository.CepRepository;

import java.util.Random;

public class Utils {

    private static final Random random = new Random();

    /*
       Metodo que simula a geração aleatoria de ceps
       Este metodo é apenas de simulação, podendo conter outras regras de négocio em um ambiente real
     */
    public static String generateUniqueCep(CepRepository cepRepository) {
        String cep;
        do {
            cep = String.format("%08d", random.nextInt(100000), random.nextInt(1000));
        } while (cepRepository.existsById(cep));

        return cep;
    }

}
