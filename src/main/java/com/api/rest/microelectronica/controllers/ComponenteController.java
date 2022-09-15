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
	@ApiOperation(value = "Inserción de un Componente", notes = "Devuelve el Componente agregado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Se ha Insertado el Componente Correctamente"),
			@ApiResponse(code = 201, message = "Se ha Insertado el Componente Correctamente"),
			@ApiResponse(code = 400, message = "No se pudo Insertar el Componente. Comprobar la Solicitud"),
			@ApiResponse(code = 401, message = "No está autorizado para insertar un Componente. Verificar credenciales"),
			@ApiResponse(code = 403, message = "No se ha podido insertar el Componente. El servidor ha denegado esta operación"),
			@ApiResponse(code = 404, message = "La Inserción del Componente no está Disponible ya que el recurso pedido no existe. Comprobar solicitud"),
			@ApiResponse(code = 405, message = "El recurso ha sido deshabilitado."),
			@ApiResponse(code = 407, message = "La autenticación debe estar hecha a partir de un proxy."),
			@ApiResponse(code = 408, message = "Se ha superado el tiempo de espera entre la solicitud y el servidor. Intentar nuevamente"),
			@ApiResponse(code = 409, message = "Se ha generado un conflicto en el servidor. Intentar nuevamente"),
			@ApiResponse(code = 410, message = "El Contenido solicitado se ha Eliminado del Servidor."),
			@ApiResponse(code = 422, message = "Se ha producido un error ya que los valores pasados no son correctos. Verificar campos"),
			@ApiResponse(code = 500, message = "Se ha producido un error interno en el Servidor"),
			@ApiResponse(code = 503, message = "Se ha producido un error de sobrecarga o mantenimiento en el Servidor. Intentar luego."),
			@ApiResponse(code = 505, message = "Versión HTTP no es soportada por el Servidor."),
			@ApiResponse(code = 507, message = "Almacenamiento Insuficiente por parte del Servidor.") })
	@PostMapping("/")
	public ResponseEntity<?> addComponente(@RequestBody Componente componente) {

		try {

			componenteService.addComponente(componente);

			return new ResponseEntity<Componente>(componente, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

	// ================
	// ===== PUT =====
	// ================
	@ApiOperation(value = "Actualización de un Componente", notes = "Devuelve el Componente Actualizado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Se ha Actualizado el Componente Correctamente"),
			@ApiResponse(code = 201, message = "Se ha Actualizado el Componente Correctamente"),
			@ApiResponse(code = 400, message = "No se pudo Actualizar el Componente. Comprobar la Solicitud"),
			@ApiResponse(code = 401, message = "No está autorizado para Actualizar un Componente. Verificar credenciales"),
			@ApiResponse(code = 403, message = "No se ha podido Actualizar el Componente. El servidor ha denegado esta operación"),
			@ApiResponse(code = 404, message = "La Actualización del Componente no está Disponible ya que el recurso pedido no existe. Comprobar solicitud"),
			@ApiResponse(code = 405, message = "El recurso ha sido deshabilitado."),
			@ApiResponse(code = 407, message = "La autenticación debe estar hecha a partir de un proxy."),
			@ApiResponse(code = 408, message = "Se ha superado el tiempo de espera entre la solicitud y el servidor. Intentar nuevamente"),
			@ApiResponse(code = 409, message = "Se ha generado un conflicto en el servidor. Intentar nuevamente"),
			@ApiResponse(code = 410, message = "El Contenido solicitado se ha Eliminado del Servidor."),
			@ApiResponse(code = 422, message = "Se ha producido un error ya que los valores pasados no son correctos. Verificar campos"),
			@ApiResponse(code = 500, message = "Se ha producido un error interno en el Servidor"),
			@ApiResponse(code = 503, message = "Se ha producido un error de sobrecarga o mantenimiento en el Servidor. Intentar luego."),
			@ApiResponse(code = 505, message = "Versión HTTP no es soportada por el Servidor."),
			@ApiResponse(code = 507, message = "Almacenamiento Insuficiente por parte del Servidor.") })
	@PutMapping("/{id}")
	public ResponseEntity<?> updateComponente(@PathVariable int id, @RequestBody Componente componente) {

		try {

			componenteService.updateComponente(id, componente);

			return new ResponseEntity<Componente>(componente, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

	// ==================
	// ===== DELETE =====
	// ==================
	@ApiOperation(value = "Eliminación de un Componente", notes = "Devuelve el Código/Estado HTTP")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Se ha Eliminado el Componente Correctamente"),
			@ApiResponse(code = 201, message = "Se ha Eliminado el Componente Correctamente"),
			@ApiResponse(code = 400, message = "No se pudo Eliminar el Componente. Comprobar la Solicitud"),
			@ApiResponse(code = 401, message = "No está autorizado para Eliminar un Componente. Verificar credenciales"),
			@ApiResponse(code = 403, message = "No se ha podido Eliminar el Componente. El servidor ha denegado esta operación"),
			@ApiResponse(code = 404, message = "La Eliminación del Componente no está Disponible ya que el recurso pedido no existe. Comprobar solicitud"),
			@ApiResponse(code = 405, message = "El recurso ha sido deshabilitado."),
			@ApiResponse(code = 407, message = "La autenticación debe estar hecha a partir de un proxy."),
			@ApiResponse(code = 408, message = "Se ha superado el tiempo de espera entre la solicitud y el servidor. Intentar nuevamente"),
			@ApiResponse(code = 409, message = "Se ha generado un conflicto en el servidor. Intentar nuevamente"),
			@ApiResponse(code = 410, message = "El Contenido solicitado se ha Eliminado del Servidor."),
			@ApiResponse(code = 422, message = "Se ha producido un error ya que los valores pasados no son correctos. Verificar campos"),
			@ApiResponse(code = 500, message = "Se ha producido un error interno en el Servidor"),
			@ApiResponse(code = 503, message = "Se ha producido un error de sobrecarga o mantenimiento en el Servidor. Intentar luego."),
			@ApiResponse(code = 505, message = "Versión HTTP no es soportada por el Servidor."),
			@ApiResponse(code = 507, message = "Almacenamiento Insuficiente por parte del Servidor.") })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteComponente(@PathVariable int id) {

		try {

			componenteService.deleteComponente(id);

			return new ResponseEntity<Componente>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

	// =================
	// ===== GET ALL ====
	// =================
	@ApiOperation(value = "Listado Paginado de Componentes", notes = "Devuelve el/los Componente/s paginados")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Se han Listado el/los Componente/s Correctamente"),
			@ApiResponse(code = 201, message = "Se han Listado el/los Componente/s Correctamente"),
			@ApiResponse(code = 400, message = "No se ha/han podido Listar los Componente. Comprobar la Solicitud"),
			@ApiResponse(code = 401, message = "No está autorizado para listar el/los Componente/s. Verificar credenciales"),
			@ApiResponse(code = 403, message = "No se ha/han podido listar el/los Componente. El servidor ha denegado esta operación"),
			@ApiResponse(code = 404, message = "El Listado de/los Componente/s no está Disponible ya que el recurso pedido no existe. Comprobar solicitud"),
			@ApiResponse(code = 405, message = "El recurso ha sido deshabilitado."),
			@ApiResponse(code = 407, message = "La autenticación debe estar hecha a partir de un proxy."),
			@ApiResponse(code = 408, message = "Se ha superado el tiempo de espera entre la solicitud y el servidor. Intentar nuevamente"),
			@ApiResponse(code = 409, message = "Se ha generado un conflicto en el servidor. Intentar nuevamente"),
			@ApiResponse(code = 410, message = "El Contenido solicitado se ha Eliminado del Servidor."),
			@ApiResponse(code = 422, message = "Se ha producido un error ya que los valores pasados no son correctos. Verificar campos"),
			@ApiResponse(code = 500, message = "Se ha producido un error interno en el Servidor"),
			@ApiResponse(code = 503, message = "Se ha producido un error de sobrecarga o mantenimiento en el Servidor. Intentar luego."),
			@ApiResponse(code = 505, message = "Versión HTTP no es soportada por el Servidor."),
			@ApiResponse(code = 507, message = "Almacenamiento Insuficiente por parte del Servidor.") })
	@GetMapping("/listado")
	public Page<Componente> getAllComponente(Pageable pageable) {

		return componenteService.getAllComponente(pageable);

	}

	// =========================
	// ===== GET ALL FILTER ====
	// ==========================
	@ApiOperation(value = "Listado Paginado de Componentes con Filtro", notes = "Devuelve el/los Componente/s paginados")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
			@ApiResponse(code = 201, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
			@ApiResponse(code = 400, message = "No se ha/han podido Listar los Componente con Filtro. Comprobar la Solicitud"),
			@ApiResponse(code = 401, message = "No está autorizado para listar el/los Componente/s con Filtro. Verificar credenciales"),
			@ApiResponse(code = 403, message = "No se ha/han podido listar el/los Componente con Filtro. El servidor ha denegado esta operación"),
			@ApiResponse(code = 404, message = "El Listado de/los Componente/s con Filtro no está Disponible ya que el recurso pedido no existe. Comprobar solicitud"),
			@ApiResponse(code = 405, message = "El recurso ha sido deshabilitado."),
			@ApiResponse(code = 407, message = "La autenticación debe estar hecha a partir de un proxy."),
			@ApiResponse(code = 408, message = "Se ha superado el tiempo de espera entre la solicitud y el servidor. Intentar nuevamente"),
			@ApiResponse(code = 409, message = "Se ha generado un conflicto en el servidor. Intentar nuevamente"),
			@ApiResponse(code = 410, message = "El Contenido solicitado se ha Eliminado del Servidor."),
			@ApiResponse(code = 422, message = "Se ha producido un error ya que los valores pasados no son correctos. Verificar campos"),
			@ApiResponse(code = 500, message = "Se ha producido un error interno en el Servidor"),
			@ApiResponse(code = 503, message = "Se ha producido un error de sobrecarga o mantenimiento en el Servidor. Intentar luego."),
			@ApiResponse(code = 505, message = "Versión HTTP no es soportada por el Servidor."),
			@ApiResponse(code = 507, message = "Almacenamiento Insuficiente por parte del Servidor.") })
	@GetMapping("/listado-filtro/{filtro}")
	public Page<Componente> getAllFilterComponente(@PathVariable String filtro, Pageable pageable) {

		return componenteService.getAllFilterComponente(filtro, pageable);

	}

	// ==================================================
	// ============= MÉTODOS HTTP BÚSQUEDA =============
	// ==================================================

	// ===============
	// ===== GET =====
	// ===============
	@ApiOperation(value = "Listado Paginado de Componentes con Filtro", notes = "Devuelve el/los Componente/s paginados")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
			@ApiResponse(code = 201, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
			@ApiResponse(code = 400, message = "No se ha/han podido Listar los Componente con Filtro. Comprobar la Solicitud"),
			@ApiResponse(code = 401, message = "No está autorizado para listar el/los Componente/s con Filtro. Verificar credenciales"),
			@ApiResponse(code = 403, message = "No se ha/han podido listar el/los Componente con Filtro. El servidor ha denegado esta operación"),
			@ApiResponse(code = 404, message = "El Listado de/los Componente/s con Filtro no está Disponible ya que el recurso pedido no existe. Comprobar solicitud"),
			@ApiResponse(code = 405, message = "El recurso ha sido deshabilitado."),
			@ApiResponse(code = 407, message = "La autenticación debe estar hecha a partir de un proxy."),
			@ApiResponse(code = 408, message = "Se ha superado el tiempo de espera entre la solicitud y el servidor. Intentar nuevamente"),
			@ApiResponse(code = 409, message = "Se ha generado un conflicto en el servidor. Intentar nuevamente"),
			@ApiResponse(code = 410, message = "El Contenido solicitado se ha Eliminado del Servidor."),
			@ApiResponse(code = 422, message = "Se ha producido un error ya que los valores pasados no son correctos. Verificar campos"),
			@ApiResponse(code = 500, message = "Se ha producido un error interno en el Servidor"),
			@ApiResponse(code = 503, message = "Se ha producido un error de sobrecarga o mantenimiento en el Servidor. Intentar luego."),
			@ApiResponse(code = 505, message = "Versión HTTP no es soportada por el Servidor."),
			@ApiResponse(code = 507, message = "Almacenamiento Insuficiente por parte del Servidor.") })
	@GetMapping("/id/{id}")
	public Componente getById(@PathVariable("id") int id) {

		return componenteService.findById(id);
	}

	// ===============
	// ===== GET =====
	// ===============
	@ApiOperation(value = "Listado Paginado de Componentes con Filtro", notes = "Devuelve el/los Componente/s paginados")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
			@ApiResponse(code = 201, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
			@ApiResponse(code = 400, message = "No se ha/han podido Listar los Componente con Filtro. Comprobar la Solicitud"),
			@ApiResponse(code = 401, message = "No está autorizado para listar el/los Componente/s con Filtro. Verificar credenciales"),
			@ApiResponse(code = 403, message = "No se ha/han podido listar el/los Componente con Filtro. El servidor ha denegado esta operación"),
			@ApiResponse(code = 404, message = "El Listado de/los Componente/s con Filtro no está Disponible ya que el recurso pedido no existe. Comprobar solicitud"),
			@ApiResponse(code = 405, message = "El recurso ha sido deshabilitado."),
			@ApiResponse(code = 407, message = "La autenticación debe estar hecha a partir de un proxy."),
			@ApiResponse(code = 408, message = "Se ha superado el tiempo de espera entre la solicitud y el servidor. Intentar nuevamente"),
			@ApiResponse(code = 409, message = "Se ha generado un conflicto en el servidor. Intentar nuevamente"),
			@ApiResponse(code = 410, message = "El Contenido solicitado se ha Eliminado del Servidor."),
			@ApiResponse(code = 422, message = "Se ha producido un error ya que los valores pasados no son correctos. Verificar campos"),
			@ApiResponse(code = 500, message = "Se ha producido un error interno en el Servidor"),
			@ApiResponse(code = 503, message = "Se ha producido un error de sobrecarga o mantenimiento en el Servidor. Intentar luego."),
			@ApiResponse(code = 505, message = "Versión HTTP no es soportada por el Servidor."),
			@ApiResponse(code = 507, message = "Almacenamiento Insuficiente por parte del Servidor.") })
	@GetMapping("/codigo/{codigo}")
	public Page<Componente> getByCodigo(@PathVariable("codigo") String codigo, Pageable pageable) {

		return componenteService.findByCodigo(codigo, pageable);
	}
	
	
	
	// ===============
		// ===== GET =====
		// ===============
	@ApiOperation(value = "Listado Paginado de Componentes con Filtro", notes = "Devuelve el/los Componente/s paginados")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
			@ApiResponse(code = 201, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
			@ApiResponse(code = 400, message = "No se ha/han podido Listar los Componente con Filtro. Comprobar la Solicitud"),
			@ApiResponse(code = 401, message = "No está autorizado para listar el/los Componente/s con Filtro. Verificar credenciales"),
			@ApiResponse(code = 403, message = "No se ha/han podido listar el/los Componente con Filtro. El servidor ha denegado esta operación"),
			@ApiResponse(code = 404, message = "El Listado de/los Componente/s con Filtro no está Disponible ya que el recurso pedido no existe. Comprobar solicitud"),
			@ApiResponse(code = 405, message = "El recurso ha sido deshabilitado."),
			@ApiResponse(code = 407, message = "La autenticación debe estar hecha a partir de un proxy."),
			@ApiResponse(code = 408, message = "Se ha superado el tiempo de espera entre la solicitud y el servidor. Intentar nuevamente"),
			@ApiResponse(code = 409, message = "Se ha generado un conflicto en el servidor. Intentar nuevamente"),
			@ApiResponse(code = 410, message = "El Contenido solicitado se ha Eliminado del Servidor."),
			@ApiResponse(code = 422, message = "Se ha producido un error ya que los valores pasados no son correctos. Verificar campos"),
			@ApiResponse(code = 500, message = "Se ha producido un error interno en el Servidor"),
			@ApiResponse(code = 503, message = "Se ha producido un error de sobrecarga o mantenimiento en el Servidor. Intentar luego."),
			@ApiResponse(code = 505, message = "Versión HTTP no es soportada por el Servidor."),
			@ApiResponse(code = 507, message = "Almacenamiento Insuficiente por parte del Servidor.") })
		@GetMapping("/imagen/{imagen}")
		public Page<Componente> getByImagen(@PathVariable("imagen") String imagen, Pageable pageable) {

			return componenteService.findByImagen(imagen, pageable);
		}
	
	// ===============
	// ===== GET =====
	// ===============
