package com.sunbeam.entities;

import javax.persistence.*;

@Entity @Table(name = "products")
public class Product extends BaseEntity {
	@Column(length = 25, unique = true)
	private String name;
	private double price;
	@Column(name = "avalilable_qty")
	private int availableQty;
	// Product * --> 1 Category
	@ManyToOne // Mandatory,otherwise MappingException
	@JoinColumn(name ="category_id", nullable = false) // optional But recommended , to specify name of FK Column and adding NOT NULL constraint
	private Category productCategory;
	
	public Product() {
	}

	public Product(String name, double price, int availableQty) {
		this.name = name;
		this.price = price;
		this.availableQty = availableQty;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(int availableQty) {
		this.availableQty = availableQty;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Product [getId()=" + getId() + ", name=" + name + ", price=" + price + ", availableQty=" + availableQty
				+ ", productCategory=" + productCategory + "]";
	}

	

}
