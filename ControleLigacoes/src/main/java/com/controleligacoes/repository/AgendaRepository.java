package com.controleligacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controleligacoes.entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long>  {
}
