package com.martinez.app.vuelos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martinez.app.vuelos.models.Aeropuerto;

public interface IAeropuertoDao extends JpaRepository<Aeropuerto, Long>{

}
