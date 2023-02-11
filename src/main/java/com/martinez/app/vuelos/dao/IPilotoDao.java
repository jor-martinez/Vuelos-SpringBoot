package com.martinez.app.vuelos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martinez.app.vuelos.models.Piloto;

public interface IPilotoDao extends JpaRepository<Piloto, Long> {

}
