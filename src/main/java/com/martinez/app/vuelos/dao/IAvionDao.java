package com.martinez.app.vuelos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martinez.app.vuelos.models.Avion;

public interface IAvionDao extends JpaRepository<Avion, Long>{

}
