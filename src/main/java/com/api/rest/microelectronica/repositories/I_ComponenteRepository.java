package com.api.rest.microelectronica.repositories;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.microelectronica.entities.Componente;



@Repository
public interface I_ComponenteRepository extends JpaRepository<Componente, Serializable>, PagingAndSortingRepository<Componente, Serializable>{

	//============================ MÉTODOS DE BÚSQUEDA ============================== 
	
		public abstract Componente findById(int id);
		
		@Query("select c from Componente c where lower(c.codigo) like lower(concat('%', :codigo, '%'))")
		public abstract Page<Componente> findByCodigo(String codigo, Pageable pageable);
		
		//Para check codigo unico
		@Query("select c from Componente c where lower(c.codigo) like lower(concat('%', :codigo, '%'))")
		public abstract Componente findByCodigo(String codigo);
		
		@Query("select c from Componente c where lower(c.imagen) like lower(concat('%', :imagen, '%'))")
		public abstract Page<Componente> findByImagen(String imagen, Pageable pageable);
		
		@Query("select c from Componente c where lower(c.datasheet) like lower(concat('%', :datasheet, '%'))")
		public abstract Page<Componente> findByDatasheet(String datasheet, Pageable pageable);
		
		@Query("select c from Componente c where lower(c.nroPieza) like lower(concat('%', :nroPieza, '%'))")
		public abstract Page<Componente> findByNroPieza(String nroPieza, Pageable pageable);
		
		@Query("select c from Componente c where lower(c.categoria) like lower(concat('%', :categoria, '%'))")
		public abstract Page<Componente> findByCategoria(String categoria, Pageable pageable);
		
		@Query("select c from Componente c where lower(c.descripcion) like lower(concat('%', :descripcion, '%'))")
		public abstract Page<Componente> findByDescripcion(String descripcion , Pageable pageable);
		
		@Query("select c from Componente c where lower(c.fabricante) like lower(concat('%', :fabricante, '%'))")
		public abstract Page<Componente> findByFabricante(String fabricante , Pageable pageable);
		
		public abstract Page<Componente> findByStock(int stock , Pageable pageable);

		public abstract Page<Componente> findByPrecio(double precio , Pageable pageable);

		public abstract Page<Componente> findAll(Pageable pageable );

		@Query("select c from Componente c where concat( lower(c.codigo), lower(c.imagen) , lower(c.datasheet) , lower(c.nroPieza), lower(c.categoria), lower(c.descripcion), lower(c.fabricante) ) like lower( concat ( '%', ?1, '%'))")
		public abstract Page<Componente> findAll(String filtro, Pageable pageable);
}
