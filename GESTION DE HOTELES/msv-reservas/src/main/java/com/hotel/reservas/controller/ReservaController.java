package com.hotel.reservas.controller;

<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RestController;

>>>>>>> ec5e25c65c39623364a59f5b23f958f0171a875d
import com.hotel.commons.controllers.CommonController;
import com.hotel.commons.dto.ReservaRequest;
import com.hotel.commons.dto.ReservaResponse;
import com.hotel.reservas.services.ReservaServices;

<<<<<<< HEAD
=======
@RestController
>>>>>>> ec5e25c65c39623364a59f5b23f958f0171a875d
public class ReservaController extends CommonController<ReservaRequest, ReservaResponse, ReservaServices>{

	public ReservaController(ReservaServices service) {
		super(service);
	}
}
