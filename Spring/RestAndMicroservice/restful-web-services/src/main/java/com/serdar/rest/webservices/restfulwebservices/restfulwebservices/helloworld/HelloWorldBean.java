package com.serdar.rest.webservices.restfulwebservices.restfulwebservices.helloworld;


public class HelloWorldBean{

	private String message;

	public HelloWorldBean(String message) {
		this.message=message;
	}

	// Getter olmazsa bean'i auto-convert islemi ile json'a donduremez.
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	
	

}
