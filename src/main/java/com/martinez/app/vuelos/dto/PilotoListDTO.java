package com.martinez.app.vuelos.dto;

public class PilotoListDTO {
	
	private Long id;
	private String codigo;
	private String nombreCompleto;
	private String sexo;
	private Double horasVuelo;
	
	public PilotoListDTO() {
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
