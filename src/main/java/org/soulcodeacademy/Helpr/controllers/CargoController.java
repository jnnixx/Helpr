package org.soulcodeacademy.Helpr.controllers;

import org.soulcodeacademy.Helpr.domain.Cargo;
import org.soulcodeacademy.Helpr.domain.dto.CargoDTO;
import org.soulcodeacademy.Helpr.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


//Não pode repetir o endereço, se não da conflito / exemplo @GetMapping("/batata") e @GetMapping("/batata")@GetMapping("/batata2")
@RestController //Retorno de dados
public class CargoController {

    //Enpoint é o endereço que será acessado no backend
    @GetMapping("/oi")//com base de localhost:8080/oi retorna a String
    public String dizOla(){
        return "Batata!";
    }

    @GetMapping("/batata")
    public Integer valor(){
        return  1000; //resposta da requisição
    }


    // -------------------------------------------------------//
    //para requisitar dados armazenados
    /*@GetMapping("/cargos/1") //-> não é viavel
    public  Cargo getCargo(){
        return  this.cargoService.getCargo(1);
    }*/
    @Autowired
    private CargoService cargoService;

    @GetMapping("/cargos")
    public List<Cargo> listar(){
        // Requisição > controller > service >repository > select * from cargo
        return this.cargoService.listar();
    }
    @GetMapping("/cargos/{idCargo}") // indica que após as barras o valor é dinamico incluir as chaves {}
    public  Cargo getCargo(@PathVariable Integer idCargo){
        //@PaathVariable -> Extrai do endpoint o que é o valor dinamico
        return  this.cargoService.getCargo(idCargo);
    }
    //podemos usar o mesmo endpoint para verbos/anotações diferentes
    //adicionar cargo
    @PostMapping("/cargos") //REQUISIÇÃO TIPO POST PARA / CARGOS
    public Cargo salvar( @Valid @RequestBody CargoDTO cargo){ //para add e cair no salvar
        // @requestBody - extrai o json do corpo e converte para cargo (deserializacao)
        Cargo salvo = this.cargoService.salvar(cargo);
        return salvo; //A resposta será o cargo inserido
    }

    //Mapeia requisições do verbo PUT
    @PutMapping("/cargos/{idCargo}")
    public Cargo atualizar(@PathVariable Integer idCargo, @Valid @RequestBody CargoDTO cargo){
        Cargo atualizado = this.cargoService.atualizar(idCargo, cargo);
        return atualizado;
    }
    //deleta
    @DeleteMapping("/cargos/{idCargo}") //Verbo delete
    // usamos void no delete pq não precisamos retornar algo para ele
    public  void deletar(@PathVariable Integer idCargo){
        this.cargoService.deletar(idCargo);
    }
}
