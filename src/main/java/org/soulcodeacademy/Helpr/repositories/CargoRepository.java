package org.soulcodeacademy.Helpr.repositories;

import org.soulcodeacademy.Helpr.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository // Indica que a interface é um repositorio
public interface CargoRepository extends JpaRepository<Cargo, Integer> { //Entidade, chave primaria
    List<Cargo> findByNome(String nome); //WHERE nome = valor;
    List<Cargo> findBySalario(Double valor); //WHERE salario = valor;
    List<Cargo> findBySalarioGreaterThan(Double valor); //WHERE salario > valor

    List<Cargo> findBySalarioGreaterThanEqual(Double valor); //WHERE salario >= valor

    List<Cargo> findBySalarioLessThan(Double valor); //WHERE salario < valor

    List<Cargo> findBySalarioLessThanEqual(Double valor); //WHERE salario <= valor;

    List<Cargo> findBySalarioBetween(Double valor1, Double valor2); //WHERE salario BETWEEN valor1 AND valor2

}
//TODAS as querrys a gente faz no repository
// Repository = É um recurso que permite manipular a entidade no banco de dados
// Adicionar entidades, atualizar entidades, remover entidades e listar (CRUD)
// Indicar qual a entidade vai ser gerenciada pelo repository e qual é o tipo da chave primaria
// Obs: O Spring gera uma classe dinâmica com base em nossa interface CargoRepository
//Sempre que for fazer um repository tem que criar uma interface
//CrudRepository = Contém as operações básicas de um banco de dados
// Todas as entidades precisam de uma interface
//JpsRepository possui mais funcionalidades para tratar a entidade
