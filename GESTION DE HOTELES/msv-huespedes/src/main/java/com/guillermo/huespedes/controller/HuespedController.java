package com.guillermo.huespedes.controller;

import org.springframework.web.bind.annotation.RestController;

import com.guillermo.huespedes.services.HuespedService;
import com.hotel.commons.controllers.CommonController;
import com.hotel.commons.dto.HuespedRequest;
import com.hotel.commons.dto.HuespedResponse;

@RestController
public class HuespedController extends CommonController<HuespedRequest, HuespedResponse, HuespedService>{

	public HuespedController(HuespedService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}
	
	
}