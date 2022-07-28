package com.professorperson.product_management.models;

public class Product {
	private int id;
	private String productTitle;
	private String productDetails;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getProductDescription() {
		return productDetails;
	}
	public void setProductDescription(String productDetails) {
		this.productDetails = productDetails;
	}
	
	
}
