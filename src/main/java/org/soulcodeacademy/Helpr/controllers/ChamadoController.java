package org.soulcodeacademy.Helpr.controllers;

import org.soulcodeacademy.Helpr.domain.Chamado;
import org.soulcodeacademy.Helpr.domain.dto.ChamadoDTO;
import org.soulcodeacademy.Helpr.domain.enums.StatusChamado;
import org.soulcodeacademy.Helpr.services.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ChamadoController {
    @Autowired
    private ChamadoService chamadoService;

    @GetMapping("/chamados")
    public List<Chamado> listarChamados(){
        return this.chamadoService.listarChamados();
    }

    @GetMapping("/chamados/{idChamado}")
    public Chamado getChamado(@PathVariable Integer idChamado){
        return this.chamadoService.getChamado(idChamado);
    }

    @PostMapping("/chamados")
    public Chamado salvar(@Valid @RequestBody ChamadoDTO dto){
        return this.chamadoService.salvar(dto);
    }
    @PutMapping("/chamados/{idChamado}")
    public Chamado atualizado(@PathVariable Integer idChamado, @Valid @RequestBody ChamadoDTO dto){
        return  this.chamadoService.atualizar(idChamado, dto);
    }

    //listar por clinete
    @GetMapping("/chamados/clientes/{idCliente}")
    public List<Chamado>listarPorCliente(@PathVariable Integer idCliente){
        return this.chamadoService.listarPorCliente(idCliente);
    }

    //lçistar por funcionario
    @GetMapping("/chamados/funcionarios/{idFuncionario}")
    public List<Chamado> listarPorFuncionario(@PathVariable Integer idFuncionario){
        return this.chamadoService.listarPorFuncionario(idFuncionario);
    }

    //calculadora
    // /soma?numero1=200&numero2=500 ==> 700
    //@ResquestParam ->  usada para mapear os parâmetros HTTP a argumentos de métodos
    @GetMapping("/soma")
    public Integer soma(@RequestParam Integer numero1,@RequestParam Integer numero2){
        return numero1 + numero2;
    }

    @GetMapping("/chamados/status")
    public List<Chamado> listarPorStatus(@RequestParam StatusChamado status){
        return this.chamadoService.listarPorStatus(status);
    }
    //Listar por data(intervalo)
    // = > /chamados/intervalos?inicio=2022-01-01&fim=2023-01-01
    //@DAteTimeFormat - > converte o parametro para data, é necessario especificar o formato q deseja usar
    @GetMapping("/chamados/intervalo")
    public List<Chamado> listarPorIntervaloDatas(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim){
        return this.chamadoService.listarPorIntervaloDatas(inicio,fim);
    }

}
