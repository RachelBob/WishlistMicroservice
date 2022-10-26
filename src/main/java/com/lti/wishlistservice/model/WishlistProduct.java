package com.lti.wishlistservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String productname;
	private String description;
	private BigDecimal price;
	private String category;
	
	@Column(name="uuid")
	private String uuid;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wishlist_id")
    private Wishlist wishlist;
	
	@JsonIgnore
	public Long getWishlistproduct_id() {
		return wishlistproduct_id;
	}
	
	@JsonIgnore
	public Wishlist getWishlist() {
		return wishlist;
	}
}
