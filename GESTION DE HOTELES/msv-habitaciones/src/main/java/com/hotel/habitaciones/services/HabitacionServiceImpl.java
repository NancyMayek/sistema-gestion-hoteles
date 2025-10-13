package com.hotel.habitaciones.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hotel.commons.dto.HabitacionRequest;
import com.hotel.commons.dto.HabitacionResponse;
import com.hotel.habitaciones.mappers.HabitacionMapper;
import com.hotel.habitaciones.models.Habitacion;
import com.hotel.habitaciones.repositories.HabitacionRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class HabitacionServiceImpl implements HabitacionService{

	private final HabitacionRepository habitacionRepository;
	private final HabitacionMapper habitacionMapper;
	
	@Override
	public List<HabitacionResponse> listar() {
		log.info("Listado de todas las habitaciones solicitada");
		return habitacionRepository.findAll().stream()
		.map(habitacionMapper::entityToResponse).toList();
	}

	@Override
	public HabitacionResponse obtenerPorId(Long id) {
		log.info("Buscando habitacion con id {}", id);
		Habitacion habitacion = getHabitacionOrThrow(id);
		return habitacionMapper.entityToResponse(habitacion);
	}

	@Override
	public HabitacionResponse insertar(HabitacionRequest request) {
		log.info("Insertando nueva Habitacion con numero {}", request.numero());
		
		 if (habitacionRepository.existsByNumero(request.numero())) {
			 throw new DataIntegrityViolationException("Ya existe una habitación con el número: " + request.numero());
	        }
		
		return habitacionMapper.entityToResponse(
				habitacionRepository.save(habitacionMapper.requestToEntity(request))
		);
	}

	@Override
	public HabitacionResponse actualizar(HabitacionRequest request, Long id) {
		log.info("Buscando habitacion con id {}", id);
		Habitacion habitacion = getHabitacionOrThrow(id);
		log.info("Actualizando la habitacion con id {}", id);
		habitacion.setNumero(request.numero());
		habitacion.setTipo(request.tipo());
		habitacion.setDescripcion(request.descripcion());
		habitacion.setPrecio(request.precio());
		habitacion.setCapacidad(request.capacidad());
		habitacion.setIdEstado(request.idEstado());;
		
		return habitacionMapper.entityToResponse(habitacionRepository.save(habitacion));
	}

	@Override
	public void eliminar(Long id) {
		log.info("Eliminando Habitacion con id {}", id);
		Habitacion habitacion = getHabitacionOrThrow(id);
		habitacionRepository.delete(habitacion);
		log.info("Numero de Habitacion eliminada: {}", habitacion.getNumero());
	}
	
	private Habitacion getHabitacionOrThrow(Long id) {
        return habitacionRepository.findById(id).orElseThrow(() -> 
            new NoSuchElementException("Habitacion no encontrado con el id: " + id)
        );
    }

}