@ApiOperation(value = "Listado Paginado de Componentes con Filtro", notes = "Devuelve el/los Componente/s paginados")
@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
		@ApiResponse(code = 201, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
		@ApiResponse(code = 400, message = "No se ha/han podido Listar los Componente con Filtro. Comprobar la Solicitud"),
		@ApiResponse(code = 401, message = "No está autorizado para listar el/los Componente/s con Filtro. Verificar credenciales"),
		@ApiResponse(code = 403, message = "No se ha/han podido listar el/los Componente con Filtro. El servidor ha denegado esta operación"),
		@ApiResponse(code = 404, message = "El Listado de/los Componente/s con Filtro no está Disponible ya que el recurso pedido no existe. Comprobar solicitud"),
		@ApiResponse(code = 405, message = "El recurso ha sido deshabilitado."),
		@ApiResponse(code = 407, message = "La autenticación debe estar hecha a partir de un proxy."),
		@ApiResponse(code = 408, message = "Se ha superado el tiempo de espera entre la solicitud y el servidor. Intentar nuevamente"),
		@ApiResponse(code = 409, message = "Se ha generado un conflicto en el servidor. Intentar nuevamente"),
		@ApiResponse(code = 410, message = "El Contenido solicitado se ha Eliminado del Servidor."),
		@ApiResponse(code = 422, message = "Se ha producido un error ya que los valores pasados no son correctos. Verificar campos"),
		@ApiResponse(code = 500, message = "Se ha producido un error interno en el Servidor"),
		@ApiResponse(code = 503, message = "Se ha producido un error de sobrecarga o mantenimiento en el Servidor. Intentar luego."),
		@ApiResponse(code = 505, message = "Versión HTTP no es soportada por el Servidor."),
		@ApiResponse(code = 507, message = "Almacenamiento Insuficiente por parte del Servidor.") })
	@GetMapping("/datasheet/{datasheet}")
	public Page<Componente> getByDatasheet(@PathVariable("datasheet") String datasheet, Pageable pageable) {

		return componenteService.findByDatasheet(datasheet, pageable);
	}

