package com.hard.exceptions;

public class PurchaseRuntimeException extends Exception {
	private static final long serialVersionUID = -853615431858392120L;
	
	public PurchaseRuntimeException() {
		super();
	}
	
	public PurchaseRuntimeException(String message) {
		super(message);
	}
}