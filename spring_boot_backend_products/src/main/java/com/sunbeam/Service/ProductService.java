package com.sunbeam.Service;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;

public interface ProductService {
	
	List<Product> getAllProduct();
	Product addProduct(Product product);
	Product getProductDetailsById(Long productId);
	ApiResponse updateProductDetails(Long productId, Product existingProduct);
	ApiResponse deleteProduct(Long productId);
}
