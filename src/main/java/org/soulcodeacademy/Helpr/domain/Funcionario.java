package org.soulcodeacademy.Helpr.domain;


import org.soulcodeacademy.Helpr.domain.enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario extends Usuario{
    //gera uma coluna dtype para indicar qual a subclasse

    //coluna foto n é obrigatroria
    private  String foto;


    @ManyToOne //muitos funcionarios para um cargo
    @JoinColumn(name = "idCargo") //cria uma coluna nova que é a chave estrangeira de cargo
    private Cargo cargo;

    public Funcionario(){

    }
    public  Funcionario(Integer id, String nome, String email, String cpf, String senha, String foto, Cargo cargo){
        super(id,nome, email, cpf, senha, Perfil.FUNCIONARIO); //chamada do construtor de usuario
        this.foto = foto;
        this.cargo = cargo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}

//Anotações de relacionamento
//@OneToOne -= 1:1
//@OneToMany/@ManyToOne = 1:N
//@ManyToMany = N:N
//Relacionamento unidirecional = apenas uma das entidades conhece a outra
//Relacionamento Bidirecional = as duas entidades se "conhecem"