//===============
	// ===== GET =====
	// ===============
@ApiOperation(value = "Listado Paginado de Componentes con Filtro", notes = "Devuelve el/los Componente/s paginados")
@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
		@ApiResponse(code = 201, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
		@ApiResponse(code = 400, message = "No se ha/han podido Listar los Componente con Filtro. Comprobar la Solicitud"),
		@ApiResponse(code = 401, message = "No está autorizado para listar el/los Componente/s con Filtro. Verificar credenciales"),
		@ApiResponse(code = 403, message = "No se ha/han podido listar el/los Componente con Filtro. El servidor ha denegado esta operación"),
		@ApiResponse(code = 404, message = "El Listado de/los Componente/s con Filtro no está Disponible ya que el recurso pedido no existe. Comprobar solicitud"),
		@ApiResponse(code = 405, message = "El recurso ha sido deshabilitado."),
		@ApiResponse(code = 407, message = "La autenticación debe estar hecha a partir de un proxy."),
		@ApiResponse(code = 408, message = "Se ha superado el tiempo de espera entre la solicitud y el servidor. Intentar nuevamente"),
		@ApiResponse(code = 409, message = "Se ha generado un conflicto en el servidor. Intentar nuevamente"),
		@ApiResponse(code = 410, message = "El Contenido solicitado se ha Eliminado del Servidor."),
		@ApiResponse(code = 422, message = "Se ha producido un error ya que los valores pasados no son correctos. Verificar campos"),
		@ApiResponse(code = 500, message = "Se ha producido un error interno en el Servidor"),
		@ApiResponse(code = 503, message = "Se ha producido un error de sobrecarga o mantenimiento en el Servidor. Intentar luego."),
		@ApiResponse(code = 505, message = "Versión HTTP no es soportada por el Servidor."),
		@ApiResponse(code = 507, message = "Almacenamiento Insuficiente por parte del Servidor.") })
	@GetMapping("/nro-de-pieza/{nroPieza}")
	public Page<Componente> getByNroPieza(@PathVariable("nroPieza") String nroPieza, Pageable pageable) {

		return componenteService.findByNroPieza(nroPieza, pageable);
	}

	// ===============
	// ===== GET =====
	// ===============
