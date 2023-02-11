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

import com.martinez.app.vuelos.dto.AvionCreateDTO;
import com.martinez.app.vuelos.dto.AvionListDTO;
import com.martinez.app.vuelos.services.IService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/aviones")
@CrossOrigin(origins = "*")
public class AvionesController {
	
	@Autowired
	private IService<AvionListDTO, AvionCreateDTO> avionesService;

	@GetMapping
	public List<AvionListDTO> getListaAviones(){
		return avionesService.getAll();
	}
	
	@PostMapping
	public ResponseEntity<AvionListDTO> guardarAvion(@Valid @RequestBody AvionCreateDTO avionDTO){
		return new ResponseEntity<>(avionesService.create(avionDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AvionListDTO> getAvionById(@PathVariable(name = "id") long id){
		return new ResponseEntity<>(avionesService.getById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AvionListDTO> actualizarAvion(@RequestBody AvionCreateDTO avionDTO, @PathVariable(name = "id")long id){
		AvionListDTO avionResp = avionesService.update(avionDTO, id);
		return new ResponseEntity<>(avionResp, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> elimiarAvion(@PathVariable(name = "id") long id){
		Map<String, String> mapa = new HashMap<>();	
		mapa.put("message", "Avion eliminado con exito");
		avionesService.delete(id);
		return new ResponseEntity<>(mapa, HttpStatus.OK);
	}
	
}
