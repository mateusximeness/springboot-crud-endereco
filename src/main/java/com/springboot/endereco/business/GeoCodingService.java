package com.springboot.endereco.business;

import com.springboot.endereco.dto.representation.CoordenadasResponse;
import com.springboot.endereco.entity.EnderecoEntity;
import com.springboot.endereco.repository.GeoCodingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeoCodingService {
    @Autowired
    GeoCodingRepository repository;

    public CoordenadasResponse buscarCoordenadas(EnderecoEntity endereco) {
        var result = repository.buscar(endereco.toStringParam());
        return result;
    }
}
