package com.desafio.GerenciadorContas.service;

import com.desafio.GerenciadorContas.model.GerenciadorModel;
import com.desafio.GerenciadorContas.repository.GerenciadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class GerenciadorService {

    @Autowired

    private GerenciadorRepository repository;

    public List<GerenciadorModel> buscarContas(){
        return repository.findAll();
    }

    public Optional<GerenciadorModel> buscarPorId(Long conta){
        return repository.findById(conta);
    }

    public GerenciadorModel cadastrarContas(GerenciadorModel contas){



        return repository.save(contas);
    }

    public GerenciadorModel alterarContas(GerenciadorModel contas){



        return repository.save(contas);
    }

    public void deletarConta(Long conta){
        repository.deleteById(conta);
    }
}
