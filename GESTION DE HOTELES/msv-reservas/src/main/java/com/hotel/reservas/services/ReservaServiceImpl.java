package com.hotel.reservas.services;

import java.util.List;
<<<<<<< HEAD

import org.springframework.stereotype.Service;

import com.hotel.commons.dto.ReservaRequest;
import com.hotel.commons.dto.ReservaResponse;
import com.hotel.habitaciones.repositories.HabitacionRepository;
import com.hotel.reservas.mappers.ReservaMapper;
import com.hotel.reservas.repositories.ReservaRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
=======
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.commons.clients.ReservaClient;
import com.hotel.commons.dto.ReservaRequest;
import com.hotel.commons.dto.ReservaResponse;
import com.hotel.commons.exceptions.EntidadRelacionadaException;
import com.hotel.habitaciones.repositories.HabitacionRepository;
import com.hotel.reservas.mappers.ReservaMapper;
import com.hotel.reservas.models.Reserva;
import com.hotel.reservas.repositories.ReservaRepository;

import lombok.AllArgsConstructor;
>>>>>>> ec5e25c65c39623364a59f5b23f958f0171a875d
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ReservaServiceImpl implements ReservaServices {

<<<<<<< HEAD
	 private final ReservaRepository reservaRepository;
	    private final HabitacionRepository habitacionRepository;
	    private final ReservaMapper reservaMapper;
	    
	@Override
    @Transactional(readOnly = true)
	public List<ReservaResponse> listar() {
		return reservaRepository.findAll().stream()
                .map(ReservaMapper::entityToResponse).toList();
	}

	@Override
	public ReservaResponse obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReservaResponse insertar(ReservaRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReservaResponse actualizar(ReservaRequest request, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
=======
    private final ReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper;
	private final ReservaClient reservaClient;

    
    @Override
    @Transactional(readOnly = true)
    public List<ReservaResponse> listar() {
        log.info("Listado de todas las reservas solicitadas");
        return reservaRepository.findAll().stream()
                .map(reservaMapper::entityToResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ReservaResponse obtenerPorId(Long id) {
    	log.info("Buscando Proveedor con id {}", id);
		Reserva reserva = getReservaOrThrow(id);
		return reservaMapper.entityToResponse(reserva);
    }

    private Reserva getReservaOrThrow(Long id) {
    	return reservaRepository.findById(id).orElseThrow(() -> 
        new NoSuchElementException("Proveedor no encontrado con el id: " + id)
    );
	}

	@Override
    public ReservaResponse insertar(ReservaRequest request) {
        log.info("Insertando nueva reserva para huésped: {}", request.huesped());
		return reservaMapper.entityToResponse(
				reservaRepository.save(reservaMapper.requestToEntity(request)));
       
    }

    @Override
    public ReservaResponse actualizar(ReservaRequest request, Long id) {
    	log.info("Buscando Reserva con id {}", id);
		Reserva reserva = getReservaOrThrow(id);
		log.info("Actualizando Proveedor con id {}", id);
		reserva.setHuesped(request.huesped());
		 reserva.setIdHabitacion(request.idHabitacion());       
		reserva.setFechaEntrada(request.fechaEntrada());
		reserva.setFechaSalida(request.fechaSalida());
		 reserva.setNoches(request.noches());
	        reserva.setTotal(request.total());
	        reserva.setIdEstado(request.idEstado());
	        


		return reservaMapper.entityToResponse(reservaRepository.save(reserva));
        }


    @Override
    public void eliminar(Long id) {
    	log.info("Eliminando Reserva con id {}", id);
		Reserva reserva = getReservaOrThrow(id);
		reservaRepository.delete(reserva);
		log.info("reserva eliminada: {}", reserva.getId());
}
    }
>>>>>>> ec5e25c65c39623364a59f5b23f958f0171a875d
