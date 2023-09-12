package com.amdocs.property.exception;

public class PropertyNotFoundException extends Exception {
	String message;
	public PropertyNotFoundException(String statement)
	{
		message = statement;
	}
	public String toString() {
	      return ("Exception Occurred : " + message);
	   }
}
