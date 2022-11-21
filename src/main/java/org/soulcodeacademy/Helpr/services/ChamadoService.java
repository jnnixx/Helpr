package org.soulcodeacademy.Helpr.services;

import org.soulcodeacademy.Helpr.domain.Chamado;
import org.soulcodeacademy.Helpr.domain.Cliente;
import org.soulcodeacademy.Helpr.domain.Funcionario;
import org.soulcodeacademy.Helpr.domain.dto.ChamadoDTO;
import org.soulcodeacademy.Helpr.domain.enums.StatusChamado;
import org.soulcodeacademy.Helpr.repositories.ChamadoRepository;
import org.soulcodeacademy.Helpr.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private FuncionarioService funcionarioService;

    public List<Chamado> listarChamados(){
        return this.chamadoRepository.findAll();
    }
    public Chamado getChamado(Integer idChamado){
        return this.chamadoRepository.findById(idChamado).orElseThrow(() -> new RuntimeException("Chamado não encontrado"));
    }

    public Chamado salvar(ChamadoDTO dto){
        Cliente cliente = this.clienteService.getCliente(dto.getIdCliente());
        Chamado chamadoNovo = new Chamado(null, dto.getTitulo(), dto.getDescricao());
        chamadoNovo.setCliente(cliente); //assiim ele sabe que existe uma relação entre cliente e chamado
        return this.chamadoRepository.save(chamadoNovo);
    }
    public Chamado atualizar(Integer idChamado, ChamadoDTO dto) {
        Chamado chamadoAtual = this.getChamado(idChamado);
        Cliente cliente = this.clienteService.getCliente(dto.getIdCliente());
        chamadoAtual.setCliente(cliente);
        if (dto.getIdFuncionario() == null) {
            throw new RuntimeException("Idfuncionario obrigatório");
        } else {
            Funcionario funcionario = this.funcionarioService.getFuncionario(dto.getIdFuncionario());
            switch (dto.getStatus()) {
                case RECEBIDO -> {
                    chamadoAtual.setStatus(StatusChamado.RECEBIDO);
                    chamadoAtual.setFuncionario(null);
                }
                case ATRIBUIDO -> {
                    chamadoAtual.setStatus(StatusChamado.ATRIBUIDO);
                    chamadoAtual.setFuncionario(funcionario);
                    chamadoAtual.setDataFechamento(null);
                }
                case CONCLUIDO -> {
                    chamadoAtual.setStatus(StatusChamado.CONCLUIDO);
                    chamadoAtual.setFuncionario(funcionario);
                    chamadoAtual.setDataFechamento(LocalDate.now());
                }
            }
        }
        return this.chamadoRepository.save(chamadoAtual);
    }
    public List<Chamado> listarPorStatus(StatusChamado status){
        return this.chamadoRepository.findByStatus(status);
    }

    public List<Chamado> listarPorFuncionario(Integer idFuncionario){
        Funcionario funcionario = this.funcionarioService.getFuncionario(idFuncionario);
        return this.chamadoRepository.findByFuncionario(funcionario);
    }

    public List<Chamado> listarPorCliente(Integer idCliente){
        Cliente cliente = this.clienteService.getCliente(idCliente);
        return this.chamadoRepository.findByCliente(cliente);
    }
    public List<Chamado> listarPorIntervaloDatas(LocalDate data1, LocalDate data2){
        return this.chamadoRepository.buscarEntreDatas(data1,data2);
    }


}
