package com.api.rest.microelectronica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.api.rest.microelectronica.entities.Componente;
import com.api.rest.microelectronica.exc.componentes.ComponenteIdMismatchExc;
import com.api.rest.microelectronica.exc.componentes.ComponenteNotFoundExc;
import com.api.rest.microelectronica.repositories.I_ComponenteRepository;

import java.util.Optional;

import org.apache.logging.log4j.Logger;

@Service
public class ComponenteService {

	// ============ INYEC. DEP ============
		@Autowired
		private I_ComponenteRepository iComponenteRepository;

		// =============== LOGS ====================
		private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(ComponenteService.class);

		// =============== MÉTODOS CRUD ====================

		// ==================
		// ===== INSERT =====
		// ==================
		public void addComponente(Componente componente) {
			try {
				if (componente == null) {
					logger.error("ERROR addComponente : EL COMPONENTE " + componente + " ES NULO!!");
					throw new ComponenteNotFoundExc("EL COMPONENTE ES NULO");
				} else if (componente.getCodigo() == "" || componente.getImagen() == "" 
						|| componente.getNroPieza() == "" || componente.getCategoria() == ""
						|| componente.getDescripcion() == "" || componente.getFabricante() == ""
						|| componente.getStock() == 0 || componente.getPrecio() == 0
						)
						 {
					logger.error(
							"ERROR addComponente : LOS VALORES DE LOS CAMPOS DEL COMPONENTE " + componente + " NO SON VÁLIDOS!!");
					throw new ComponenteNotFoundExc("VALORES DE CAMPOS NO VÁLIDOS");
				} else {


					iComponenteRepository.save(componente);

					logger.info("SE HA INSERTADO CORRECTAMENTE EL COMPONENTE CON EL ID " + componente.getId());
				}
			} catch (Exception e) {
				logger.error(
						"ERROR addComponente : EL COMPONENTE" + componente + " NO SE HA INSERTADO EN LA DB!! CAUSADO POR " + e);
				throw new ComponenteNotFoundExc("NO SE PUDO AGREGAR EL COMPONENTE. ", e, false, true);
			}
		}
	
		// ==================
		// ===== UPDATE =====
		// ==================
		public void updateComponente(int id, Componente componente) {
			try {

				Optional<Componente> componenteDb = Optional.ofNullable(this.iComponenteRepository.findById(id));

				System.out.println(componente);

				System.out.println(componente.getId());

				System.out.println(componenteDb);

				if ( id <= 0 || iComponenteRepository.findById(id).getId() != id) {
					logger.error("ERROR updateComponente : EL ID  NO ES VÁLIDO!!");
					throw new ComponenteNotFoundExc("EL ID NO ES VÁLIDO");

				} else if (componenteDb.isEmpty() || componenteDb.get() == null) {
					logger.error("ERROR updateComponente : EL COMPONENTE " + componente + " ES NULO O VACIO!!");
					throw new ComponenteNotFoundExc("EL COMPONENTE ES NULO O VACIO");

				} else if (componente.getCodigo() == "" || componente.getImagen() == "" 
						|| componente.getNroPieza() == "" || componente.getCategoria() == ""
						|| componente.getDescripcion() == "" || componente.getFabricante() == ""
						|| componente.getStock() == 0 || componente.getPrecio() == 0
						)
				
				{
					logger.error(
							"ERROR updateComponente : LOS VALORES DE LOS CAMPOS DEL COMPONENTE " + componente + " NO SON VÁLIDOS!!");
					throw new ComponenteNotFoundExc("VALORES DE CAMPOS NO VÁLIDOS");

				} else {

					Componente componenteUpdated = componenteDb.get();

					
					System.out.println(componenteUpdated);

					componenteUpdated.setId(id);
					componenteUpdated.setCodigo(componente.getCodigo());
					componenteUpdated.setImagen(componente.getImagen());
					componenteUpdated.setDatasheet(componente.getDatasheet());
					componenteUpdated.setNroPieza(componente.getNroPieza());
					componenteUpdated.setCategoria(componente.getCategoria());
					componenteUpdated.setDescripcion(componente.getDescripcion());
					componenteUpdated.setFabricante(componente.getFabricante());
					componenteUpdated.setStock(componente.getStock());
					componenteUpdated.setPrecio(componente.getPrecio());

					System.out.println(componenteUpdated);

					iComponenteRepository.save(componenteUpdated);

					logger.info("SE HA ACTUALIZADO CORRECTAMENTE EL COMPONENTE  " + componenteUpdated);

				}
			} catch (Exception e) {
				logger.error("ERROR updateComponente : EL COMPONENTE " + componente
						+ " NO SE HA ACTUALIZADO EN LA DB!!CAUSADO POR " + e);
				throw new ComponenteNotFoundExc(
						"NO SE PUDO ACTUALIZAR EL COMPONENTE. CÓDIGO/NOMBRE REPETIDO O PRODUCTO NO ENCONTRADO! ", e, true,
						true);
			}
		}
		// ==================
		// ===== DELETE =====
		// ==================
		public void deleteComponente(int id) {
			try {
				if (id <= 0 || iComponenteRepository.findById(id).getId() != id) {

					logger.error("ERROR deleteComponente : EL COMPONENTE CON EL ID " + id + " NO EXISTE!!");

					throw new ComponenteIdMismatchExc("EL ID NO EXISTE EN LA DB");

				} else {

					iComponenteRepository.delete(iComponenteRepository.findById(id));

					logger.info("SE HA ELIMINADO CORRECTAMENTE EL COMPONENTE CON EL ID " + id);

				}

			} catch (Exception e) {

				logger.error("ERROR deleteComponente : EL COMPONENTE CON EL ID " + id
						+ " NO SE HA ELIMINADO DE LA DB!! . CAUSADO POR " + e);

				throw new ComponenteNotFoundExc("NO SE PUDO ELIMINAR EL COMPONENTE ", e, false, true);

			}
		}


