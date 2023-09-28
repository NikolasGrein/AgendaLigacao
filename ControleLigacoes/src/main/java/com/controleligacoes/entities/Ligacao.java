package com.controleligacoes.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "Ligacao")

public class Ligacao {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	@Column(name = "data")

	private String data;

	@Column(name = "horarioInicio")

	private String horarioInicio;

	@Column(name = "horarioTermino")

	private String horarioTermino;
	
	@Column(name = "telefoneDiscado")

	private String telefoneDiscado;
	

	public Long getId() {

		return id;

	}

	public void setId(Long id) {

		this.id = id;

	}

	public String getData() {

		return data;

	}

	public void setData(String data) {

		this.data = data;

	}

	public String getHorarioInicio() {

		return horarioInicio;

	}

	public void setHorarioInicio(String horarioInicio) {

		this.horarioInicio = horarioInicio;

	}

	public String getTelefoneDiscado() {

		return telefoneDiscado;

	}

	public void setTelefoneDiscado(String telefoneDiscado) { 

		this.telefoneDiscado = telefoneDiscado; 

	}
	
}