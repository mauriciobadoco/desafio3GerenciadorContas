package com.desafio.GerenciadorContas.service;

import com.desafio.GerenciadorContas.Enum.StatusConta;
import com.desafio.GerenciadorContas.Enum.TipoConta;
import com.desafio.GerenciadorContas.Enum.VerificaStatus;

import com.desafio.GerenciadorContas.model.AtualizaStatus;
import com.desafio.GerenciadorContas.model.GerenciadorModel;
import com.desafio.GerenciadorContas.model.MostrarContasModel;
import com.desafio.GerenciadorContas.repository.GerenciadorRepository;
import com.fasterxml.jackson.core.util.VersionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.desafio.GerenciadorContas.Enum.StatusConta.AGUARDANDO;
import static com.desafio.GerenciadorContas.Enum.StatusConta.VENCIDA;

@Service
public class GerenciadorService {

    @Autowired
    private GerenciadorRepository repository;

    public  List <MostrarContasModel> mostrarContas(){
        List<GerenciadorModel> contas = repository.findAll();
        return MostrarContasModel.convert(contas);
    }


    public Optional<GerenciadorModel> buscarPorId(Long conta){
        return repository.findById(conta);
    }

    public List<GerenciadorModel> buscarPorTipo(TipoConta tipoConta){
    return repository.findByTipo(tipoConta);
}

    public List<GerenciadorModel> buscarPorStatus(StatusConta statusConta){
        return repository.findByStatus(statusConta);
    }

    public GerenciadorModel cadastrarContas(GerenciadorModel contas) {
        VerificaStatus verificaStatus = new VerificaStatus();
        contas.setStatus(verificaStatus.statusConta(contas));
        return repository.save(contas);
    }


    public GerenciadorModel pagarContas(AtualizaStatus atualizaStatus, Long id){
        Optional<GerenciadorModel> conta = repository.findById(id);
        if(conta.isPresent() && atualizaStatus.getStatus().equals(StatusConta.PAGO)){
            conta.get().setStatus(StatusConta.PAGO);
            conta.get().setDataDePagamento(LocalDateTime.now());
        }
        return  repository.save(conta.get());
    }


    public GerenciadorModel alterarContas(VerificaStatus statusConta, Long id){
        Optional<GerenciadorModel> conta = repository.findById(id);
        if (conta.isPresent() && conta.get().getStatus().equals(StatusConta.PAGO)){
            conta.get().setDataDePagamento(LocalDateTime.now());
            conta.get().setStatus(StatusConta.PAGO);
        }
        return repository.save(conta.get());
    }


    public void deletarConta(Long conta){
        repository.deleteById(conta);
    }


}
