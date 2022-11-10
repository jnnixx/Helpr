package org.soulcodeacademy.Helpr.services;

import org.soulcodeacademy.Helpr.domain.Cargo;
import org.soulcodeacademy.Helpr.domain.Cliente;
import org.soulcodeacademy.Helpr.domain.Funcionario;
import org.soulcodeacademy.Helpr.repositories.CargoRepository;
import org.soulcodeacademy.Helpr.repositories.ClienteRepository;
import org.soulcodeacademy.Helpr.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Torna o objeto de populateService disponivel para toda a aplicação (Global)
@Service // Indica para o Spring que esta classe será gerenciada por ele
public class PopulateService {
    @Autowired // Injeta o objeto direto na classe
    private CargoRepository cargoRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public void populate(){
        // Integerr idCargo, String nome, String drescricao, Double salario
        Cargo c1 = new Cargo(null, "Diretor geral", "Gerencia a empresa", 30000.0);
        Cargo c2 = new Cargo(null, "Diretor de setor", "Gerencia um setor da empres", 18000.0);
        Cargo c3 = new Cargo(null, "Técnico Geral", "Resolve os chamados da empresa", 12000.0);
        Funcionario f1 = new Funcionario(null, "Mel","Mel.111@gmail.com","11122233344","123456789",null, c1);

        Funcionario f2 = new Funcionario(null,"Victor Icoma","victor.icoma@gmail.com","00000000011","123456",null, c2);
        Cliente cliente1 = new Cliente(null,"Isabella Conceição","isabelladaconceicao@inglesasset.com","03026769029","123456","63982759564");
        Cliente cliente2 = new Cliente(null,"Regina Cláudia Jesus","reginaclaudiajesus@bidoul.com","30886933951","456789","96993010902");
        // vamos persistir / salvar no banco

        this.cargoRepository.save(c1); // Seria o insert into
        this.cargoRepository.save(c2);
        this.cargoRepository.save(c3);
        this.funcionarioRepository.save(f1);
        this.funcionarioRepository.save(f2);
        this.clienteRepository.save(cliente1);
        this.clienteRepository.save(cliente2);



    }
}

//O Objetivo dessa classe é inserir no banco dados fictícios (de teste)
// IOC = Inversion of Control / Inversão de Controle = Ele que manda nas instâncias
// Container = É o local onde o Spring guarda os objetos anotados
// @Services -> Indica que a classe é um serviço