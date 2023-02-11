package com.martinez.app.vuelos.dto;

public class TiemposVueloCreateDTO {
	
	private Long id;
	private Long origen;
	private Long destino;
	private Double tiempo;
	
	public TiemposVueloCreateDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrigen() {
		return origen;
	}

	public void setOrigen(Long origen) {
		this.origen = origen;
	}

	public Long getDestino() {
		return destino;
	}

	public void setDestino(Long destino) {
		this.destino = destino;
	}

	public Double getTiempo() {
		return tiempo;
	}

	public void setTiempo(Double tiempo) {
		this.tiempo = tiempo;
	}
	
	
}
