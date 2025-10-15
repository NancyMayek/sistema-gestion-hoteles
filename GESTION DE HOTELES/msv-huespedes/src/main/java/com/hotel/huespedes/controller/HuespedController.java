package com.hotel.huespedes.controller;

import org.springframework.web.bind.annotation.RestController;

import com.hotel.commons.controllers.CommonController;
import com.hotel.commons.dto.HuespedRequest;
import com.hotel.commons.dto.HuespedResponse;
import com.hotel.huespedes.services.HuespedService;

@RestController
public class HuespedController extends CommonController<HuespedRequest, HuespedResponse, HuespedService>{

	public HuespedController(HuespedService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}
	
	
}