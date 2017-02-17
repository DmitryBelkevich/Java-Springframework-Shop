package com.hard.exceptions;

public class PurchaseException extends Exception {
	private static final long serialVersionUID = 8775326549782973921L;
	
	public PurchaseException() {
		super();
	}
	
	public PurchaseException(String message) {
		super(message);
	}
}