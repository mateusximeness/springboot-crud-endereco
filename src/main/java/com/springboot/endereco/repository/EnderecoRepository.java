package com.springboot.endereco.repository;

import com.springboot.endereco.entity.EnderecoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<EnderecoEntity, Integer> {

}
