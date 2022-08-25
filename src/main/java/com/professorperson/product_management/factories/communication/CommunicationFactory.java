package com.professorperson.product_management.factories.communication;

import com.professorperson.product_management.services.communication.Communication;

/**
 * Consumer class
 * @author Kevin
 *
 */
public class CommunicationFactory {
	public static Communication get(CommunicationAbstractFactory factory) {
		return factory.createCommunication();
	}
}
