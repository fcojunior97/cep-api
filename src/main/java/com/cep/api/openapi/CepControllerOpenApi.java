package com.cep.api.openapi;

import com.cep.api.representationmodel.CepModel;
import com.cep.api.representationmodel.input.CepInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "Cep")
public interface CepControllerOpenApi {

    @Operation(summary = "Busca dados de cep por numero")
    public ResponseEntity<CepModel> buscarCep(@PathVariable String numeracaoCep);

    @Operation(summary = "Busca dados de cep por nome de logradouro")
    public ResponseEntity<List<CepModel>> buscarPorLogradouro(@RequestParam String logradouro,
                                                              @RequestParam Integer pagina,
                                                              @RequestParam Integer itens);

    @Operation(summary = "Busca dados de cep por nome de cidade")
    public ResponseEntity<List<CepModel>> buscarPorCidade(@RequestParam String cidade,
                                                          @RequestParam Integer pagina,
                                                          @RequestParam Integer itens);
    @Operation(summary = "Cadastra um novo cep")
    public ResponseEntity<CepModel> cadastrarCep(@Valid @RequestBody CepInput cep);

    @Operation(summary = "Atualiza dados de um cep")
    public ResponseEntity<CepModel> atualizarCep(@PathVariable String numeracaoCep, @Valid @RequestBody CepInput cep);
}
