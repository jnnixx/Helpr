package org.soulcodeacademy.Helpr.domain.dto;

import org.soulcodeacademy.Helpr.domain.enums.StatusChamado;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChamadoDTO {
    @NotBlank(message = "Titulo é obrigatório")
    private String titulo;

    @NotBlank(message = "Descriição obrigatória")
    private String descricao;

    @NotNull(message = "Id do cliente é obrigatório")
    private Integer idCliente;

    private StatusChamado status;
    private Integer idFuncionario;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public void setStatus(StatusChamado status) {
        this.status = status;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
