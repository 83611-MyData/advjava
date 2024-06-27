package com.sunbeam.dao;

import com.sunbeam.entities.Product;

public interface ProductDao {
 String registerProduct(Product product);
 Product getProductDetails(Long productId);
 
}
