package com.martinez.app.vuelos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martinez.app.vuelos.dao.IAeropuertoDao;
import com.martinez.app.vuelos.dto.AeropuertoCreateDTO;
import com.martinez.app.vuelos.dto.AeropuertoListDTO;
import com.martinez.app.vuelos.models.Aeropuerto;

@Service
public class AeropuertoService implements IService<AeropuertoListDTO, AeropuertoCreateDTO> {

	@Autowired
	private IAeropuertoDao aerosDao;
	
	@Override
	public AeropuertoListDTO create(AeropuertoCreateDTO aeroDTO) {
		Aeropuerto aeropuerto = this.dtoToEntity(aeroDTO);
		Aeropuerto aeroNuevo = aerosDao.save(aeropuerto);
		return this.entityToDto(aeroNuevo);
	}

	@Override
	public List<AeropuertoListDTO> getAll() {
		List<Aeropuerto> listaAeros = aerosDao.findAll();
		List<AeropuertoListDTO> lista = listaAeros.stream()
				.map(aero -> this.entityToDto(aero)).collect(Collectors.toList());
		return lista;
	}

	@Override
	public AeropuertoListDTO getById(long id) {
		Aeropuerto aero = aerosDao.findById(id).orElseThrow(()-> new RuntimeException());
		return this.entityToDto(aero);
	}

	@Override
	public AeropuertoListDTO update(AeropuertoCreateDTO aeroDTO, long id) {
		Aeropuerto aero = aerosDao.findById(id).orElseThrow(()-> new RuntimeException());
		aero.setId(aeroDTO.getId());
		aero.setNombre(aeroDTO.getNombre());
		aero.setMunicipio(aeroDTO.getMunicipio());
		aero.setEstado(aeroDTO.getEstado());
		aero.setPais(aeroDTO.getPais());
		Aeropuerto aeroActualizado = aerosDao.save(aero);
		return this.entityToDto(aeroActualizado);
	}

	@Override
	public void delete(long id) {
		Aeropuerto aero = aerosDao.findById(id).orElseThrow(()-> new RuntimeException());
		aerosDao.delete(aero);
	}
	
	public Aeropuerto dtoToEntity(AeropuertoCreateDTO aeroDTO) {
		Aeropuerto aero = new Aeropuerto();
		aero.setId(aeroDTO.getId());
		aero.setNombre(aeroDTO.getNombre());
		aero.setMunicipio(aeroDTO.getMunicipio());
		aero.setEstado(aeroDTO.getEstado());
		aero.setPais(aeroDTO.getPais());
		return aero;
	}
	
	public AeropuertoListDTO entityToDto(Aeropuerto aero) {
		AeropuertoListDTO aeroDTO = new AeropuertoListDTO();
		aeroDTO.setId(aero.getId());
		aeroDTO.setNombre(aero.getNombre());
		aeroDTO.setMunicipio(aero.getMunicipio());
		aeroDTO.setEstado(aero.getEstado());
		aeroDTO.setPais(aero.getPais());
		return aeroDTO;
	}
}
