package org.soulcodeacademy.Helpr.domain;

import org.soulcodeacademy.Helpr.domain.enums.Perfil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

//Verifica os dados inseridos de cliente
@Entity
public class Cliente extends Usuario{

    @Column(length = 25) //varchar(25)
    private String telefone;

    public Cliente(){

    }

    public Cliente(Integer id, String nome, String email, String cpf, String senha,String telefone) {
        super(id, nome, email, cpf, senha, Perfil.CLIENTE);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