@ApiOperation(value = "Listado Paginado de Componentes con Filtro", notes = "Devuelve el/los Componente/s paginados")
@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
		@ApiResponse(code = 201, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
		@ApiResponse(code = 400, message = "No se ha/han podido Listar los Componente con Filtro. Comprobar la Solicitud"),
		@ApiResponse(code = 401, message = "No está autorizado para listar el/los Componente/s con Filtro. Verificar credenciales"),
		@ApiResponse(code = 403, message = "No se ha/han podido listar el/los Componente con Filtro. El servidor ha denegado esta operación"),
		@ApiResponse(code = 404, message = "El Listado de/los Componente/s con Filtro no está Disponible ya que el recurso pedido no existe. Comprobar solicitud"),
		@ApiResponse(code = 405, message = "El recurso ha sido deshabilitado."),
		@ApiResponse(code = 407, message = "La autenticación debe estar hecha a partir de un proxy."),
		@ApiResponse(code = 408, message = "Se ha superado el tiempo de espera entre la solicitud y el servidor. Intentar nuevamente"),
		@ApiResponse(code = 409, message = "Se ha generado un conflicto en el servidor. Intentar nuevamente"),
		@ApiResponse(code = 410, message = "El Contenido solicitado se ha Eliminado del Servidor."),
		@ApiResponse(code = 422, message = "Se ha producido un error ya que los valores pasados no son correctos. Verificar campos"),
		@ApiResponse(code = 500, message = "Se ha producido un error interno en el Servidor"),
		@ApiResponse(code = 503, message = "Se ha producido un error de sobrecarga o mantenimiento en el Servidor. Intentar luego."),
		@ApiResponse(code = 505, message = "Versión HTTP no es soportada por el Servidor."),
		@ApiResponse(code = 507, message = "Almacenamiento Insuficiente por parte del Servidor.") })
	@GetMapping("/categoria/{categoria}")
	public Page<Componente> getByCategoria(@PathVariable("categoria") String categoria, Pageable pageable) {

		return componenteService.findByCategoria(categoria, pageable);
	}

	// ===============
	// ===== GET =====
	// ===============
