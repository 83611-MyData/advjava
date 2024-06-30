package com.sunbeam.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.custom_exceptions.AuthenticationException;
import com.sunbeam.dao.AddressDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.RegisterDTO;
import com.sunbeam.dto.UserAddressDTO;
import com.sunbeam.dto.UserRespDTO;
import com.sunbeam.entities.Address;
import com.sunbeam.entities.User;
import com.sunbeam.value_types.AdhaarCard;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	// depcy
	@Autowired
	private UserDao userDao;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserRespDTO authenticateUser(AuthRequest dto) {
		// 1.invoke dao 's method
		User user = userDao.findByEmailAndPassword(
				dto.getEmail(), dto.getPwd())
				.orElseThrow(() -> 
				new AuthenticationException("Invalid Email or Password !!!!!!"));
		//valid login -user : persistent -> entity -> dto
		return mapper.map(user, UserRespDTO.class);
	}

	@Override
	public ApiResponse registerUser(RegisterDTO dtorequest) {
		User user = mapper.map(dtorequest, User.class);
		if(userDao.existsByEmail(user.getEmail()))
			throw new ApiException("User Already Exist");
		userDao.save(user);
		return new ApiResponse("Register Successfully");
	}
	
	@Override
	public UserAddressDTO addUserAddress(UserAddressDTO dto) {
		User user = userDao.findById(dto.getUserId()).orElseThrow(()-> new ApiException("Invalid User ID"));
		Address address = addressDao.save(mapper.map(dto, Address.class));
		user.setUserAddress(address);
		return mapper.map(address, UserAddressDTO.class);
	}

	@Override
	public List<User> userByCity(String City) {
		List<User> userBycity =userDao.findByUserAddressCity(City);
		return userBycity;
	}

	@Override
	public ApiResponse addAdhaarCardOfUser(Long id, AdhaarCard adhaarCard) {
		if(userDao.existsById(id)) {
		User user = userDao.findById(id).orElseThrow(()-> new ApiException("Invalid User"));
		user.setCard(adhaarCard);
		userDao.save(user);
		return new ApiResponse("Successfully Card Added");
		}
		return new ApiResponse("Card Linking Failed");
	}
	
	
}
