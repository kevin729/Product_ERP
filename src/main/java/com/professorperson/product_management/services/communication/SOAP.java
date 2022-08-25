package com.professorperson.product_management.services.communication;

public class SOAP extends Communication {

	@Override
	public String send(String url, String method, String contentType, String data) {
		return "SOAP";
	}
	
}
