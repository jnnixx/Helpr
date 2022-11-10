package org.soulcodeacademy.Helpr.controllers;


import org.soulcodeacademy.Helpr.domain.Cliente;
import org.soulcodeacademy.Helpr.domain.dto.ClienteDTO;
import org.soulcodeacademy.Helpr.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

@GetMapping("/clientes")
   public List<Cliente> Listar(){
    return this.clienteService.Listar();
}

@GetMapping("/clientes/{idCliente}")
    public Cliente getCliente(@PathVariable Integer idCliente){
        return this.clienteService.getCliente(idCliente);
}

@PostMapping("/clientes")
public Cliente salvar(@Valid @RequestBody ClienteDTO dto){
    Cliente salvo = this.clienteService.salvar(dto);
    return salvo;
}
@PutMapping("/clientes/{idCliente}")
public Cliente atualizar(@PathVariable Integer idCliente, @Valid @RequestBody ClienteDTO dto){
    Cliente atualizado = this.clienteService.atualizar(idCliente,dto);
    return atualizado;
}

@DeleteMapping("/clientes/{idCliente}")
    public void deletar(@PathVariable Integer idCliente){
        this.clienteService.deletar(idCliente);
}

}


