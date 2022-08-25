package com.professorperson.product_management.factories.communication;

import com.professorperson.product_management.factories.communication.CommunicationAbstractFactory;
import com.professorperson.product_management.services.communication.Communication;
import com.professorperson.product_management.services.communication.REST;

public class RESTFactory implements CommunicationAbstractFactory {

	@Override
	public Communication createCommunication() {
		return new REST();
	}

}
