package org.soulcodeacademy.Helpr.domain;

import javax.persistence.*; //JPA = JAVA PERSISTENCE API

@Entity //Transforma a classe em uma entidade / tabela no banco de dados
public class Cargo { // nome da tabela = cargo
    //@Column serve para costumizar as colunas

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //comando para auto_Incriment
    private Integer idCargo; // será a chave primaria da tabela

    @Column(nullable = false,length = 50) //not null e varchar(50)
    private String nome;

    @Column(nullable = false,length = 120)//not null e varchar(120)
    private String descricao;

    @Column(nullable = false) //not null
    private Double salario;


    public  Cargo(){} // o ORM irá usar este construtor em conjunto dos getter / setter

    public Cargo(Integer idCargo, String nome, String descricao, Double salario) {
        this.idCargo = idCargo;
        this.nome = nome;
        this.descricao = descricao;
        this.salario = salario;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

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
