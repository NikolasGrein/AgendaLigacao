package com.controleligacoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleligacoes.entities.Ligacao;
import com.controleligacoes.repository.LigacaoRepository;

@Service
public class LigacaoService {

    private final LigacaoRepository ligacaoRepository;

    @Autowired
    public LigacaoService(LigacaoRepository ligacaoRepository) {
        this.ligacaoRepository = ligacaoRepository;
    }

    public List<Ligacao> buscaTodosLigacao() {
        return ligacaoRepository.findAll();
    }

    public Ligacao buscaLigacaoPeloCodigo(Long id) {
        Optional<Ligacao> ligacao = ligacaoRepository.findById(id);
        return ligacao.orElse(null);
    }

    public Ligacao salvaLigacao(Ligacao ligacao) {
        return ligacaoRepository.save(ligacao);
    }

    public Ligacao alterarLigacao(Long id, Ligacao alterarLigacao) {
        Optional<Ligacao> existeLigacao = ligacaoRepository.findById(id);
        if (existeLigacao.isPresent()) {
            alterarLigacao.setId(id);
            return ligacaoRepository.save(alterarLigacao);
        }
        return null;
    }

    public boolean apagarLigacao(Long codigo) {
        Optional<Ligacao> existeLigacao = ligacaoRepository.findById(codigo);
        if (existeLigacao.isPresent()) {
            ligacaoRepository.deleteById(codigo);
            return true;
        }
        return false;
    }
}