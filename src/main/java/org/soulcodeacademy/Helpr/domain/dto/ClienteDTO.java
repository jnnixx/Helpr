package org.soulcodeacademy.Helpr.domain.dto;

import javax.validation.constraints.NotNull;

public class ClienteDTO extends UsuarioDTO{
    @NotNull(message = "Telefone é obrigatório")
    private String telefone;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
