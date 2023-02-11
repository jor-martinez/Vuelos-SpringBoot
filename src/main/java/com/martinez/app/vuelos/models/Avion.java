package com.martinez.app.vuelos.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "aviones")
public class Avion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AVION")
	@SequenceGenerator(sequenceName = "sequence_avion", allocationSize = 1, name = "SEQ_AVION")
	@Column(name = "id_avion")
	private Long id;
	
	@Pattern(regexp = "^[a-zA-Z]{2}-[0-9]{4}",
			message = "El código debe cimplir con el formato XX-0000")
	private String codigo;
	private String tipo_avion;
	private String horas_vuelo;
	private Long capacidad_pasajeros;
	
	@OneToMany(mappedBy = "avion_id", cascade = CascadeType.ALL)
	private Set<Vuelo> vuelos;
	
	public Avion() {
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

	public String getTipo_avion() {
		return tipo_avion;
	}

	public void setTipo_avion(String tipo_avion) {
		this.tipo_avion = tipo_avion;
	}

	public String getHoras_vuelo() {
		return horas_vuelo;
	}

	public void setHoras_vuelo(String horas_vuelo) {
		this.horas_vuelo = horas_vuelo;
	}

	public Long getCapacidad_pasajeros() {
		return capacidad_pasajeros;
	}

	public void setCapacidad_pasajeros(Long capacidad_pasajeros) {
		this.capacidad_pasajeros = capacidad_pasajeros;
	}

	public Set<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(Set<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}
	
	
	
	
}
