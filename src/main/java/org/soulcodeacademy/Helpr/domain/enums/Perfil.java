package org.soulcodeacademy.Helpr.domain.enums;
//enum delimita um conjunto de valores constantes
//ele usa o numero ordinal

//Role -> papel do usuario
public enum Perfil { //enum class

    ADMIN("ROLE_ADMIN"), //0
    FUNCIONARIO("ROLE_FUNCIONARIO"),//1
    CLIENTE("ROLE_CLIENTE");//2

    private String descricao;


    Perfil(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }


}
