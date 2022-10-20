package com.lti.wishlistservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wishlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wishlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wishlist_id;
	
	private String name;
	private Long customer_id;

	@Column(name = "uuid")
	private String uuid;

	@OneToMany(targetEntity = WishlistProduct.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_wishlist_id", referencedColumnName = "wishlist_id")
	private List<WishlistProduct> wishlistProduct;

}
