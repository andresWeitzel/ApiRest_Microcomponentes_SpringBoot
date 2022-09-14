package com.api.rest.microelectronica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.api.rest.microelectronica.entities.Componente;
import com.api.rest.microelectronica.exc.componentes.ComponenteNotFoundExc;
import com.api.rest.microelectronica.repositories.I_ComponenteRepository;

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


					System.out.println("\n COMPONENTE MODIFICADO:" + componente);

					iComponenteRepository.save(componente);

					logger.info("SE HA INSERTADO CORRECTAMENTE EL COMPONENTE CON EL ID " + componente.getId());
				}
			} catch (Exception e) {
				logger.error(
						"ERROR addComponente : EL COMPONENTE" + componente + " NO SE HA INSERTADO EN LA DB!! CAUSADO POR " + e);
				throw new ComponenteNotFoundExc("NO SE PUDO AGREGAR EL COMPONENTE. ", e, false, true);
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










}




		