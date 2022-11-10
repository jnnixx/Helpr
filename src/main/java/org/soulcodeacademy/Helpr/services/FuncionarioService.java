package org.soulcodeacademy.Helpr.services;


import org.soulcodeacademy.Helpr.domain.Cargo;
import org.soulcodeacademy.Helpr.domain.Funcionario;
import org.soulcodeacademy.Helpr.domain.dto.CargoDTO;
import org.soulcodeacademy.Helpr.domain.dto.FuncionarioDTO;
import org.soulcodeacademy.Helpr.domain.enums.Perfil;
import org.soulcodeacademy.Helpr.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private  CargoService cargoService;

    // Lista todos
    public List<Funcionario> Listar(){
        return  this.funcionarioRepository.findAll();
    }

    public  Funcionario getFuncionario(Integer idFuncionario){
        //Optional = pode existir ou nao a entidade
        Optional<Funcionario> funcionario = this.funcionarioRepository.findById(idFuncionario);
        if(funcionario.isEmpty()){
            throw new RuntimeException("O funcionario não foi encontrado.");
        }else {
            return funcionario.get();
        }
    }
    public Funcionario salvar(FuncionarioDTO dto){
         Cargo cargo = this.cargoService.getCargo(dto.getIdCargo()); //verifica se o cargo existe
         Funcionario funcionario = new Funcionario(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getSenha(), dto.getFoto(), cargo);
         Funcionario salvo = this.funcionarioRepository.save(funcionario);
        return salvo;
    }

    public Funcionario atualizar(Integer idFuncionario, FuncionarioDTO dto){
        Funcionario funcionarioAtual = this.getFuncionario(idFuncionario);
        Cargo cargo = this.cargoService.getCargo(dto.getIdCargo());

        funcionarioAtual.setNome(dto.getNome());
        funcionarioAtual.setEmail(dto.getEmail());
        funcionarioAtual.setCpf(dto.getCpf());
        funcionarioAtual.setSenha(dto.getSenha());
        funcionarioAtual.setFoto(dto.getFoto());
        funcionarioAtual.setCargo(cargo);

       Funcionario atualizado = this.funcionarioRepository.save(funcionarioAtual);
        return atualizado;
    }

    public void deletar(Integer idFuncionario){
        Funcionario funcionario = this.getFuncionario(idFuncionario); //funcionario existe?
        this.funcionarioRepository.delete(funcionario);
    }

}
