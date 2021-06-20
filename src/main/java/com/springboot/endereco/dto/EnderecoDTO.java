package com.springboot.endereco.dto;

import com.springboot.endereco.exception.BusinessException;
import com.springboot.endereco.util.StringUtil;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@Slf4j
public class EnderecoDTO {
    private Integer id;
    private String streetName;
    private String number;
    private String complement;
    private String neighbourhood;
    private String city;
    private String state;
    private String country;
    private String zipcode;
    private String latitude;
    private String longitude;

    public void validarCamposObrigatorios() throws BusinessException {
        log.info("Iniciando validação campos obrigatórios");
        if (StringUtil.isNullOrEmptyOrBlank(this.streetName) ||
                StringUtil.isNullOrEmptyOrBlank(this.number) ||
                StringUtil.isNullOrEmptyOrBlank(this.complement) ||
                StringUtil.isNullOrEmptyOrBlank(this.neighbourhood) ||
                StringUtil.isNullOrEmptyOrBlank(this.city) ||
                StringUtil.isNullOrEmptyOrBlank(this.state) ||
                StringUtil.isNullOrEmptyOrBlank(this.country) ||
                StringUtil.isNullOrEmptyOrBlank(this.zipcode)) {
            throw new BusinessException("Campos Obrigatórios não preenchidos corretamente");
        }
    }
}