		// ===================
		// ===== GET ALL =====
		// ===================
		// ------- LISTADO PAGINADO ---------
		public Page<Componente> getAllComponente(Pageable pageable) {

			try {
				return iComponenteRepository.findAll(pageable);
			} catch (Exception e) {
				
				logger.error("ERROR getAllComponente : NO SE HAN LISTADO LOS COMPONENTES. CAUSADO POR "+e);
				throw new ComponenteNotFoundExc("NO SE PUDO ENCONTRAR EL LISTADO DE COMPONENTES ", e);
			} 
		}
		
		// =========================
		// ===== GET ALL FILTER =====
		// ==========================
		// ------- LISTADO PAGINADO CON FILTER ---------
		public Page<Componente> getAllFilterComponente(String filter, Pageable pageable) {

			try {
				return iComponenteRepository.findAll(filter, pageable);
			} catch (Exception e) {
				
				logger.error("ERROR getAllFilterComponente : NO SE HAN LISTADO LOS COMPONENTES FILTRADOS. CAUSADO POR "+e);
				throw new ComponenteNotFoundExc("NO SE PUDO ENCONTRAR EL LISTADO DE COMPONENTES FILTRADOS ", e);
			} 
		}
		
		// =============== MÉTODOS DE BUSQUEDA ====================

		// ===============
		// ===== GET =====
		// ===============
		// ------ ID --------
		public Componente findById(int id) {
			try {
				
				if (id <= 0 || iComponenteRepository.findById(id).getId() != id) {

					logger.error("ERROR finById : EL COMPONENTE CON EL ID " + id + " NO EXISTE!!");

					throw new ComponenteIdMismatchExc("EL ID DEL COMPONENTE NO EXISTE EN LA DB");

				} else {

				
					logger.info("SE HA ELIMINADO CORRECTAMENTE EL COMPONENTE CON EL ID " + id);
					
					return iComponenteRepository.findById(id);


				}
				
				
			} catch (Exception e) {
				logger.error("ERROR findById : NO SE HA ENCONTRADO EL COMPONENTE CON EL ID SOLICITADO. CAUSADO POR "+e);
				throw new ComponenteNotFoundExc("NO SE PUDO ENCONTRAR EL COMPONENTE CON EL ID SOLICITADO ", e);
			}
			
		}
		
		
		// ===============
		// ===== GET =====
		// ===============
		// ------ CODIGO --------
		public Page<Componente> findByCodigo(String codigo, Pageable pageable) {
			
			try {
				return iComponenteRepository.findByCodigo(codigo, pageable);	
			} catch (Exception e) {
				logger.error("ERROR findByCodigo : NO SE HA ENCONTRADO EL LISTADO DE COMPONENTES CON EL CODIGO SOLICITADO. CAUSADO POR "+e);
				throw new ComponenteNotFoundExc("NO SE PUDO ENCONTRAR EL LISTADO DE COMPONENTES CON EL CODIGO SOLICITADO ", e);
			}
			
		}

		// ===============
		// ===== GET =====
		// ===============
		// ------ IMAGEN --------
		public Page<Componente> findByImagen(String imagen, Pageable pageable) {
			
			try {
				return iComponenteRepository.findByImagen(imagen, pageable);
			} catch (Exception e) {
				logger.error("ERROR findByImagen : NO SE HA ENCONTRADO EL LISTADO DE COMPONENTES CON LA IMAGEN SOLICITADO. CAUSADO POR "+e);
				throw new ComponenteNotFoundExc("NO SE PUDO ENCONTRAR EL LISTADO DE COMPONENTES CON LA IMAGEN SOLICITADO ", e);
			}
			
		}

		
		// ===============
		// ===== GET =====
		// ===============
		// ------ DATASHEET --------
		public Page<Componente> findByDatasheet(String datasheet, Pageable pageable) {
			
			try {
				return iComponenteRepository.findByDatasheet(datasheet, pageable);
			} catch (Exception e) {
				logger.error("ERROR findByDatasheet : NO SE HA ENCONTRADO EL LISTADO DE COMPONENTES CON EL DATASHEET SOLICITADO. CAUSADO POR "+e);
				throw new ComponenteNotFoundExc("NO SE PUDO ENCONTRAR EL LISTADO DE COMPONENTES CON EL DATASHEET SOLICITADO ", e);
			}
			
		}

		