@ApiOperation(value = "Listado Paginado de Componentes con Filtro", notes = "Devuelve el/los Componente/s paginados")
@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
		@ApiResponse(code = 201, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
		@ApiResponse(code = 400, message = "No se ha/han podido Listar los Componente con Filtro. Comprobar la Solicitud"),
		@ApiResponse(code = 401, message = "No está autorizado para listar el/los Componente/s con Filtro. Verificar credenciales"),
		@ApiResponse(code = 403, message = "No se ha/han podido listar el/los Componente con Filtro. El servidor ha denegado esta operación"),
		@ApiResponse(code = 404, message = "El Listado de/los Componente/s con Filtro no está Disponible ya que el recurso pedido no existe. Comprobar solicitud"),
		@ApiResponse(code = 405, message = "El recurso ha sido deshabilitado."),
		@ApiResponse(code = 407, message = "La autenticación debe estar hecha a partir de un proxy."),
		@ApiResponse(code = 408, message = "Se ha superado el tiempo de espera entre la solicitud y el servidor. Intentar nuevamente"),
		@ApiResponse(code = 409, message = "Se ha generado un conflicto en el servidor. Intentar nuevamente"),
		@ApiResponse(code = 410, message = "El Contenido solicitado se ha Eliminado del Servidor."),
		@ApiResponse(code = 422, message = "Se ha producido un error ya que los valores pasados no son correctos. Verificar campos"),
		@ApiResponse(code = 500, message = "Se ha producido un error interno en el Servidor"),
		@ApiResponse(code = 503, message = "Se ha producido un error de sobrecarga o mantenimiento en el Servidor. Intentar luego."),
		@ApiResponse(code = 505, message = "Versión HTTP no es soportada por el Servidor."),
		@ApiResponse(code = 507, message = "Almacenamiento Insuficiente por parte del Servidor.") })
	@GetMapping("/descripcion/{descripcion}")
	public Page<Componente> getByDescripcion(@PathVariable("descripcion") String descripcion, Pageable pageable) {

		return componenteService.findByDescripcion(descripcion, pageable);
	}

	// ===============
	// ===== GET =====
	// ===============
