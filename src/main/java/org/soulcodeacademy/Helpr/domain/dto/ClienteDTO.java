package org.soulcodeacademy.Helpr.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteDTO extends UsuarioDTO{
    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
//@NotNull => verifica se tem valor ou nao (objetos, integer, double ...)
//@NotBlank => verifica se o telefone está "" (string)
