package com.martinez.app.vuelos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martinez.app.vuelos.dao.IPilotoDao;
import com.martinez.app.vuelos.dto.PilotoCreateDTO;
import com.martinez.app.vuelos.dto.PilotoListDTO;
import com.martinez.app.vuelos.models.Piloto;

@Service
public class PilotoService implements IService<PilotoListDTO, PilotoCreateDTO> {

	@Autowired
	private IPilotoDao pilotosDao;
	
	@Override
	public PilotoListDTO create(PilotoCreateDTO pilotoDTO) {
		Piloto piloto = this.dtoToEntity(pilotoDTO);
		Piloto pilotoNuevo = pilotosDao.save(piloto);
		return this.entityToDto(pilotoNuevo);
	}

	@Override
	public List<PilotoListDTO> getAll() {
		List<Piloto> listaPilotos = pilotosDao.findAll();
		List<PilotoListDTO> lista = listaPilotos.stream()
				.map(piloto -> this.entityToDto(piloto)).collect(Collectors.toList());
		return lista;
	}

	@Override
	public PilotoListDTO getById(long id) {
		Piloto piloto = pilotosDao.findById(id).orElseThrow(()-> new RuntimeException());
		return this.entityToDto(piloto);
	}

	@Override
	public PilotoListDTO update(PilotoCreateDTO pilotoDTO, long id) {
		Piloto piloto = pilotosDao.findById(id).orElseThrow(()-> new RuntimeException());
		piloto.setId(pilotoDTO.getId());
		piloto.setCodigo(pilotoDTO.getCodigo());
		piloto.setNombre_completo(pilotoDTO.getNombreCompleto());
		piloto.setSexo(pilotoDTO.getSexo());
		Piloto pilotoActualizado = pilotosDao.save(piloto);
		return this.entityToDto(pilotoActualizado);
	}

	@Override
	public void delete(long id) {
		Piloto piloto = pilotosDao.findById(id).orElseThrow(()-> new RuntimeException());
		pilotosDao.delete(piloto);
	}
	
	public Piloto dtoToEntity(PilotoCreateDTO pilotoDTO) {
		Piloto piloto = new Piloto();
		piloto.setId(pilotoDTO.getId());
		piloto.setCodigo(pilotoDTO.getCodigo());
		piloto.setNombre_completo(pilotoDTO.getNombreCompleto());
		piloto.setSexo(pilotoDTO.getSexo());
		return piloto;
	}
	
	public PilotoListDTO entityToDto(Piloto piloto) {
		PilotoListDTO pilotoDTO = new PilotoListDTO();
		pilotoDTO.setId(piloto.getId());
		pilotoDTO.setCodigo(piloto.getCodigo());
		pilotoDTO.setNombreCompleto(piloto.getNombre_completo());
		pilotoDTO.setSexo(piloto.getSexo());
		return pilotoDTO;
	}
	
}
