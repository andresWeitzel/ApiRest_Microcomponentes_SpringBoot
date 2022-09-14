package com.api.rest.microelectronica.exc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.rest.microelectronica.exc.componentes.ComponenteIdMismatchExc;
import com.api.rest.microelectronica.exc.componentes.ComponenteNotFoundExc;


@RestControllerAdvice
public class CustomExcHandler extends ResponseEntityExceptionHandler{
	

	@ExceptionHandler({ComponenteNotFoundExc.class})
	protected ResponseEntity<Object> ProductoHandleNotFoundException(Exception ex, WebRequest request){
		
		return handleExceptionInternal(ex, "Componente/s No Encontrado", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler({ComponenteIdMismatchExc.class})
	protected ResponseEntity<Object> ProductoIdMismatchException(Exception ex, WebRequest request){
		
		return handleExceptionInternal(ex, "Componente/s Según el ID No Encontrado", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}


}