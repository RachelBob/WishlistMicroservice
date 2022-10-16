package com.lti.wishlistservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "wishlist")
public class Wishlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wishlist_id;
	private String name;
	private Long customer_id;

	@OneToMany(targetEntity =WishlistProduct.class, cascade = CascadeType.ALL)
	@JoinColumn(name="fk_wishlist_id", referencedColumnName = "wishlist_id")
	private List<WishlistProduct> wishlistProduct;

	public Long getWishlist_id() {
		return wishlist_id;
	}

	public String getName() {
		return name;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public List<WishlistProduct> getWishlistProduct() {
		return wishlistProduct;
	}

	public void setWishlist_id(Long wishlist_id) {
		this.wishlist_id = wishlist_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public void setWishlistProduct(List<WishlistProduct> wishlistProduct) {
		this.wishlistProduct = wishlistProduct;
	}

	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wishlist(Long wishlist_id, String name, Long customer_id, List<WishlistProduct> wishlistProduct) {
		super();
		this.wishlist_id = wishlist_id;
		this.name = name;
		this.customer_id = customer_id;
		this.wishlistProduct = wishlistProduct;
	}

	@Override
	public String toString() {
		return "Wishlist [wishlist_id=" + wishlist_id + ", name=" + name + ", customer_id=" + customer_id
				+ ", wishlistProduct=" + wishlistProduct + "]";
	}

	
}
