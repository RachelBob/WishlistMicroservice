package com.lti.wishlistservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor 
@Builder
public class WishlistProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wishlistproduct_id;
	private String productName;
	private String description;
	private BigDecimal price;
	
	@Column(name="uuid")
	private String uuid;
	
	
}
