package com.hotel.reservas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.commons.controllers.CommonController;
import com.hotel.commons.dto.ReservaRequest;
import com.hotel.commons.dto.ReservaResponse;
import com.hotel.reservas.services.ReservaServices;

@RestController
public class ReservaController extends CommonController<ReservaRequest, ReservaResponse, ReservaServices>{

	public ReservaController(ReservaServices service) {
		super(service);
	}
	    
	    @GetMapping("/id-habitacion/{id}")
	    public boolean habitacionPresente(@PathVariable Long id) {
	        return service.habitacionPresente(id);
	    }
	    
	    @GetMapping("/id-huesped/{id}")
	    public boolean reservaPresente(@PathVariable Long id) {
	        return service.huespedPresente(id);
	    }
}
