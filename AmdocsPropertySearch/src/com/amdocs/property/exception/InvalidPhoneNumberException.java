package com.amdocs.property.exception;

public class InvalidPhoneNumberException extends Exception{
	String message;
	public InvalidPhoneNumberException(String statement)
	{
		message = statement;
	}
	public String toString() {
	      return ("Exception Occurred : " + message);
	   }
}

