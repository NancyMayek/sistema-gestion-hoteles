package com.hotel.habitaciones.controller;


import com.hotel.commons.controllers.CommonController;
import com.hotel.commons.dto.HabitacionRequest;
import com.hotel.commons.dto.HabitacionResponse;
import com.hotel.habitaciones.services.HabitacionService;

public class HabitacionController extends CommonController<HabitacionRequest,HabitacionResponse, HabitacionService>{

	public HabitacionController(HabitacionService service) {
		super(service);
	}
	 
}
