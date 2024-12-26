package com.cep.api.disassembler;

import com.cep.api.representationmodel.input.CepInput;
import com.cep.domain.model.Cep;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CepDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cep toEntity(CepInput cepInput) {
        return modelMapper.map(cepInput, Cep.class);
    }


}
