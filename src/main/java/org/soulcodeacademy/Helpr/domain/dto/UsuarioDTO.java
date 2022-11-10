package org.soulcodeacademy.Helpr.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

//guarda as validações emn comum para cliente e funcionario
//no contrroller: JSON -> converte no DTO
public abstract class UsuarioDTO {
    @NotBlank(message = "Nome é obrigatório! ( ಠ ͜ʖಠ)")
    protected String nome;
    @Email(message = "E-mail inválido!")
    @NotBlank(message = "E-mail é obrigatório!")
    protected  String email;

    @NotBlank(message = "CPF é obrigatório!")
    protected  String cpf;

    @NotBlank(message = "Senha obrigatória!")
    protected String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
