package org.soulcodeacademy.Helpr.repositories;

import org.soulcodeacademy.Helpr.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository <Funcionario, Integer> {
}
