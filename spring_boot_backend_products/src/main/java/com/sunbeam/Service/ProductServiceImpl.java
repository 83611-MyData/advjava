package com.sunbeam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;
import com.sunbeam.exception.HelpException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product addProduct(Product product) {
		return productDao.save(product);
		
	}

	@Override
	public List<Product> getAllProduct() {
		return productDao.findAll();
	}

	@Override
	public Product getProductDetailsById(Long productId) {
		return productDao.findById(productId).orElseThrow(()-> new HelpException("Invalid Product Id"));
	}

	@Override
	public ApiResponse updateProductDetails(Long productId , Product existingProduct) {
		if(productDao.existsById(productId)) {
			productDao.save(existingProduct);
			return new ApiResponse("Successfully Updated");
		}
		return new ApiResponse("Not Updated");
	}

	@Override
	public ApiResponse deleteProduct(Long productId) {
		if(productDao.existsById(productId)) {
			productDao.deleteById(productId);
			return new ApiResponse("Successfully Deleted");
		}
		return new ApiResponse("Invalid Product To Delete");
	}
	
}
