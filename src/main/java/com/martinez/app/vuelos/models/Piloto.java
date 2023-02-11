package com.martinez.app.vuelos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "pilotos")
public class Piloto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PILOTO")
	@SequenceGenerator(sequenceName = "sequence_piloto", allocationSize = 1, name = "SEQ_PILOTO")
	@Column(name = "id_piloto")
	private Long id;
	
	@Pattern(regexp = "^[a-zA-Z]{2}-[0-9]{4}",
			message = "El código debe cimplir con el formato XX-0000")
	private String codigo;
	private String nombre_completo;
	private String sexo;
	private Double horas_vuelo;
	
	public Piloto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Double getHoras_vuelo() {
		return horas_vuelo;
	}

	public void setHoras_vuelo(Double horas_vuelo) {
		this.horas_vuelo = horas_vuelo;
	}
	
	
	
}
