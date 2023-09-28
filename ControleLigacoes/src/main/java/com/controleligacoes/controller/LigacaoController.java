package com.controleligacoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleligacoes.entities.Ligacao;
import com.controleligacoes.service.LigacaoService;

@RestController
@RequestMapping("/ligacao") 
public class LigacaoController {
    private final LigacaoService ligacaoService; 

    @Autowired
    public LigacaoController(LigacaoService ligacaoService) {
        this.ligacaoService = ligacaoService;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Ligacao> buscaLigacaoControlId(@PathVariable Long codigo) {
        Ligacao ligacao = ligacaoService.buscaLigacaoPeloCodigo(codigo); 
        if (ligacao != null) {
            return ResponseEntity.ok(ligacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Ligacao>> buscaTodosLigacaoControl() { 
        List<Ligacao> ligacao = ligacaoService.buscaTodosLigacao();
        return ResponseEntity.ok(ligacao);
    }

    @PostMapping("/")
    public ResponseEntity<Ligacao> salvaLigacaoControl(@RequestBody Ligacao ligacao) { 
        Ligacao salvaLigacao = ligacaoService.salvaLigacao(ligacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaLigacao);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Ligacao> alteraLigacaoControl(@PathVariable Long codigo, @RequestBody Ligacao ligacao) { 
        Ligacao alteraLigacao = ligacaoService.alterarLigacao(codigo, ligacao);
        if (alteraLigacao != null) {
            return ResponseEntity.ok(ligacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> apagaLigacaoControl(@PathVariable Long codigo) { 
        boolean apagar = ligacaoService.apagarLigacao(codigo);
        if (apagar) {
            return ResponseEntity.ok().body("A Tarefa foi excluída com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}