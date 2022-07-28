package com.professorperson.product_management.services;

import com.professorperson.product_management.factories.CommunicationAbstractFactory;

public class SOAP extends Communication {

	@Override
	public String send(String url, String method, String contentType, String data) {
		return "SOAP";
	}
	
}
