package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.Service.ProductService;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/products")
public class CategoryController {
	
	@Autowired
	private ProductService productService;
	
	public CategoryController() {
		System.out.println("in ctor"+getClass());
	}
	
	@GetMapping
	public ResponseEntity<?> getAllProductList(){
		return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProduct());
	}
	
	@GetMapping("/{proid}")
	public ResponseEntity<?> getProductDetails(@PathVariable Long proid){
		try {
			return ResponseEntity.ok(productService.getProductDetailsById(proid));
		}catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Invalid product Id"));
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> addNewProduct(@RequestBody Product product){
		System.out.println(product);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new ApiResponse("Product Not Added"));
		}
	}
	
	@PutMapping("/{productid}")
	public ResponseEntity<?> updateProduct(@PathVariable Long productid, @RequestBody Product extistingProduct){	
			return ResponseEntity.ok(productService.updateProductDetails(productid, extistingProduct));
	}
	
	@DeleteMapping("/{deleteid}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long deleteid){
			return ResponseEntity.ok(productService.deleteProduct(deleteid));
	}
}
