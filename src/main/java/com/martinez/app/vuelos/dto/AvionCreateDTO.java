package com.martinez.app.vuelos.dto;

import jakarta.validation.constraints.Pattern;

public class AvionCreateDTO {
	
	private Long id;
	@Pattern(regexp = "^[a-zA-Z]{2}-[0-9]{4}",
			message = "El código debe cimplir con el formato XX-0000")
	private String codigo;
	private String tipoAvion;
	private String horasVuelo;
	private Long capacidadPasajeros;
	
	public AvionCreateDTO() {
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

	public String getTipoAvion() {
		return tipoAvion;
	}

	public void setTipoAvion(String tipoAvion) {
		this.tipoAvion = tipoAvion;
	}

	public String getHorasVuelo() {
		return horasVuelo;
	}

	public void setHorasVuelo(String horasVuelo) {
		this.horasVuelo = horasVuelo;
	}

	public Long getCapacidadPasajeros() {
		return capacidadPasajeros;
	}

	public void setCapacidadPasajeros(Long capacidadPasajeros) {
		this.capacidadPasajeros = capacidadPasajeros;
	}
	
	
}
