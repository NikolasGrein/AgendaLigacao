package com.controleligacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controleligacoes.entities.Ligacao;

public interface LigacaoRepository extends JpaRepository<Ligacao, Long>  {
}
