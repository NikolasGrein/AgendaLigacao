package com.controleligacoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleligacoes.entities.Agenda;
import com.controleligacoes.repository.AgendaRepository;

@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;

    @Autowired
    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public List<Agenda> buscaTodosAgenda() {
        return agendaRepository.findAll();
    }

    public Agenda buscaAgendaPeloCodigo(Long id) {
        Optional<Agenda> agenda = agendaRepository.findById(id);
        return agenda.orElse(null);
    }

    public Agenda salvaAgenda(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public Agenda alterarAgenda(Long id, Agenda alterarAgenda) {
        Optional<Agenda> existeAgenda = agendaRepository.findById(id);
        if (existeAgenda.isPresent()) {
            alterarAgenda.setId(id);
            return agendaRepository.save(alterarAgenda);
        }
        return null;
    }

    public boolean apagarAgenda(Long codigo) {
        Optional<Agenda> existeAgenda = agendaRepository.findById(codigo);
        if (existeAgenda.isPresent()) {
            agendaRepository.deleteById(codigo);
            return true;
        }
        return false;
    }
}