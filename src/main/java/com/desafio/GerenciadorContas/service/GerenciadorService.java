package com.desafio.GerenciadorContas.service;

import com.desafio.GerenciadorContas.Enum.StatusConta;
import com.desafio.GerenciadorContas.Enum.VerificaStatus;

import com.desafio.GerenciadorContas.model.AtualizaStatus;
import com.desafio.GerenciadorContas.model.GerenciadorModel;
import com.desafio.GerenciadorContas.model.MostrarContas;
import com.desafio.GerenciadorContas.repository.GerenciadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.desafio.GerenciadorContas.Enum.StatusConta.AGUARDANDO;
import static com.desafio.GerenciadorContas.Enum.StatusConta.VENCIDA;

@Service
public class GerenciadorService {

    @Autowired

    private GerenciadorRepository repository;


//    }
    public Optional<GerenciadorModel> buscarPorId(Long conta){
        return repository.findById(conta);
    }

    public GerenciadorModel cadastrarContas(GerenciadorModel contas) {
        if (LocalDate.now().isAfter(contas.getDataDeVencimento())) {
            contas.setStatus(VENCIDA);
            return repository.save(contas);
        } else {
            contas.setStatus(AGUARDANDO);
        }
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
