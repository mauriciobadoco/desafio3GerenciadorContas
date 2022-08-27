package com.desafio.GerenciadorContas.repository;

import com.desafio.GerenciadorContas.Enum.StatusConta;
import com.desafio.GerenciadorContas.Enum.TipoConta;
import com.desafio.GerenciadorContas.model.GerenciadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GerenciadorRepository extends JpaRepository<GerenciadorModel, Long> {
    List<GerenciadorModel> findByTipo(TipoConta tipoConta);

    List<GerenciadorModel> findByStatus(StatusConta statusConta);
}
