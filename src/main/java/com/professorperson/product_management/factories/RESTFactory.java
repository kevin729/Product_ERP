package com.professorperson.product_management.factories;

import com.professorperson.product_management.services.Communication;
import com.professorperson.product_management.services.REST;

public class RESTFactory implements CommunicationAbstractFactory {

	@Override
	public Communication createCommunication() {
		return new REST();
	}

}
