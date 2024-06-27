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
	@Column(name="name",length = 20,unique = true)
	private String categoryName;
	private String description;
	// Category 1 --> * Product
	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL)
	// Mandatory
	private List<Product> productlist = new ArrayList<Product>();

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String categoryName, String description) {
		this.categoryName = categoryName;
		this.description = description;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Product> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}
	
	//add helper method to establish bi-directional association between Category and Product
	public void addProduct(Product product) {
		//parent(Category) --> child(Product)
		this.productlist.add(product);
		//child --> parent
		product.setProductCategory(this);
	}
	
	@Override
	public String toString() {
		return "Category [getId()=" + getId() + ", categoryName=" + categoryName + ", description=" + description
				+ "]";
	}

	

}
