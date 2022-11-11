package org.soulcodeacademy.Helpr.services;

import org.soulcodeacademy.Helpr.domain.Cargo;
import org.soulcodeacademy.Helpr.domain.Cliente;
import org.soulcodeacademy.Helpr.domain.dto.ClienteDTO;
import org.soulcodeacademy.Helpr.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> Listar(){
        return this.clienteRepository.findAll();
    }


    public Cliente getCliente(Integer idCliente){
        Optional<Cliente> cliente = this.clienteRepository.findById(idCliente);
        if (cliente.isEmpty()){
            throw new RuntimeException("O cliente não foi encontrado.");
        }else {
            return cliente.get();
        }
    }

    public Cliente salvar(ClienteDTO dto){
      Cliente novoCliente = new Cliente(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getSenha(), dto.getTelefone());
      return this.clienteRepository.save(novoCliente);
    }

    public Cliente atualizar(Integer idCliente, ClienteDTO dto){
        Cliente clienteAtual = this.getCliente(idCliente);

        clienteAtual.setNome(dto.getNome());
        clienteAtual.setEmail(dto.getEmail());
        clienteAtual.setCpf(dto.getCpf());
        clienteAtual.setSenha(dto.getSenha());
        clienteAtual.setTelefone(dto.getTelefone());
        Cliente atualizado = this.clienteRepository.save(clienteAtual);
        return atualizado;
    }

    public void deletar(Integer idCliente){
        Cliente cliente = this.getCliente(idCliente);
        this.clienteRepository.delete(cliente);
    }

}
//Quando usar entidade e dto?
//Entidade = Usa no retorno dos dados
//DTO = entrada de dados
