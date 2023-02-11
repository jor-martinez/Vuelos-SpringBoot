package com.martinez.app.vuelos.dto;

public class AvionListDTO {
	
	private Long id;
	private String codigo;
	private String tipoAvion;
	private String horasVueloAcumuladas;
	private Long capacidadPasajeros;
	
	public AvionListDTO() {
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

	public String getHorasVueloAcumuladas() {
		return horasVueloAcumuladas;
	}

	public void setHorasVueloAcumuladas(String horasVueloAcumuladas) {
		this.horasVueloAcumuladas = horasVueloAcumuladas;
	}

	public Long getCapacidadPasajeros() {
		return capacidadPasajeros;
	}

	public void setCapacidadPasajeros(Long capacidadPasajeros) {
		this.capacidadPasajeros = capacidadPasajeros;
	}
	
	
}
