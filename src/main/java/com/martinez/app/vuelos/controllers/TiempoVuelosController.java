package com.martinez.app.vuelos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martinez.app.vuelos.dto.TiemposVueloCreateDTO;
import com.martinez.app.vuelos.services.IService;


@RestController
@RequestMapping("/api/tiempos")
@CrossOrigin(origins = "*")
public class TiempoVuelosController {
	
	@Autowired
	private IService<TiemposVueloCreateDTO, TiemposVueloCreateDTO> tiemposService;
	
	@GetMapping
	public List<TiemposVueloCreateDTO> getListaTiempos(){
		return tiemposService.getAll();
	}
	
	@PostMapping
	public ResponseEntity<TiemposVueloCreateDTO> guardarTiempo(@RequestBody TiemposVueloCreateDTO tiemposDTO){
		return new ResponseEntity<>(tiemposService.create(tiemposDTO), HttpStatus.CREATED);
	}
}
