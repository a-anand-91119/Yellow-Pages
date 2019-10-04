package com.anand.yellowpages.exception;

public class UserBlockedException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UserBlockedException() {
		super();
	}

	public UserBlockedException(String errorDescription) {
		super(errorDescription);
	}
}
