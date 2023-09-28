package com.controleligacoes.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "Agenda")

public class Agenda {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	@Column(name = "nome")

	private String nome;

	@Column(name = "ddd")

	private String ddd;

	@Column(name = "telefone")

	private String telefone;
	

	public Long getId() {

		return id;

	}

	public void setId(Long id) {

		this.id = id;

	}

	public String getNome() {

		return nome;

	}

	public void setNome(String nome) {

		this.nome = nome;

	}

	public String getDdd() {

		return ddd;

	}

	public void setDdd(String ddd) {

		this.ddd = ddd;

	}

	public String getTelefone() {

		return telefone;

	}

	public void setTelefone(String telefone) { 

		this.telefone = telefone; 

	}
	
}