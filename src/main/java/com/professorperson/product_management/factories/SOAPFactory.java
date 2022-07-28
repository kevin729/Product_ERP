package com.professorperson.product_management.factories;

import com.professorperson.product_management.services.Communication;
import com.professorperson.product_management.services.SOAP;

public class SOAPFactory implements CommunicationAbstractFactory {

	@Override
	public Communication createCommunication() {
		return new SOAP();
	}
}
