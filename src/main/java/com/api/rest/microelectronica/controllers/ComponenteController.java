package com.api.rest.microelectronica.controllers;



import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.microelectronica.entities.Componente;
import com.api.rest.microelectronica.services.ComponenteService;




@RestController
@RequestMapping("/api/v1/componentes")
@CrossOrigin(origins = "*")
public class ComponenteController {

	@Autowired
	private ComponenteService componenteService;
	
	
	
			// ==============================================
			// ============= MÉTODOS HTTP CRUD ==============
			// ==============================================

			// ================
			// ===== POST =====
			// ================
			@ApiOperation(value = "Inserción de un Componente", notes="Devuelve el Componente agregado")
			@ApiResponses(value = {
					@ApiResponse(code = 200, message = "Se ha Insertado el Componente Correctamente"),
					@ApiResponse(code = 201, message = "Se ha Insertado el Componente Correctamente"),
					@ApiResponse(code = 400,  message = "No se pudo Insertar el Componente. Comprobar la Solicitud"),
					@ApiResponse(code = 401,  message = "No está autorizado para insertar un Componente. Verificar credenciales"),
					@ApiResponse(code = 403,  message = "No se ha podido insertar el Componente. El servidor ha denegado esta operación"),
					@ApiResponse(code = 404,  message = "La Inserción del Componente no está Disponible ya que el recurso pedido no existe. Comprobar solicitud"),
					@ApiResponse(code = 405,  message = "El recurso ha sido deshabilitado."),
					@ApiResponse(code = 407,  message = "La autenticación debe estar hecha a partir de un proxy."),
					@ApiResponse(code = 408,  message = "Se ha superado el tiempo de espera entre la solicitud y el servidor. Intentar nuevamente"),
					@ApiResponse(code = 409,  message = "Se ha generado un conflicto en el servidor. Intentar nuevamente"),
					@ApiResponse(code = 410,  message = "El Contenido solicitado se ha Eliminado del Servidor."),
					@ApiResponse(code = 422,  message = "Se ha producido un error ya que los valores pasados no son correctos. Verificar campos"),
					@ApiResponse(code = 500,  message = "Se ha producido un error interno en el Servidor"),
					@ApiResponse(code = 503,  message = "Se ha producido un error de sobrecarga o mantenimiento en el Servidor. Intentar luego."),
					@ApiResponse(code = 505,  message = "Versión HTTP no es soportada por el Servidor."),
					@ApiResponse(code = 507,  message = "Almacenamiento Insuficiente por parte del Servidor.")
					})
			@PostMapping("/")
			//@PreAuthorize("hasRole('ROLE_ADMIN')")
			public ResponseEntity<?> addComponente(@RequestBody Componente componente) {

				try {
					
					componenteService.addComponente(componente);

					return new ResponseEntity<Componente>(componente, HttpStatus.OK);

				} catch (Exception e) {
					return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
				}

			}
	
			
			// =================
			// ===== GET ALL ====
			// =================
			@ApiOperation(value = "Listado Paginado de Componentes", notes="Devuelve el/los Componente/s paginados")
			@ApiResponses(value = {
					@ApiResponse(code = 200, message = "Se han Listado el/los Componente/s Correctamente"),
					@ApiResponse(code = 201, message = "Se han Listado el/los Componente/s Correctamente"),
					@ApiResponse(code = 400,  message = "No se ha/han podido Listar los Componente. Comprobar la Solicitud"),
					@ApiResponse(code = 401,  message = "No está autorizado para listar el/los Componente/s. Verificar credenciales"),
					@ApiResponse(code = 403,  message = "No se ha/han podido listar el/los Componente. El servidor ha denegado esta operación"),
					@ApiResponse(code = 404,  message = "El Listado de/los Componente/s no está Disponible ya que el recurso pedido no existe. Comprobar solicitud"),
					@ApiResponse(code = 405,  message = "El recurso ha sido deshabilitado."),
					@ApiResponse(code = 407,  message = "La autenticación debe estar hecha a partir de un proxy."),
					@ApiResponse(code = 408,  message = "Se ha superado el tiempo de espera entre la solicitud y el servidor. Intentar nuevamente"),
					@ApiResponse(code = 409,  message = "Se ha generado un conflicto en el servidor. Intentar nuevamente"),
					@ApiResponse(code = 410,  message = "El Contenido solicitado se ha Eliminado del Servidor."),
					@ApiResponse(code = 422,  message = "Se ha producido un error ya que los valores pasados no son correctos. Verificar campos"),
					@ApiResponse(code = 500,  message = "Se ha producido un error interno en el Servidor"),
					@ApiResponse(code = 503,  message = "Se ha producido un error de sobrecarga o mantenimiento en el Servidor. Intentar luego."),
					@ApiResponse(code = 505,  message = "Versión HTTP no es soportada por el Servidor."),
					@ApiResponse(code = 507,  message = "Almacenamiento Insuficiente por parte del Servidor.")
					})
			@GetMapping("/listado")
			//@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			public Page<Componente> getAllComponente(Pageable pageable) {

				return componenteService.getAllComponente(pageable);

			}
	
}
