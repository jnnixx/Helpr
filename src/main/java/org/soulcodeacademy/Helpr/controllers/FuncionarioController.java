package org.soulcodeacademy.Helpr.controllers;

import org.soulcodeacademy.Helpr.domain.Funcionario;
import org.soulcodeacademy.Helpr.domain.dto.FuncionarioDTO;
import org.soulcodeacademy.Helpr.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.JdbcTransactionObjectSupport;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public List<Funcionario> listar(){
        return  this.funcionarioService.Listar();
    }
    //@REquestParam -> captura os valores de parametros após a ? exemplo /funciionario/salario?valor1=100&valor2=300
    @GetMapping("/funcionarios/salario")
    public List<Funcionario> listarPorFaixaSalarial(@RequestParam Double valor1,@RequestParam Double valor2){
        return this.funcionarioService.listarPorFaixaSalarial(valor1, valor2);
    }
    
    @GetMapping("/funcionarios/{idFuncionario}")
    public Funcionario getFuncionario(@PathVariable Integer idFuncionario){
        return  this.funcionarioService.getFuncionario(idFuncionario);
    }
    @PostMapping("/funcionarios")
    public Funcionario salvar(@Valid @RequestBody FuncionarioDTO dto){
        Funcionario funcionario = this.funcionarioService.salvar(dto);
        return funcionario;
    }

    @PutMapping("/funcionarios/{idFuncionario}")
    public Funcionario atualizar(@PathVariable Integer idFuncionario, @Valid @RequestBody FuncionarioDTO dto){
        Funcionario atualizado = this.funcionarioService.atualizar(idFuncionario, dto);
        return atualizado;
    }
    @DeleteMapping("/funcionarios/{idFuncionario}")
    public void deletar(@PathVariable Integer idFuncionario){
        this.funcionarioService.deletar(idFuncionario);
    }
}
