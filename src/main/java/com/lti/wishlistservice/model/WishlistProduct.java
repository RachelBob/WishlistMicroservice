package com.lti.wishlistservice.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class WishlistProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wishlistproduct_id;
	private String productName;
	private String description;
	private BigDecimal price;
	
	public Long getWishlistproduct_id() {
		return wishlistproduct_id;
	}
	public String getProductName() {
		return productName;
	}
	public String getDescription() {
		return description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setWishlistproduct_id(Long wishlistproduct_id) {
		this.wishlistproduct_id = wishlistproduct_id;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	public WishlistProduct() {
		super();
	}
	
	public WishlistProduct(Long wishlistproduct_id, String productName, String description, BigDecimal price) {
		super();
		this.wishlistproduct_id = wishlistproduct_id;
		this.productName = productName;
		this.description = description;
		this.price = price;
	}
	@Override
	public String toString() {
		return "WishlistProduct [wishlistproduct_id=" + wishlistproduct_id + ", productName=" + productName
				+ ", description=" + description + ", price=" + price + "]";
	}

	
}
