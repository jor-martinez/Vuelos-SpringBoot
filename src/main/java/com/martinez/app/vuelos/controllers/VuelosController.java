package com.martinez.app.vuelos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martinez.app.vuelos.dto.Vuelo1CreateDTO;
import com.martinez.app.vuelos.dto.Vuelo1ListDTO;
import com.martinez.app.vuelos.services.IService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vuelos")
@CrossOrigin(origins = "*")
public class VuelosController {
	
	@Autowired
	private IService<Vuelo1ListDTO, Vuelo1CreateDTO> vuelosService;
	
	@GetMapping
	public List<Vuelo1ListDTO> getListaVuelo(){
		return vuelosService.getAll();
	}
	
	@PostMapping
	public ResponseEntity<Vuelo1ListDTO> guardarVuelo(@Valid @RequestBody Vuelo1CreateDTO vueloDTO){
		return new ResponseEntity<>(vuelosService.create(vueloDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vuelo1ListDTO> getVueloById(@PathVariable(name = "id") long id){
		return new ResponseEntity<>(vuelosService.getById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Vuelo1ListDTO> actualizarVuelo(@RequestBody Vuelo1CreateDTO vueloDTO, @PathVariable(name = "id")long id){
		Vuelo1ListDTO vueloResp = vuelosService.update(vueloDTO, id);
		return new ResponseEntity<>(vueloResp, HttpStatus.CREATED);
	}
	
	/*
	 * @DeleteMapping("/{id}") public ResponseEntity<Map<String, String>>
	 * elimiarVuelo(@PathVariable(name = "id") long id){ Map<String, String> mapa =
	 * new HashMap<>(); mapa.put("message", "Vuelo eliminado con exito");
	 * vuelosService.delete(id); return new ResponseEntity<>(mapa, HttpStatus.OK); }
	 */
	
}
