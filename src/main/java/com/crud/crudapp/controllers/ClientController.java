package com.crud.crudapp.controllers;

import com.crud.crudapp.entities.Client;
import com.crud.crudapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @GetMapping(value="/cadastrarCliente")
    public String form(){
        return "client/formClient";
    }

    @PostMapping(value="/cadastrarCliente")
    public String form(Client client){

        repository.save(client);

        return "redirect:/cadastrarCliente";
    }

    @GetMapping("/clientes")
    public ModelAndView listaClients(){
        ModelAndView mv = new ModelAndView("/index");
        Iterable<Client> clients = repository.findAll();
        mv.addObject("clients", clients);
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhesClient(@PathVariable("id") Long id){
        Client client = repository.findById(id);
        ModelAndView mv = new ModelAndView("client/detalhesClient");
        mv.addObject("client", client);
        System.out.println("client" + client);
        return mv;
    }

    @RequestMapping("/deletar")
    public String deletarClient(Long id){
        Client client = repository.findById(id);
        repository.delete(client);
        return "redirect:/clientes";
    }
}
