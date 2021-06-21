package com.springboot.endereco.entity;


import com.springboot.endereco.exception.BusinessException;
import com.springboot.endereco.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String streetName;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private String complement;
    @Column(nullable = false)
    private String neighbourhood;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String zipcode;
    private Double latitude;
    private Double longitude;

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

    public String toStringParam() {
        return String.format(this.number.trim() + "+"
                + this.streetName.trim() + "+"
                + this.city.trim() + "+"
                + this.state.trim() + "+"
                + this.country.trim());
    }
}
