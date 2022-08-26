package com.desafio.GerenciadorContas.controller;

import com.desafio.GerenciadorContas.model.AtualizaStatus;
import com.desafio.GerenciadorContas.model.GerenciadorModel;
import com.desafio.GerenciadorContas.model.MostrarContasModel;
import com.desafio.GerenciadorContas.service.GerenciadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GerenciadorController {

    @Autowired
    private GerenciadorService service;

    @GetMapping (path = "/contas")
    public ResponseEntity<List<MostrarContasModel>> buscarContas(){
        return ResponseEntity.ok(service.mostrarContas());
    }

    @GetMapping (path = "/contas/{id}")
    public Optional<GerenciadorModel> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping (path = "/contas")
    @ResponseStatus(HttpStatus.CREATED)
    public GerenciadorModel cadastrarConta(@RequestBody GerenciadorModel contas){
        return  service.cadastrarContas(contas);
    }

    @PutMapping (path ="/contas/{id}")
    public ResponseEntity<GerenciadorModel> pagarContas(@RequestBody AtualizaStatus atualizaStatus, @PathVariable Long id){
        return ResponseEntity.ok(service.pagarContas(atualizaStatus,id));
    }



    @DeleteMapping (path = "/contas/{id}")
    public void deletarConta(@PathVariable Long conta){
        service.deletarConta(conta);
    }
}
