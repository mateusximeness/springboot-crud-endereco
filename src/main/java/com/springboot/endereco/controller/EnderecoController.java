package com.springboot.endereco.controller;

import com.springboot.endereco.business.EnderecoService;
import com.springboot.endereco.dto.EnderecoDTO;
import com.springboot.endereco.exception.BusinessException;
import com.springboot.endereco.mapper.EnderecoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService business;

    @PostMapping(path = "/cadastrar")
    public @ResponseBody
    ResponseEntity<EnderecoDTO> cadastrar(@RequestBody EnderecoDTO dto) throws BusinessException {
        dto.validarCamposObrigatorios();
        var responseEntity = business.cadastrar(EnderecoMapper.toEntity(dto));
        return new ResponseEntity<>(EnderecoMapper.toDto(responseEntity), HttpStatus.CREATED);
    }

    @PutMapping(path = "/atualizar")
    public @ResponseBody
    ResponseEntity<EnderecoDTO> atualizar(@RequestBody EnderecoDTO dto) throws BusinessException {
        dto.validarCamposObrigatorios();
        var responseEntity = business.atualizar(EnderecoMapper.toEntity(dto));
        return ResponseEntity.ok(EnderecoMapper.toDto(responseEntity));
    }

    @GetMapping(path = "/buscar")
    public @ResponseBody
    ResponseEntity<EnderecoDTO> buscar(@RequestParam Integer id) throws BusinessException {
        var responseEntity = business.buscarPorId(id);
        return ResponseEntity.ok(EnderecoMapper.toDto(responseEntity));
    }

    @DeleteMapping(path = "/deletar")
    public @ResponseBody
    ResponseEntity deletar(@RequestBody EnderecoDTO dto) throws BusinessException {
        dto.validarCamposObrigatorios();
        business.deletar(EnderecoMapper.toEntity(dto));
        return new ResponseEntity(HttpStatus.OK);
    }
}
