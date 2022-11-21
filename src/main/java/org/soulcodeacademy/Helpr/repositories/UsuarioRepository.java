package org.soulcodeacademy.Helpr.repositories;

import org.soulcodeacademy.Helpr.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
    Optional<Usuario> findByEmail(String email); //WHERE email = email

    Optional<Usuario> findByCpf(String cpf); //QUERE cpf = cpf

    List<Usuario> findByNome(String nome); //WHERE nome = nome

    List<Usuario> findByNomeContaining(String busca); //filtra pelo nome  -> como se fosse um like
}

//class UsuarioRepository implements UsuarioRepository
//Um resultado usamos para filtrar o OPTIONAL
//varios resultados usamos a LIST

//OBS: seguindo a conveção findBy o Spring implementa o metodo derivado/customizado

// Métodos presentes
// - findAll() => SELECT * FROM usuarios;
// - findById(Integer) => SELECT * FROM usuarios WHERE id = ?;
// - save(Usuario) => INSERT INTO(caso id nulo) ou UPDATE (caso id não nulo)
// - delete(Usuario) => DELETE FROM usuarios WHERE id = ?;

//crud de funcionario
//entidade -> repository -> DTO -> Service + Controller
