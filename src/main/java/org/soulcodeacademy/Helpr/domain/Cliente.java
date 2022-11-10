package org.soulcodeacademy.Helpr.domain;

import org.soulcodeacademy.Helpr.domain.enums.Perfil;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class Cliente extends Usuario{

    @Size(min = 8, max = 11)
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
