package com.martinez.app.vuelos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martinez.app.vuelos.models.Vuelo;

public interface IVueloDao extends JpaRepository<Vuelo, Long> {

}
