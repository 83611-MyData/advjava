package com.sunbeam.entities;
import javax.persistence.*;
import javax.annotation.processing.Generated;

@Entity
@Table(name="products")
public class Product extends BaseEntity {

	
	@Column(length = 20,unique=true)
	private String product_name;
	
	@Column(name="price")
	private double price;
	
	private int available_quantity;
	
	@ManyToOne
	@JoinColumn(name = "category_id",nullable = false)
	private Category productCategory;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
  
	
	
	

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailable_quantity() {
		return available_quantity;
	}

	public void setAvailable_quantity(int available_quantity) {
		this.available_quantity = available_quantity;
	}


	


	public Category getProductCategory() {
		return productCategory;
	}





	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}





	public Product(String product_name, double price, int available_quantity) {
		super();
		this.product_name = product_name;
		this.price = price;
		this.available_quantity = available_quantity;
	}





	@Override
	public String toString() {
		return "Product [product_name=" + product_name + ", price=" + price + ", available_quantity="
				+ available_quantity + "]";
	}

	
	
	
	
	//Refer - products table - id , category (BAKERY|SHOES|CLOTHES|STATIONAY) ,product name(unique)  , price , available quantity

}
