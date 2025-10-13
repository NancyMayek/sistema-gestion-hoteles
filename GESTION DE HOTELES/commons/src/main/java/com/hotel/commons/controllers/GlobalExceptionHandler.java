package com.hotel.commons.controllers;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.hotel.commons.dto.ErrorResponse;
import com.hotel.commons.exceptions.EntidadRelacionadaException;

import feign.FeignException;
import feign.RetryableException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	//manera de como gestionar las excepciones 
	//metodo para atrapar una excepcion
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handleConstrainViolationException(ConstraintViolationException e){
		log.error("Violacion de restriccion: {}", e.getMessage());
		return ResponseEntity.badRequest()
				.body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Violacion de restriccion:" +  e.getMessage()));
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
	    log.warn("Error de argumento ilegal: {}", e.getMessage());
	    return ResponseEntity.badRequest()
	            .body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)//VALIDAR LOS DTO NOT NULL NOT BLACK CAEN AQUI
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String mensaje = e.getBindingResult().getFieldErrors().stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .findFirst()
                .orElse("Error de validación en los datos enviados");
        log.error("Error de validación de argumentos: {}", mensaje);
        return ResponseEntity.badRequest()
        		.body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), mensaje));
    }

    @ExceptionHandler(NoSuchElementException.class)//ES EL EQUIVALENTE A UN 404 NO HAY EL RECURSO
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException e) {
        log.warn("No se encontró recurso: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
        		.body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }
    
    @ExceptionHandler(NoResourceFoundException.class)//PATRON NO ESTATICO POR EJEMPLO UNA URL QUE PUSISTE MAL 
    public ResponseEntity<ErrorResponse> handleNoResourceFoundException(NoResourceFoundException e) {
        log.warn("No se encontró recurso: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
        		.body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }
    
    @ExceptionHandler(EntidadRelacionadaException.class)//PATRON NO ESTATICO POR EJEMPLO UNA URL QUE PUSISTE MAL 
    public ResponseEntity<ErrorResponse> handleEntidadRelacionadaException(EntidadRelacionadaException e) {
        log.warn("Error al eliminar un recurso: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
        		.body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }

    @ExceptionHandler(Exception.class)//GENERAL
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception e) {
        log.error("Error interno del servidor: {}", e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        		.body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
        				"Error interno del servidor. Por favor, contacte al administrador."));
    }
    
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorResponse> handleGenericFeignException(FeignException e) {
        log.error("Error en la comunicación Feign: " + e.getMessage());

        int status = e.status() > 0 ? e.status() : HttpStatus.INTERNAL_SERVER_ERROR.value();
        String message = switch (status) {
            case 400 -> "Solicitud incorrecta al servicio remoto.";
            case 401 -> "No autorizado para acceder al servicio remoto.";
            case 403 -> "Acceso prohibido al servicio remoto.";
            case 404 -> "Recurso no encontrado en el servicio remoto.";
            case 503 -> "Servicio remoto no disponible.";
            default -> "Error al comunicarse con el servicio remoto.";
        };
        ErrorResponse response = new ErrorResponse(status, message);

        return ResponseEntity.status(status).body(response);
    }
    
    @ExceptionHandler(RetryableException.class)
    public ResponseEntity<ErrorResponse> handleRetryable(RetryableException e) {
    	log.error("Servicio remoto no disponible o no responde: " + e.getMessage());
    	ErrorResponse response = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(),
    			"Servicio remoto no disponible o no respond");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
    }
}

