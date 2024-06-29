package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Product;

public interface ProductDao {
//add a product
	String addProduct(Long categoryId, Product newProduct);
	
	Product getProductDetails(Long productId);

	String purchaseProduct(Long productId, int qty);
	
	List<Product> getAllProducts();
}
