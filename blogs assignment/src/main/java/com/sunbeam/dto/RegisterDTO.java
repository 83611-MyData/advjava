package com.sunbeam.dto;

import java.time.LocalDate;

import com.sunbeam.entities.Role;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterDTO{
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private LocalDate dob;
	private Role role;
}
