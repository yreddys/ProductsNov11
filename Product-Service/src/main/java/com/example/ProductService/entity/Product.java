package com.example.ProductService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private int id;
	private String productName;
	private String description;
	private int price;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Product(int id, String productName, String description, int price, String status) {

		this.id = id;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.status = status;
	}

	public Product() {
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", description=" + description + ", price="
				+ price + ", status=" + status + "]";
	}

}
