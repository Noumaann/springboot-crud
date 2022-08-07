package com.example.springbootdemo.exceptions;

public class TraineeIdNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TraineeIdNotFoundException(String message) {
		super(message);
	}
	
}