		// ===============
		// ===== GET =====
		// ===============
		// ------ NRO_PIEZA --------
		public Page<Componente> findByNroPieza(String nroPieza, Pageable pageable) {
			
			try {
				return iComponenteRepository.findByNroPieza(nroPieza, pageable);	
			} catch (Exception e) {
				logger.error("ERROR findByNroPieza : NO SE HA ENCONTRADO EL LISTADO DE COMPONENTES CON EL NRO DE PIEZA SOLICITADO. CAUSADO POR "+e);
				throw new ComponenteNotFoundExc("NO SE PUDO ENCONTRAR EL LISTADO DE COMPONENTES CON EL NRO DE PIEZA SOLICITADO ", e);
			}
			
		}


		// ===============
		// ===== GET =====
		// ===============
		// ------ CATEGORIA --------
		public Page<Componente> findByCategoria(String categoria, Pageable pageable) {
			
			try {
				return iComponenteRepository.findByCategoria(categoria, pageable);
			} catch (Exception e) {
				logger.error("ERROR findByCategoria : NO SE HA ENCONTRADO EL LISTADO DE COMPONENTES CON LA CATEGORIA SOLICITADO. CAUSADO POR "+e);
				throw new ComponenteNotFoundExc("NO SE PUDO ENCONTRAR EL LISTADO DE COMPONENTES CON LA CATEGORIA SOLICITADO ", e);
			}
			
		}

		// ===============
		// ===== GET =====
		// ===============
		// ------ DESCRIPCION --------
		public Page<Componente> findByDescripcion(String descripcion, Pageable pageable) {
			
			try {
				return iComponenteRepository.findByDescripcion(descripcion, pageable);
			} catch (Exception e) {
				logger.error("ERROR findByDescripcion : NO SE HA ENCONTRADO EL LISTADO DE COMPONENTES CON LA DESCRIPCION SOLICITADO. CAUSADO POR "+e);
				throw new ComponenteNotFoundExc("NO SE PUDO ENCONTRAR EL LISTADO DE COMPONENTES CON LA DESCRIPCION SOLICITADO ", e);
			}
			
		}

		// ===============
		// ===== GET =====
		// ===============
		// ------ FABRICANTE --------
		public Page<Componente> findByFabricante(String fabricante, Pageable pageable) {
			
			try {
				return iComponenteRepository.findByFabricante(fabricante, pageable);
			} catch (Exception e) {
				logger.error("ERROR findByFabricante : NO SE HA ENCONTRADO EL LISTADO DE COMPONENTES CON EL FABRICANTE SOLICITADO. CAUSADO POR "+e);
				throw new ComponenteNotFoundExc("NO SE PUDO ENCONTRAR EL LISTADO DE COMPONENTES CON EL FABRICANTE SOLICITADO ", e);
			
			}

		}

		// ===============
		// ===== GET =====
		// ===============
		// ------ STOCK --------
		public Page<Componente> findByStock(int cantidad, Pageable pageable) {
			
			try {
				return iComponenteRepository.findByStock(cantidad, pageable);
			} catch (Exception e) {
				logger.error("ERROR findByStock : NO SE HA ENCONTRADO EL LISTADO DE COMPONENTES CON EL STOCK SOLICITADO. CAUSADO POR "+e);
				throw new ComponenteNotFoundExc("NO SE PUDO ENCONTRAR EL LISTADO DE COMPONENTES CON EL STOCK SOLICITADO ", e);
			}
			
			
		}

		// ===============
		// ===== GET =====
		// ===============
		// ------ PRECIO --------
		public Page<Componente> findByPrecio(double precio, Pageable pageable) {
			
			try {
				return iComponenteRepository.findByPrecio(precio, pageable);	
			} catch (Exception e) {
				logger.error("ERROR findByPrecio : NO SE HA ENCONTRADO EL LISTADO DE COMPONENTES CON EL PRECIO SOLICITADO. CAUSADO POR "+e);
				throw new ComponenteNotFoundExc("NO SE PUDO ENCONTRAR EL LISTADO DE COMPONENTES CON EL PRECIO SOLICITADO ", e);
			}
			
		}






}




		