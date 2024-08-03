package hn.unah.lenguajes1900.creditos.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.creditos.entities.Cliente;
import hn.unah.lenguajes1900.creditos.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        //TODO: process POST request
        
        return this.clienteService.crearCliente(cliente);
    }
    
}
