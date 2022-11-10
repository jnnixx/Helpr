package org.soulcodeacademy.Helpr.repositories;

import org.soulcodeacademy.Helpr.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

}

//class UsuarioRepositoryImpl implements UsuarioRepository

// Métodos presentes
// - findAll() => SELECT * FROM usuarios;
// - findById(Integer) => SELECT * FROM usuarios WHERE id = ?;
// - save(Usuario) => INSERT INTO(caso id nulo) ou UPDATE (caso id não nulo)
// - delete(Usuario) => DELETE FROM usuarios WHERE id = ?;

//crud de funcionario
//entidade -> repository -> DTO -> Service + Controller
