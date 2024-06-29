package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="categories")
public class Category extends BaseEntity {
	
	@Column(name="name",length =30,unique= true )
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "productCategory",cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<>();
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addProduct(Product product)
	{
		//parent(Category) --> child(Product)
		this.products.add(product);
		//child --> parent
		product.setProductCategory(this);
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", description=" + description + "]";
	}
	
	
	

}