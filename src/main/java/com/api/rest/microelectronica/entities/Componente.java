package com.api.rest.microelectronica.entities;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "componentes")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Componente {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comp_microelec")
	@SequenceGenerator(name = "seq_comp_microelec", sequenceName = "id_seq_comp_microelec", allocationSize = 1)
	@Id
	@Column(name = "id")
	private int id;

	
	@Column(name = "codigo", unique=true)
	@NotNull(message="El Código no puede ser null")
	@NotEmpty(message="El Código no puede ser vacío")
	@NotBlank(message="El Código no puede estar en blanco")
	@Size(min = 6, max = 100, message = "El Código debe ser mayor o igual a 6 caracteres y menor o igual a 100 caracteres")
	private String codigo;

	
	@Column(name="imagen")
	//@NotNull(message="La Imagen no puede ser null")
	//@NotBlank(message="La imagen no puede estar en blanco")
	@Size(min = 20, max = 1000, message = "La Imagen debe ser mayor o igual a 20 caracteres y menor o igual a 1000 caracteres")
	private String imagen;
	
	@Column(name = "datasheet")
	//@NotNull(message="La Hoja De Datos no puede ser null")
	//@NotBlank(message="La Hoja De Datos no puede estar en blanco")
	@Size(min = 20, max = 1000, message = "La Hoja De Datos debe ser mayor o igual a 20 caracteres y menor o igual a 1000 caracteres")
	private String datasheet;

	
	@Column(name = "nro_pieza")
	@NotNull(message="El Nro de Pieza no puede ser null")
	@NotBlank(message="El Nro de Pieza no puede estar en blanco")
	@Size(min = 20, max = 200, message = "La Imagen debe ser mayor o igual a 20 caracteres y menor o igual a 200 caracteres")
	private String nroPieza;

	@Column(name = "categoria")
	@NotNull(message="La Categoría no puede ser null")
	@NotEmpty(message="La Categoría no puede ser vacía")
	@NotBlank(message="La Categoría no puede estar en blanco")
	@Size(min = 4, max = 100, message = "La Categoría debe ser mayor o igual a 4 caracteres y menor o igual a 100 caracteres")
	private String categoria;

	@Column(name = "descripcion")
	@NotNull(message="La Descripción no puede ser null")
	@NotEmpty(message="La Descripción no puede ser vacío")
	@NotBlank(message="La Descripción no puede estar en blanco")
	@Size(min = 4, max = 200, message = "La Descripción debe ser mayor o igual a 4 caracteres y menor o igual a 200 caracteres")
	private String descripcion;

	@Column(name = "fabricante")
	@NotNull(message="El Fabricante no puede ser null")
	@NotEmpty(message="El Fabricante no puede ser vacío")
	@NotBlank(message="El Fabricante no puede estar en blanco")
	@Size(min = 4, max = 100, message = "El Fabricante debe ser mayor o igual a 4 caracteres y menor o igual a 100 caracteres")
	private String fabricante;

	@Column(name = "stock")
	@NotNull(message="El Stock no puede ser null")
	@Min(value = 10, message = "El Stock debe ser mayor o igual a 10 Unidades")
    @Max(value = 10000, message = "El Stock debe ser menor o igual a 10000 Unidades")
	//No podemos validar con mas opciones los enteros
	private int stock;

	@Column(name = "precio")
	@NotNull(message="El Precio no puede ser null")
	@Min(value = 200, message = "El Precio debe ser mayor o igual a US$1")
    @Max(value = 10000, message = "El Precio debe ser menor o igual a US$10000")
	//No podemos validar con mas opciones los enteros
	private double precio;

}
