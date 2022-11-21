package org.soulcodeacademy.Helpr.services;


import org.hibernate.id.IntegralDataTypeHolder;
import org.soulcodeacademy.Helpr.domain.Cargo;
import org.soulcodeacademy.Helpr.domain.dto.CargoDTO;
import org.soulcodeacademy.Helpr.repositories.CargoRepository;
import org.soulcodeacademy.Helpr.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    //Listar todos
    public List<Cargo> listar() {//Retorna os dados da tabela em forma de lista
        //Select * From cargo;
        return this.cargoRepository.findAll();
    }
    //Listar pelo ID
    public Cargo getCargo(Integer idCargo){
        // Select * From cargo Where idCargo = ?
        //Optional = pode ter um cargo ou nao
        Optional<Cargo> cargo = this.cargoRepository.findById(idCargo);
        if(cargo.isEmpty()){
            //não encontrou o cargo com id solicitado
            throw new RuntimeException("O cargo não foi encontrado."); //causa um erro com a msg
        }else{
            //vvai ser retornado
            return cargo.get(); // extrai o cargo de dentro do optional
        }
    }
    //Salvar
    public  Cargo salvar( CargoDTO dto){
        // é o mesmo que insert into cargo
        Cargo cargo = new Cargo(null, dto.getNome(), dto.getDescricao(), dto.getSalario());
        Cargo cargoSalvo = this.cargoRepository.save(cargo);
        return cargoSalvo;
    }
    //Atualizar
    //para atualizar precisa do ID do cargo e dos dados atualizados
    public  Cargo atualizar(Integer idCargo, CargoDTO dto){
        //verifica se o cargo existe
        Cargo cargoAtual = this.getCargo(idCargo);
        cargoAtual.setNome(dto.getNome());
        cargoAtual.setDescricao(dto.getDescricao());
        cargoAtual.setSalario(dto.getSalario());

        Cargo atualizado = this.cargoRepository.save(cargoAtual); //atualiza a entidade pois ela possui um ID diferente de nullo
        return  atualizado;
    }
    //Deletar

    public void deletar(Integer idCargo){
        //verifica se existe o cargo para deletar
        Cargo cargo = this.getCargo(idCargo);
        this.cargoRepository.delete(cargo);

    }
}
