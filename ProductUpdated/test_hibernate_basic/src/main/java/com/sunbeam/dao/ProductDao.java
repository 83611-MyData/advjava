package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public interface ProductDao {
 
String registerProduct(Product product);
 
 Product getProductDetails(Long productId);
 
 List<Product> getAllProducts();
 
 String applyDiscount(Category category,double discount);
 
 List<Product> getUsersByDobAndRole(Category category,double Sprice,double Eprice);
 
 public String purchaseProduct(Long id, int reqquantity);
 
 String deleteProductDetails(Long id);
 
}
