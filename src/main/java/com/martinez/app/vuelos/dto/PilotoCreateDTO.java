package com.martinez.app.vuelos.dto;

import jakarta.validation.constraints.Pattern;

public class PilotoCreateDTO {
	
	private Long id;
	@Pattern(regexp = "^[a-zA-Z]{2}-[0-9]{4}",
			message = "El código debe cimplir con el formato XX-0000")
	private String codigo;
	private String nombreCompleto;
	private String sexo;
	private Double horasVuelo;
	
	public PilotoCreateDTO() {
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

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Double getHorasVuelo() {
		return horasVuelo;
	}

	public void setHorasVuelo(Double horasVuelo) {
		this.horasVuelo = horasVuelo;
	}
	
	
}
