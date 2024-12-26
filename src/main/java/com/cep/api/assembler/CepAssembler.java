package com.cep.api.assembler;

import com.cep.api.representationmodel.CepModel;
import com.cep.domain.model.Cep;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CepAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CepModel toModel(Cep cep) {
        return modelMapper.map(cep, CepModel.class);
    }

    public List<CepModel> toCollectionModel(List<Cep> ceps) {
        return ceps.stream()
                .map(cep -> toModel(cep))
                .toList();
    }



}
