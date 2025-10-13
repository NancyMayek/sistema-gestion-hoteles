package com.hotel.reservas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.commons.dto.ReservaRequest;
import com.hotel.commons.dto.ReservaResponse;
import com.hotel.habitaciones.repositories.HabitacionRepository;
import com.hotel.reservas.mappers.ReservaMapper;
import com.hotel.reservas.repositories.ReservaRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ReservaServiceImpl implements ReservaServices {

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
