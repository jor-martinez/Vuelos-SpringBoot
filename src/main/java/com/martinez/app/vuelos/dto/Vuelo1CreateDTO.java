package com.martinez.app.vuelos.dto;

import jakarta.validation.constraints.NotNull;

public class Vuelo1CreateDTO {
	
	private Long id;
	
	@NotNull(message = "Aeropuerto origen requerido")
	private Long aeroOrigen;
	
	@NotNull(message = "Aeropuerto destino requerido")
	private Long aeroDestino;
	
	@NotNull(message = "Piloto requerido")
	private Long piloto;
	
	@NotNull(message = "Avion requerido")
	private Long avion;
	
	@NotNull(message = "Fecha de vuelo requerido")
	private String fechaVuelo;
	
	@NotNull(message = "Hora de vuelo requerido")
	private String horaVuelo;
	
	private String numVuelo;
	
	@NotNull(message = "Estatus requerido")
	private String estatus;
	
	public Vuelo1CreateDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAeroOrigen() {
		return aeroOrigen;
	}

	public void setAeroOrigen(Long aeroOrigen) {
		this.aeroOrigen = aeroOrigen;
	}

	public Long getAeroDestino() {
		return aeroDestino;
	}

	public void setAeroDestino(Long aeroDestino) {
		this.aeroDestino = aeroDestino;
	}

	public Long getPiloto() {
		return piloto;
	}

	public void setPiloto(Long piloto) {
		this.piloto = piloto;
	}

	public Long getAvion() {
		return avion;
	}

	public void setAvion(Long avion) {
		this.avion = avion;
	}

	public String getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(String fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public String getHoraVuelo() {
		return horaVuelo;
	}

	public void setHoraVuelo(String horaVuelo) {
		this.horaVuelo = horaVuelo;
	}

	public String getNumVuelo() {
		return numVuelo;
	}

	public void setNumVuelo(String numVuelo) {
		this.numVuelo = numVuelo;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
	
}
