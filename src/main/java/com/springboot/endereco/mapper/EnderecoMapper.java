package com.springboot.endereco.mapper;

import com.springboot.endereco.dto.EnderecoDTO;
import com.springboot.endereco.entity.EnderecoEntity;
import com.springboot.endereco.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnderecoMapper {

    public static EnderecoDTO toDto(EnderecoEntity entity) throws BusinessException {
        log.info("Iniciando conversão para dto: {}", entity);
        var dto = EnderecoDTO.builder()
                .city(entity.getCity())
                .complement(entity.getComplement())
                .country(entity.getCountry())
                .id(entity.getId())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .neighbourhood(entity.getNeighbourhood())
                .number(entity.getNumber())
                .state(entity.getState())
                .streetName(entity.getStreetName())
                .zipcode(entity.getZipcode())
                .build();
        log.info("Conversão para dto realizada: {}", dto);
        return dto;
    }

    public static EnderecoEntity toEntity(EnderecoDTO dto) throws BusinessException {
        log.info("Iniciando conversão para entidade: {}", dto);
        var entity = EnderecoEntity.builder()
                .city(dto.getCity())
                .complement(dto.getComplement())
                .country(dto.getCountry())
                .id(dto.getId())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .neighbourhood(dto.getNeighbourhood())
                .number(dto.getNumber())
                .state(dto.getState())
                .streetName(dto.getStreetName())
                .zipcode(dto.getZipcode())
                .build();
        log.info("Conversão para dto realizada: {}", entity);
        return entity;
    }
}
