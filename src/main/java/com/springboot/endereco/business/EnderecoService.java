package com.springboot.endereco.business;

import com.springboot.endereco.dto.representation.ResultsItem;
import com.springboot.endereco.entity.EnderecoEntity;
import com.springboot.endereco.exception.BusinessException;
import com.springboot.endereco.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;
    @Autowired
    private GeoCodingService geoCodingService;

    public EnderecoEntity cadastrar(EnderecoEntity entity) throws BusinessException {
        try {
            if (entity.getLongitude() == null &&
                    entity.getLatitude() == null) {
                var coordenadas = geoCodingService.buscarCoordenadas(entity);
                coordenadas.getResults().forEach(cordenada ->
                        definirLatLog(cordenada, entity));
            }
            return repository.save(entity);
        } catch (Exception e) {
            throw new BusinessException("Falha ao cadastrar na base de dados: ", e);
        }
    }

    public EnderecoEntity atualizar(EnderecoEntity entity) throws BusinessException {

        var entityBd = repository.findById(entity.getId());
        if (entityBd.isPresent()) {
            return repository.save(entity);
        }
        throw new BusinessException("Endereço não encontrado na base de dados");

    }

    public EnderecoEntity buscarPorId(Integer id) throws BusinessException {
        var enderecoEntity = repository.findById(id);
        if (enderecoEntity.isPresent()) {
            return enderecoEntity.get();
        }
        throw new BusinessException("Endereço não encontrado na base de dados");
    }

    public void deletar(EnderecoEntity entity) throws BusinessException {
        var entityBd = repository.findById(entity.getId());
        if (entityBd.isPresent()) {
            repository.delete(entity);
        } else {
            throw new BusinessException("Endereço não encontrado na base de dados");
        }

    }

    private void definirLatLog(ResultsItem coordenada, EnderecoEntity entity) {
        entity.setLatitude(coordenada.getGeometry().getLocation().getLat());
        entity.setLongitude(coordenada.getGeometry().getLocation().getLng());
    }

}
