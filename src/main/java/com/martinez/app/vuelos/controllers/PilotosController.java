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

import com.martinez.app.vuelos.dto.PilotoCreateDTO;
import com.martinez.app.vuelos.dto.PilotoListDTO;
import com.martinez.app.vuelos.services.IService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pilotos")
@CrossOrigin(origins = "*")
public class PilotosController {

	@Autowired
	private IService<PilotoListDTO, PilotoCreateDTO> pilotosService;

	@GetMapping
	public List<PilotoListDTO> getListaPilotos(){
		return pilotosService.getAll();
	}
	
	@PostMapping
	public ResponseEntity<PilotoListDTO> guardarPiloto(@Valid @RequestBody PilotoCreateDTO pilotoDTO){
		return new ResponseEntity<>(pilotosService.create(pilotoDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PilotoListDTO> getPilotoById(@PathVariable(name = "id") long id){
		return new ResponseEntity<>(pilotosService.getById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PilotoListDTO> actualizarPiloto(@RequestBody PilotoCreateDTO pilotoDTO, @PathVariable(name = "id")long id){
		PilotoListDTO pilotoResp = pilotosService.update(pilotoDTO, id);
		return new ResponseEntity<>(pilotoResp, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> elimiarPiloto(@PathVariable(name = "id") long id){
		Map<String, String> mapa = new HashMap<>();	
		mapa.put("message", "Piloto eliminado con exito");
		pilotosService.delete(id);
		return new ResponseEntity<>(mapa, HttpStatus.OK);
	}
	
}
