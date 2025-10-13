package com.hotel.reservas.controller;

import com.hotel.commons.controllers.CommonController;
import com.hotel.commons.dto.ReservaRequest;
import com.hotel.commons.dto.ReservaResponse;
import com.hotel.reservas.services.ReservaServices;

public class ReservaController extends CommonController<ReservaRequest, ReservaResponse, ReservaServices>{

	public ReservaController(ReservaServices service) {
		super(service);
	}
}
