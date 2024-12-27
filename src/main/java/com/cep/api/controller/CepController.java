package com.cep.api.controller;

import com.cep.api.assembler.CepAssembler;
import com.cep.api.disassembler.CepDisassembler;
import com.cep.api.openapi.CepControllerOpenApi;
import com.cep.api.representationmodel.CepModel;
import com.cep.api.representationmodel.input.CepInput;
import com.cep.domain.model.Cep;
import com.cep.domain.service.CepService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cep/api")
public class CepController implements CepControllerOpenApi {

    @Autowired
    private CepService cepService;

    @Autowired
    private CepDisassembler cepDisassembler;

    @Autowired
    private CepAssembler cepAssembler;

    @GetMapping("/{numeracaoCep}")
    public ResponseEntity<CepModel> buscarCep(@PathVariable String numeracaoCep) {
        Cep cepEncontrado = cepService.buscarCep(numeracaoCep);
        return ResponseEntity.ok(cepAssembler.toModel(cepEncontrado));
    }

    @GetMapping("/logradouro")
    public ResponseEntity<List<CepModel>> buscarPorLogradouro(@RequestParam String logradouro,
                                                              @RequestParam Integer pagina,
                                                              @RequestParam Integer itens) {
        List<Cep> cepsEncontrado = cepService.buscarPorLogradouro(logradouro, pagina, itens);
        return ResponseEntity.ok(cepAssembler.toCollectionModel(cepsEncontrado));
    }

    @GetMapping("/cidade")
    public ResponseEntity<List<CepModel>> buscarPorCidade(@RequestParam String cidade,
                                                          @RequestParam Integer pagina,
                                                          @RequestParam Integer itens) {
        List<Cep> cepsEncontrado = cepService.buscarPorCidade(cidade, pagina, itens);
        return ResponseEntity.ok(cepAssembler.toCollectionModel(cepsEncontrado));
    }

    @PostMapping
    public ResponseEntity<CepModel> cadastrarCep(@Valid @RequestBody CepInput cep) {
        Cep cepCadastrado = cepService.cadastrarCep(cepDisassembler.toEntity(cep));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cepAssembler.toModel(cepCadastrado));
    }

    @PutMapping("/{numeracaoCep}")
    public ResponseEntity<CepModel> atualizarCep(@PathVariable String numeracaoCep, @Valid @RequestBody CepInput cep) {
        Cep cepAtualizado = cepService.atualizarCep(numeracaoCep, cepDisassembler.toEntity(cep));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cepAssembler.toModel(cepAtualizado));

    }

}
