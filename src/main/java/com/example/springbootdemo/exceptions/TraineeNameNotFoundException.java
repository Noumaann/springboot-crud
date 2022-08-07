package com.example.springbootdemo.exceptions;

public class TraineeNameNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TraineeNameNotFoundException(String message) {
		super(message);
	}

}
