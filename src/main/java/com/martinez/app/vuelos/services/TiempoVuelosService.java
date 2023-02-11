package com.martinez.app.vuelos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martinez.app.vuelos.dao.IAeropuertoDao;
import com.martinez.app.vuelos.dao.ITiempoVuelosDao;
import com.martinez.app.vuelos.dto.TiemposVueloCreateDTO;
import com.martinez.app.vuelos.models.TiempoVuelos;

@Service
public class TiempoVuelosService implements IService<TiemposVueloCreateDTO, TiemposVueloCreateDTO> {

	@Autowired
	private ITiempoVuelosDao tiemposDao;
	
	@Autowired
	private IAeropuertoDao aeroDao;
	
	@Override
	public TiemposVueloCreateDTO create(TiemposVueloCreateDTO tiemposDTO) {
		TiempoVuelos tiempos = this.dtoToEntity(tiemposDTO);
		TiempoVuelos tiemposNuevo = tiemposDao.save(tiempos);
		return this.entityToDto(tiemposNuevo);
	}

	@Override
	public List<TiemposVueloCreateDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TiemposVueloCreateDTO getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TiemposVueloCreateDTO update(TiemposVueloCreateDTO obj, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	public TiempoVuelos dtoToEntity(TiemposVueloCreateDTO tiemposDTO) {
		TiempoVuelos tiempos = new TiempoVuelos();
		tiempos.setId(tiemposDTO.getId());
		tiempos.setOrigen(aeroDao.findById(tiemposDTO.getOrigen()).orElse(null));
		tiempos.setDestino(aeroDao.findById(tiemposDTO.getDestino()).orElse(null));
		tiempos.setTiempo(tiemposDTO.getTiempo());;
		return tiempos;
	}
	
	public TiemposVueloCreateDTO entityToDto(TiempoVuelos tiempos) {
		TiemposVueloCreateDTO tiemposDTO = new TiemposVueloCreateDTO();
		tiemposDTO.setId(tiempos.getId());
		tiemposDTO.setOrigen(tiempos.getOrigen().getId());
		tiemposDTO.setDestino(tiempos.getDestino().getId());
		tiemposDTO.setTiempo(tiempos.getTiempo());;
		return tiemposDTO;
	}
	
}
