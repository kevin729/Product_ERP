package com.professorperson.product_management.factories;

import com.professorperson.product_management.services.Communication;

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
