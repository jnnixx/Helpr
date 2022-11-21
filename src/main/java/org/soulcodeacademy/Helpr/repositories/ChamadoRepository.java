package org.soulcodeacademy.Helpr.repositories;

import org.soulcodeacademy.Helpr.domain.Chamado;
import org.soulcodeacademy.Helpr.domain.Cliente;
import org.soulcodeacademy.Helpr.domain.Funcionario;
import org.soulcodeacademy.Helpr.domain.enums.StatusChamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

    List<Chamado> findByStatus(StatusChamado status); //filtra os chamados de acordo com o status

    List<Chamado> findByCliente(Cliente cliente); //filtra os chamados de um cliente

    List<Chamado> findByFuncionario(Funcionario funcionario); //filtra os chamados de um funcionario
    //nativeeQuery = ativa a sintaxe dop SQL
    //os dois pontos significa que vai vim do parametro o nome tem que ser igual
    //qunado é uma query nossa podemos chamar doque quisermos e nao usar a convenção find
    @Query(value = "SELECT * FROM chamado WHERE data_abertura BETWEEN :data1 AND :data2", nativeQuery = true) //usamos essa anotação para usar codigos sql
    List<Chamado> buscarEntreDatas(LocalDate data1, LocalDate data2);


}
