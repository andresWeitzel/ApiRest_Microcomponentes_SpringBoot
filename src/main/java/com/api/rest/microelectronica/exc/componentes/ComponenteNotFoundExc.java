package com.api.rest.microelectronica.exc.componentes;

public class ComponenteNotFoundExc extends RuntimeException{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ComponenteNotFoundExc() {}

	public ComponenteNotFoundExc(String msj) {
		super(msj);
	}

	
	public ComponenteNotFoundExc(Throwable cause) {
		super(cause);
	}
	
	public ComponenteNotFoundExc(String msj,Throwable cause) {
		super(msj,cause);
	}

	
	public ComponenteNotFoundExc(String msj,Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(msj,cause, enableSuppression, writableStackTrace);
	}


}