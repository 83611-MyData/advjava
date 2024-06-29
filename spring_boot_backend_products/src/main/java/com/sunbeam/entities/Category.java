package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name="categories")
@NoArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
public class Category extends BaseEntity {
	@Column(name="name",length = 20,unique = true)
	private String categoryName;
	private String description;
	// Category 1 --> * Product
//	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL)
//	// Mandatory
//	private List<Product> productlist = new ArrayList<Product>();


}
