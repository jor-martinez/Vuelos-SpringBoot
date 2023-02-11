package com.martinez.app.vuelos.models;

import java.util.Date;

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
@Table(name = "vuelos")
public class Vuelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VUELO")
	@SequenceGenerator(sequenceName = "sequence_vuelo", allocationSize = 1, name = "SEQ_VUELO")
	@Column(name = "id_vuelo")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@NotNull(message = "Aeropuerto origen requerido")
	@JoinColumn(name = "aeropuerto_origen_id")
	private Aeropuerto aeropuerto_origen_id;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "aeropuerto_destino_id")
	@NotNull(message = "Aeropuerto destino requerido")
	private Aeropuerto aeropuerto_destino_id;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "piloto_id")
	@NotNull(message = "Piloto requerido")
	private Piloto piloto_id;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "avion_id")
	@NotNull(message = "Avion requerido")
	private Avion avion_id;
	
	@NotNull(message = "Hora de vuela requerido")
	private String hora_vuelo;
	
	@NotNull(message = "Numero de vuelo requerido")
	private String num_vuelo;
	
	@NotNull(message = "Fecha requerida")
	private Date fecha_vuelo;
	
	private String estatus;

	public Vuelo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aeropuerto getAeropuerto_origen_id() {
		return aeropuerto_origen_id;
	}

	public void setAeropuerto_origen_id(Aeropuerto aeropuerto_origen_id) {
		this.aeropuerto_origen_id = aeropuerto_origen_id;
	}

	public Aeropuerto getAeropuerto_destino_id() {
		return aeropuerto_destino_id;
	}

	public void setAeropuerto_destino_id(Aeropuerto aeropuerto_destino_id) {
		this.aeropuerto_destino_id = aeropuerto_destino_id;
	}

	public Piloto getPiloto_id() {
		return piloto_id;
	}

	public void setPiloto_id(Piloto piloto_id) {
		this.piloto_id = piloto_id;
	}

	public Avion getAvion_id() {
		return avion_id;
	}

	public void setAvion_id(Avion avion_id) {
		this.avion_id = avion_id;
	}

	public String getHora_vuelo() {
		return hora_vuelo;
	}

	public void setHora_vuelo(String hora_vuelo) {
		this.hora_vuelo = hora_vuelo;
	}

	public String getNum_vuelo() {
		return num_vuelo;
	}

	public void setNum_vuelo(String num_vuelo) {
		this.num_vuelo = num_vuelo;
	}

	public Date getFecha_vuelo() {
		return fecha_vuelo;
	}

	public void setFecha_vuelo(Date fecha_vuelo) {
		this.fecha_vuelo = fecha_vuelo;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
}
