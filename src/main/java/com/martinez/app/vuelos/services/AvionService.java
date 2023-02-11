package com.martinez.app.vuelos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martinez.app.vuelos.dao.IAvionDao;
import com.martinez.app.vuelos.dto.AvionCreateDTO;
import com.martinez.app.vuelos.dto.AvionListDTO;
import com.martinez.app.vuelos.models.Avion;

@Service
public class AvionService implements IService<AvionListDTO, AvionCreateDTO> {
	
	@Autowired
	private IAvionDao avionesDao;

	@Override
	public AvionListDTO create(AvionCreateDTO avionDTO) {
		Avion avion = this.dtoToEntity(avionDTO);
		Avion avionNuevo = avionesDao.save(avion);
		return this.entityToDto(avionNuevo);
	}

	@Override
	public List<AvionListDTO> getAll() {
		List<Avion> listaAviones = avionesDao.findAll();
		List<AvionListDTO> lista = listaAviones.stream()
				.map(avion -> this.entityToDto(avion)).collect(Collectors.toList());
		return lista;
	}

	@Override
	public AvionListDTO getById(long id) {
		Avion avion = avionesDao.findById(id).orElseThrow(()-> new RuntimeException());
		return this.entityToDto(avion);
	}

	@Override
	public AvionListDTO update(AvionCreateDTO avionDTO, long id) {
		// TODO Auto-generated method stub
		Avion avion = avionesDao.findById(id).orElseThrow(()-> new RuntimeException());
		avion.setId(avionDTO.getId());
		avion.setCodigo(avionDTO.getCodigo());
		avion.setTipo_avion(avionDTO.getTipoAvion());
		avion.setCapacidad_pasajeros(avionDTO.getCapacidadPasajeros());
		Avion avionActualizado = avionesDao.save(avion);
		return this.entityToDto(avionActualizado);
	}

	@Override
	public void delete(long id) {
		Avion avion = avionesDao.findById(id).orElseThrow(()-> new RuntimeException());
		avionesDao.delete(avion);
	}
	
	public Avion dtoToEntity(AvionCreateDTO avionDTO) {
		Avion avion = new Avion();
		avion.setId(avionDTO.getId());
		avion.setCodigo(avionDTO.getCodigo());
		avion.setTipo_avion(avionDTO.getTipoAvion());
		avion.setHoras_vuelo(avionDTO.getHorasVuelo());
		avion.setCapacidad_pasajeros(avionDTO.getCapacidadPasajeros());
		return avion;
	}
	
	public AvionListDTO entityToDto(Avion avion) {
		AvionListDTO avionDTO = new AvionListDTO();
		avionDTO.setId(avion.getId());
		avionDTO.setCodigo(avion.getCodigo());
		avionDTO.setTipoAvion(avion.getTipo_avion());
		avionDTO.setHorasVueloAcumuladas(avion.getHoras_vuelo());
		avionDTO.setCapacidadPasajeros(avion.getCapacidad_pasajeros());
		return avionDTO;
	}
}
