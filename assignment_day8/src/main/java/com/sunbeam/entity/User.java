package com.sunbeam.entity;

import java.time.LocalDate;

import javax.persistence.*; 

@Entity

@Table(name="users")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="first_name",length=25)
	private String firstName;
	@Column(name="last_name",length=25)
	private String lastName;
	@Column(length=20, unique=true)
	private String email;
	@Column(length=20, nullable=false)
	private String password;
	private LocalDate dob;
	@Column(name="reg_amount")
	private double regAmount;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Role role;
	@Lob
	private byte[] image;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String email, String password, LocalDate dob, double regAmount, Role role ) {
	
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.password=password;
		this.dob=dob;
		this.regAmount=regAmount;
		this.role=role;
		
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User [id=" + id + ", firstName=" +firstName+ ", lastName=" +lastName+", email=" +email+  ", dob=" +dob+ ", regAmount=" +regAmount+ ", role=" +role+ "]";
	}
		
	}
