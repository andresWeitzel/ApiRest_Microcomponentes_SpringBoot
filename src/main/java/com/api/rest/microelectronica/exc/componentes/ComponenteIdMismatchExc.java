package com.api.rest.microelectronica.exc.componentes;

public class ComponenteIdMismatchExc extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ComponenteIdMismatchExc() {}

	public ComponenteIdMismatchExc(String msj) {
		super(msj);
	}

	public ComponenteIdMismatchExc(Throwable cause) {
		super(cause);
	}

	public ComponenteIdMismatchExc(String msj, Throwable cause) {
		super(msj, cause);
	}

	
	public ComponenteIdMismatchExc(String msj, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(msj, cause, enableSuppression, writableStackTrace);
	}

}