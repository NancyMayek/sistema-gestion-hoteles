package com.hotel.reservas.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotel.commons.dto.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ReservaExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        log.warn("Error en la integridad de un recurso: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
        		.body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }
}
