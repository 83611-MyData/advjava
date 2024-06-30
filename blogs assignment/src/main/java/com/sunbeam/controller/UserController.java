package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.RegisterDTO;
import com.sunbeam.dto.UserAddressDTO;
import com.sunbeam.service.UserService;
import com.sunbeam.value_types.AdhaarCard;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("in ctor " + getClass());
	}

	/*
	 * Desc - User signin URL - http://host:port/users/signin Method - POST payload
	 * - dto (email n pwd) Successful Resp - SC 200, user details - all (dto) Error
	 * resp - SC 400 , error mesg -wrapped in DTO(ApiResponse)
	 * 
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> signInUser(@RequestBody AuthRequest request) {
		System.out.println("in signin " + request);
		try {
			return ResponseEntity.ok(userService.authenticateUser(request));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> signUpUser(@RequestBody RegisterDTO dto){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body( userService.registerUser(dto));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@PostMapping("/addAddress")
	public ResponseEntity<?> addAddress(@RequestBody UserAddressDTO userAddressDTO){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUserAddress(userAddressDTO));
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/{city}")
	public ResponseEntity<?> getUserByCity(@PathVariable String city){
		try {
			System.out.println("City= "+city);
			return ResponseEntity.ok(userService.userByCity(city));
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("No User in City"));
		}
	}
	
	@PostMapping("/add_card/{id}")
	public ResponseEntity<?> addAdhaarCardOfuser(@PathVariable Long id,@RequestBody AdhaarCard card){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.addAdhaarCardOfUser(id, card));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Failed"));
		}
	}
	
}
