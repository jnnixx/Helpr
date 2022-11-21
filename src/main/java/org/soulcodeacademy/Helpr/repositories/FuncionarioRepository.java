package org.soulcodeacademy.Helpr.repositories;

import org.soulcodeacademy.Helpr.domain.Cargo;
import org.soulcodeacademy.Helpr.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository <Funcionario, Integer> {
    List<Funcionario> findByCargo(Cargo cargo); //Filtra os funcionarios que possuem, o cargo

    List<Funcionario> findByFotoIsNull(); //Filtra funcionario sem foto definida

    List<Funcionario> findByFotoIsNotNull(); //filtra os funcionarios com foto definida

    @Query(value = "SELECT * FROM usuarios INNER JOIN cargo ON usuarios.id_cargo = cargo.id_cargo  WHERE dtype = 'Funcionario' AND cargo.salario BETWEEN :valor1 AND :valor2", nativeQuery = true)
    List<Funcionario> findBySalarioEntreFaixas(Double valor1, Double valor2);

}

