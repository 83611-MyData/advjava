package com.sunbeam.beans;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Product;

public class ProductBean {
	// Bind request parameters to java bean's props
	private String name;
	private double price;
	private int quantity;
	private long categoryId;
	//dependency -dao layer interface
	private ProductDao productDao;
	public ProductBean() {
		// create dao instance
		productDao = new ProductDaoImpl();
		System.out.println("product bean created ...");
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	//Add Business Logic(B.L) Method to add a new Product
	public String addNewProduct() {
		System.out.println("in add product" + categoryId);
		//1.create transient product
		Product product= new Product(name, price, quantity);
		//2.invoke dao's method for saving product details in db
		return productDao.addProduct(categoryId, product);
	}
	
}
