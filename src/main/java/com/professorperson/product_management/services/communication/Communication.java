package com.professorperson.product_management.services.communication;

public abstract class Communication {
	public abstract String send(String url, String method, String contentType, String data);
}