@ApiOperation(value = "Listado Paginado de Componentes con Filtro", notes = "Devuelve el/los Componente/s paginados")
@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
		@ApiResponse(code = 201, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
		@ApiResponse(code = 400, message = "No se ha/han podido Listar los Componente con Filtro. Comprobar la Solicitud"),
		@ApiResponse(code = 401, message = "No está autorizado para listar el/los Componente/s con Filtro. Verificar credenciales"),
		@ApiResponse(code = 403, message = "No se ha/han podido listar el/los Componente con Filtro. El servidor ha denegado esta operación"),
		@ApiResponse(code = 404, message = "El Listado de/los Componente/s con Filtro no está Disponible ya que el recurso pedido no existe. Comprobar solicitud"),
		@ApiResponse(code = 405, message = "El recurso ha sido deshabilitado."),
		@ApiResponse(code = 407, message = "La autenticación debe estar hecha a partir de un proxy."),
		@ApiResponse(code = 408, message = "Se ha superado el tiempo de espera entre la solicitud y el servidor. Intentar nuevamente"),
		@ApiResponse(code = 409, message = "Se ha generado un conflicto en el servidor. Intentar nuevamente"),
		@ApiResponse(code = 410, message = "El Contenido solicitado se ha Eliminado del Servidor."),
		@ApiResponse(code = 422, message = "Se ha producido un error ya que los valores pasados no son correctos. Verificar campos"),
		@ApiResponse(code = 500, message = "Se ha producido un error interno en el Servidor"),
		@ApiResponse(code = 503, message = "Se ha producido un error de sobrecarga o mantenimiento en el Servidor. Intentar luego."),
		@ApiResponse(code = 505, message = "Versión HTTP no es soportada por el Servidor."),
		@ApiResponse(code = 507, message = "Almacenamiento Insuficiente por parte del Servidor.") })
	@GetMapping("/fabricante/{fabricante}")
	public Page<Componente> getByFabricante(@PathVariable("fabricante") String fabricante, Pageable pageable) {

		return componenteService.findByFabricante(fabricante, pageable);
	}

	// ===============
	// ===== GET =====
	// ===============
