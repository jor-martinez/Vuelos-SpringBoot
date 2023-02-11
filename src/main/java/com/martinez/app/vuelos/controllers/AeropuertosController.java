package com.martinez.app.vuelos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martinez.app.vuelos.dto.AeropuertoCreateDTO;
import com.martinez.app.vuelos.dto.AeropuertoListDTO;
import com.martinez.app.vuelos.services.IService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/aeropuertos")
@CrossOrigin(origins = "*")
public class AeropuertosController {
	
	@Autowired
	private IService<AeropuertoListDTO, AeropuertoCreateDTO> aerosService;

	@GetMapping
	public List<AeropuertoListDTO> getListaAeropuertos(){
		return aerosService.getAll();
	}
	
	@PostMapping
	public ResponseEntity<AeropuertoListDTO> guardarAeropuerto(@Valid @RequestBody AeropuertoCreateDTO aeroDTO){
		return new ResponseEntity<>(aerosService.create(aeroDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AeropuertoListDTO> getAeropuertoById(@PathVariable(name = "id") long id){
		return new ResponseEntity<>(aerosService.getById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AeropuertoListDTO> actualizarAeropuerto(@RequestBody AeropuertoCreateDTO aeroDTO, @PathVariable(name = "id")long id){
		AeropuertoListDTO aeroResp = aerosService.update(aeroDTO, id);
		return new ResponseEntity<>(aeroResp, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> elimiarAeropuerto(@PathVariable(name = "id") long id){
		Map<String, String> mapa = new HashMap<>();	
		mapa.put("message", "Aeropuerto eliminado con exito");
		aerosService.delete(id);
		return new ResponseEntity<>(mapa, HttpStatus.OK);
	}
}
