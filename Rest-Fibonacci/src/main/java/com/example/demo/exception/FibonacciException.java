package com.example.demo.exception;

public class FibonacciException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String message;

	public FibonacciException(String msg) {
		this.setMessage(msg);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
