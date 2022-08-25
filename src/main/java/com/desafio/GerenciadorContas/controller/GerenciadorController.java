package com.desafio.GerenciadorContas.controller;

import com.desafio.GerenciadorContas.model.GerenciadorModel;
import com.desafio.GerenciadorContas.service.GerenciadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GerenciadorController {

    @Autowired
    private GerenciadorService service;

    @GetMapping (path = "/gerencia")
    public List<GerenciadorModel> buscarContas(){
        return service.buscarContas();
    }

    @GetMapping (path = "/gerencia/{idConta}")
    public Optional<GerenciadorModel> buscarPorId(@PathVariable Long idConta){
        return service.buscarPorId(idConta);
    }
    @PostMapping (path = "/gerencia")
    @ResponseStatus(HttpStatus.CREATED)
    public GerenciadorModel cadastrarConta(@RequestBody GerenciadorModel contas){
        return  service.cadastrarContas(contas);
    }

    @PutMapping (path ="/gerencia/{idConta}")
    public GerenciadorModel alterarConta(@RequestBody GerenciadorModel conta){
        return service.alterarContas(conta);
    }

    @DeleteMapping (path = "/gerencia/{idConta}")
    public void deletarConta(@PathVariable Long conta){
        service.deletarConta(conta);
    }
}
