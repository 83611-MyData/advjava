package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.RegisterDTO;
import com.sunbeam.dto.UserAddressDTO;
import com.sunbeam.dto.UserRespDTO;
import com.sunbeam.entities.User;
import com.sunbeam.value_types.AdhaarCard;

public interface UserService {
//user signin
	UserRespDTO authenticateUser(AuthRequest dto);
	ApiResponse registerUser(RegisterDTO dtorequest);
	UserAddressDTO addUserAddress(UserAddressDTO dto);
	List<User> userByCity(String City);
	ApiResponse addAdhaarCardOfUser(Long id, AdhaarCard adhaarCard);
}
