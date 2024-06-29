package com.sunbeam.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Table(name = "products")
@NoArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
public class Product extends BaseEntity {
	@Column(length = 25, unique = true)
	private String name;
	private double price;
	@Column(name = "avalilable_qty")
	private int availableQty;
	// Product * --> 1 Category
//	@ManyToOne // Mandatory,otherwise MappingException
//	@JoinColumn(name ="category_id", nullable = false) // optional But recommended , to specify name of FK Column and adding NOT NULL constraint
//	private Category productCategory;
	

	public Product(String name, double price, int availableQty) {
		
		this.name = name;
		this.price = price;
		this.availableQty = availableQty;
	}
	

}
