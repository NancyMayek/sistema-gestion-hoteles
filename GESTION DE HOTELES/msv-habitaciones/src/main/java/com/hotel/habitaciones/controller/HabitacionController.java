package com.hotel.habitaciones.controller;


import org.springframework.web.bind.annotation.RestController;

import com.hotel.commons.controllers.CommonController;
import com.hotel.commons.dto.HabitacionRequest;
import com.hotel.commons.dto.HabitacionResponse;
import com.hotel.habitaciones.services.HabitacionService;

@RestController
public class HabitacionController extends CommonController<HabitacionRequest,HabitacionResponse, HabitacionService>{

	public HabitacionController(HabitacionService service) {
		super(service);
	}
	 
}
