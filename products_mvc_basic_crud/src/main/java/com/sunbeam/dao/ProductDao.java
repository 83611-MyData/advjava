package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Product;

public interface ProductDao {
	//add a product
	String addProduct(Long categoryId, Product newProduct);
	List<Product> getAllProducts();
	Product getProductDetails(Long productId);
	String purchaseProduct(Long productId, int qty);
}
