package com.springboot.endereco.business;

import com.springboot.endereco.entity.EnderecoEntity;
import com.springboot.endereco.exception.BusinessException;
import com.springboot.endereco.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoEntity cadastrar(EnderecoEntity entity) throws BusinessException {
        try {
            return enderecoRepository.save(entity);
        } catch (Exception e) {
            throw new BusinessException("Falha ao cadastrar na base de dados: ", e);
        }
    }

    public EnderecoEntity atualizar(EnderecoEntity entity) throws BusinessException {

        var entityBd = enderecoRepository.findById(entity.getId());
        if (entityBd.isPresent()) {
            return enderecoRepository.save(entity);
        }
        throw new BusinessException("Endereço não encontrado na base de dados");

    }

    public EnderecoEntity buscarPorId(Integer id) throws BusinessException {
        var enderecoEntity = enderecoRepository.findById(id);
        if (enderecoEntity.isPresent()) {
            return enderecoEntity.get();
        }
        throw new BusinessException("Endereço não encontrado na base de dados");
    }

    public void deletar(EnderecoEntity entity) throws BusinessException {
        var entityBd = enderecoRepository.findById(entity.getId());
        if (entityBd.isPresent()) {
            enderecoRepository.delete(entity);
        }
        throw new BusinessException("Endereço não encontrado na base de dados");

    }

}