@ApiOperation(value = "Listado Paginado de Componentes con Filtro", notes = "Devuelve el/los Componente/s paginados")
@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
		@ApiResponse(code = 201, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
		@ApiResponse(code = 400, message = "No se ha/han podido Listar los Componente con Filtro. Comprobar la Solicitud"),
		@ApiResponse(code = 401, message = "No está autorizado para listar el/los Componente/s con Filtro. Verificar credenciales"),
		@ApiResponse(code = 403, message = "No se ha/han podido listar el/los Componente con Filtro. El servidor ha denegado esta operación"),
		@ApiResponse(code = 404, message = "El Listado de/los Componente/s con Filtro no está Disponible ya que el recurso pedido no existe. Comprobar solicitud"),
		@ApiResponse(code = 405, message = "El recurso ha sido deshabilitado."),
		@ApiResponse(code = 407, message = "La autenticación debe estar hecha a partir de un proxy."),
		@ApiResponse(code = 408, message = "Se ha superado el tiempo de espera entre la solicitud y el servidor. Intentar nuevamente"),
		@ApiResponse(code = 409, message = "Se ha generado un conflicto en el servidor. Intentar nuevamente"),
		@ApiResponse(code = 410, message = "El Contenido solicitado se ha Eliminado del Servidor."),
		@ApiResponse(code = 422, message = "Se ha producido un error ya que los valores pasados no son correctos. Verificar campos"),
		@ApiResponse(code = 500, message = "Se ha producido un error interno en el Servidor"),
		@ApiResponse(code = 503, message = "Se ha producido un error de sobrecarga o mantenimiento en el Servidor. Intentar luego."),
		@ApiResponse(code = 505, message = "Versión HTTP no es soportada por el Servidor."),
		@ApiResponse(code = 507, message = "Almacenamiento Insuficiente por parte del Servidor.") })
	@GetMapping("/stock/{stock}")
	public Page<Componente> getByStock(@PathVariable("stock") int stock, Pageable pageable) {

		return componenteService.findByStock(stock, pageable);
	}

	// ===============
	// ===== GET =====
	// ===============
