package com.cep.domain.service;

import com.cep.domain.exception.EntidadeNaoEncontradaException;
import com.cep.domain.model.Cep;
import com.cep.domain.repository.CepRepository;
import com.cep.domain.utils.Utils;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class CepService {

    @Autowired
    private CepRepository cepRepository;

    public Cep buscarCep(String numeracaoCep) {
       return cepRepository.findById(numeracaoCep)
               .orElseThrow(() -> new EntidadeNaoEncontradaException("Não foi encontrado dados de endereço com esse cep {" + numeracaoCep  +"}"));
    }

    public List<Cep> buscarPorLogradouro(String logradouro, Integer pagina, Integer itens) {
        List<Cep> ceps = cepRepository.buscarPorLogradouro(logradouro, PageRequest.of(pagina, itens));

        if(ceps.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi encontrado dados de cep com esse nome de logradouro");
        }

        return ceps;
    }

    public List<Cep> buscarPorCidade(String cidade, Integer pagina, Integer itens) {
        List<Cep> ceps = cepRepository.buscarPorCidade(cidade, PageRequest.of(pagina, itens));

        if(ceps.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi encontrado dados de cep com esse nome de cidade");
        }

        return ceps;
    }

    @Transactional
    public Cep cadastrarCep(Cep cep) {
        cep.setCep(Utils.generateUniqueCep(cepRepository));
        return cepRepository.save(cep);
    }

    @Transactional
    public Cep atualizarCep(String numeracaoCep, Cep cepAtualizado) {
        Cep cepEncontrado = this.buscarCep(numeracaoCep);
        BeanUtils.copyProperties(cepAtualizado, cepEncontrado, "cep");

        return cepRepository.save(cepEncontrado);
    }

}
