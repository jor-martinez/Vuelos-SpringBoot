package com.martinez.app.vuelos.services;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martinez.app.vuelos.dao.IAeropuertoDao;
import com.martinez.app.vuelos.dao.IAvionDao;
import com.martinez.app.vuelos.dao.IPilotoDao;
import com.martinez.app.vuelos.dao.ITiempoVuelosDao;
import com.martinez.app.vuelos.dao.IVueloDao;
import com.martinez.app.vuelos.dto.AeropuertoCreateDTO;
import com.martinez.app.vuelos.dto.AeropuertoListDTO;
import com.martinez.app.vuelos.dto.TiemposVueloCreateDTO;
import com.martinez.app.vuelos.dto.Vuelo1CreateDTO;
import com.martinez.app.vuelos.dto.Vuelo1ListDTO;
import com.martinez.app.vuelos.models.Aeropuerto;
import com.martinez.app.vuelos.models.Piloto;
import com.martinez.app.vuelos.models.TiempoVuelos;
import com.martinez.app.vuelos.models.Vuelo;

@Service
public class VueloService implements IService<Vuelo1ListDTO, Vuelo1CreateDTO> {

	@Autowired 
	private IVueloDao vuelosDao;
	
	@Autowired
	private IAeropuertoDao aerosDao;
	
	@Autowired
	private IPilotoDao pilotosDao;
	
	@Autowired
	private IAvionDao avionesDao;

	@Autowired
	private ITiempoVuelosDao tiemposDao;
	
	@Override
	public Vuelo1ListDTO create(Vuelo1CreateDTO vueloDTO) {
		Piloto piloto = pilotosDao.findById(vueloDTO.getPiloto()).orElseThrow(()-> new RuntimeException());
		List<TiempoVuelos> tiempos = tiemposDao.findAll();
		for(TiempoVuelos tv: tiempos) {
			//operaciones necesarias para identificar la combinacion de
			//aeropuertos que corresponde al vuelo que se va a agregar.
			//tomar el tiempo de ese registro y sumarlo al piloto que corresponde
		}
		//Double horas = piloto.getHoras_vuelo()+=vueloDTO
		piloto.setHoras_vuelo(null);		
		Vuelo vuelo = this.dtoToEntity(vueloDTO);
		Vuelo vueloNuevo = vuelosDao.save(vuelo);
		return this.entityToDto(vueloNuevo);
	}

	@Override
	public List<Vuelo1ListDTO> getAll() {
		List<Vuelo> listaVuelos = vuelosDao.findAll();
		List<Vuelo1ListDTO> lista = listaVuelos.stream()
				.map(vuelo -> this.entityToDto(vuelo)).collect(Collectors.toList());
		return lista;
	}

	@Override
	public Vuelo1ListDTO getById(long id) {
		Vuelo vuelo = vuelosDao.findById(id).orElseThrow(()-> new RuntimeException());
		return this.entityToDto(vuelo);
	}

	@Override
	public Vuelo1ListDTO update(Vuelo1CreateDTO vueloDTO, long id) {
		Vuelo vuelo = vuelosDao.findById(id).orElseThrow(()-> new RuntimeException());
		vuelo.setId(vueloDTO.getId());
		vuelo.setAeropuerto_origen_id(aerosDao.findById(vueloDTO.getAeroOrigen()).orElse(null));
		vuelo.setAeropuerto_destino_id(aerosDao.findById(vueloDTO.getAeroDestino()).orElse(null));
		vuelo.setAvion_id(avionesDao.findById(vueloDTO.getAvion()).orElse(null));
		vuelo.setPiloto_id(pilotosDao.findById(vueloDTO.getPiloto()).orElse(null));
		vuelo.setFecha_vuelo(Date.valueOf(vueloDTO.getFechaVuelo()));
		vuelo.setHora_vuelo(vueloDTO.getHoraVuelo());
		vuelo.setNum_vuelo(vueloDTO.getNumVuelo());
		vuelo.setEstatus(vueloDTO.getEstatus());
		Vuelo vueloActualizado = vuelosDao.save(vuelo);
		return this.entityToDto(vueloActualizado);
	}

	@Override
	public void delete(long id) {
		Vuelo vuelo = vuelosDao.findById(id).orElseThrow(()-> new RuntimeException());
		vuelosDao.delete(vuelo);
	}
	
	public Vuelo dtoToEntity(Vuelo1CreateDTO vueloDTO) {
		Vuelo vuelo = new Vuelo();
		vuelo.setId(vueloDTO.getId());
		vuelo.setAeropuerto_origen_id(aerosDao.findById(vueloDTO.getAeroOrigen()).orElse(null));
		vuelo.setAeropuerto_destino_id(aerosDao.findById(vueloDTO.getAeroDestino()).orElse(null));
		vuelo.setAvion_id(avionesDao.findById(vueloDTO.getAvion()).orElse(null));
		vuelo.setPiloto_id(pilotosDao.findById(vueloDTO.getPiloto()).orElse(null));
		vuelo.setFecha_vuelo(Date.valueOf(vueloDTO.getFechaVuelo()));
		vuelo.setHora_vuelo(vueloDTO.getHoraVuelo());
		vuelo.setNum_vuelo(vueloDTO.getNumVuelo());
		vuelo.setEstatus(vueloDTO.getEstatus());
		return vuelo;
	}
	
	public Vuelo1ListDTO entityToDto(Vuelo vuelo) {
		Vuelo1ListDTO vueloDTO = new Vuelo1ListDTO();
		vueloDTO.setId(vuelo.getId());
		vueloDTO.setAeroOrigen(vuelo.getAeropuerto_origen_id().getNombre());
		vueloDTO.setAeroDestino(vuelo.getAeropuerto_destino_id().getNombre());
		vueloDTO.setAvion(vuelo.getAvion_id().getCodigo());
		vueloDTO.setPiloto(vuelo.getPiloto_id().getNombre_completo());
		vueloDTO.setFechaVuelo(vuelo.getFecha_vuelo().toString());
		vueloDTO.setHoraVuelo(vuelo.getHora_vuelo());
		vueloDTO.setNumVuelo(vuelo.getNum_vuelo());
		vueloDTO.setEstatus(vuelo.getEstatus());
		return vueloDTO;
	}

}