@ApiOperation(value = "Listado Paginado de Componentes con Filtro", notes = "Devuelve el/los Componente/s paginados")
@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
		@ApiResponse(code = 201, message = "Se han Listado el/los Componente/s con Filtro Correctamente"),
		@ApiResponse(code = 400, message = "No se ha/han podido Listar los Componente con Filtro. Comprobar la Solicitud"),
		@ApiResponse(code = 401, message = "No está autorizado para listar el/los Componente/s con Filtro. Verificar credenciales"),
		@ApiResponse(code = 403, message = "No se ha/han podido listar el/los Componente con Filtro. El servidor ha denegado esta operación"),
		@ApiResponse(code = 404, message = "El Listado de/los Componente/s con Filtro no está Disponible ya que el recurso pedido no existe. Comprobar solicitud"),
		@ApiResponse(code = 405, message = "El recurso ha sido deshabilitado."),
		@ApiResponse(code = 407, message = "La autenticación debe estar hecha a partir de un proxy."),
		@ApiResponse(code = 408, message = "Se ha superado el tiempo de espera entre la solicitud y el servidor. Intentar nuevamente"),
		@ApiResponse(code = 409, message = "Se ha generado un conflicto en el servidor. Intentar nuevamente"),
		@ApiResponse(code = 410, message = "El Contenido solicitado se ha Eliminado del Servidor."),
		@ApiResponse(code = 422, message = "Se ha producido un error ya que los valores pasados no son correctos. Verificar campos"),
		@ApiResponse(code = 500, message = "Se ha producido un error interno en el Servidor"),
		@ApiResponse(code = 503, message = "Se ha producido un error de sobrecarga o mantenimiento en el Servidor. Intentar luego."),
		@ApiResponse(code = 505, message = "Versión HTTP no es soportada por el Servidor."),
		@ApiResponse(code = 507, message = "Almacenamiento Insuficiente por parte del Servidor.") })
	@GetMapping("/precio/{precio}")
	public Page<Componente> getByPrecio(@PathVariable("precio") double precio, Pageable pageable) {

		return componenteService.findByPrecio(precio, pageable);
	}

}
