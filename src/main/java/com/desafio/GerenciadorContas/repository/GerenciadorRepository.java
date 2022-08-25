package com.desafio.GerenciadorContas.repository;

import com.desafio.GerenciadorContas.model.GerenciadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenciadorRepository extends JpaRepository<GerenciadorModel, Long> {
}
