package com.martinez.app.vuelos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tiempo_vuelos")
public class TiempoVuelos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIEMPOS")
	@SequenceGenerator(sequenceName = "sequence_tiempos", allocationSize = 1, name = "SEQ_TIEMPO")
	@Column(name = "id_tiempo_vuelos")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "origen")
	private Aeropuerto origen;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "destino")
	private Aeropuerto destino;
	
	@NotNull(message = "El tiempo es requerido")
	private Double tiempo;
	
	public TiempoVuelos() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aeropuerto getOrigen() {
		return origen;
	}

	public void setOrigen(Aeropuerto origen) {
		this.origen = origen;
	}

	public Aeropuerto getDestino() {
		return destino;
	}

	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}

	public Double getTiempo() {
		return tiempo;
	}

	public void setTiempo(Double tiempo) {
		this.tiempo = tiempo;
	}
	
	
}
