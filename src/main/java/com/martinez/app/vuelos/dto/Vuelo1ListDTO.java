package com.martinez.app.vuelos.dto;

public class Vuelo1ListDTO {
	
	private Long id;
	private String aeroOrigen;
	private String aeroDestino;
	private String piloto;
	private String avion;
	private String fechaVuelo;
	private String horaVuelo;
	private String numVuelo;
	private String estatus;
	
	public Vuelo1ListDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAeroOrigen() {
		return aeroOrigen;
	}

	public void setAeroOrigen(String aeroOrigen) {
		this.aeroOrigen = aeroOrigen;
	}

	public String getAeroDestino() {
		return aeroDestino;
	}

	public void setAeroDestino(String aeroDestino) {
		this.aeroDestino = aeroDestino;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	public String getAvion() {
		return avion;
	}

	public void setAvion(String avion) {
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
