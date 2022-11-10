package org.soulcodeacademy.Helpr.domain.dto;

import javax.validation.constraints.*;

//DTO -> Objeto de transferência de dados /  DATA TRANSFER OBJECT é util para validarmos as informações transferidas pelo cliente
public class CargoDTO {
    //essa anotação impede que o valor nome seja vazio ("")
    //menssage é o texto da validação
    //notblank só funciona com string (verifica se é nulo ou vazio)
    @NotBlank(message = "Campo nome é obrigatório!")
    private String nome;
    @NotBlank(message = "Campo nome é obrigatório!")
    private String descricao;
    //NotNull -> impede que valor seja nulo
    @NotNull(message = "Campo salário é obrigatório!")
    @Min(value = 500, message = "Campo salário inválido")
    @Max(value = 100000, message = "Campo inválido")

    private  Double salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
