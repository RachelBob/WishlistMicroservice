package com.lti.wishlistservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wishlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wishlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wishlist_id")
	private Long wishlist_id;
	
	private String name;
	private Long customer_id;

	@Column(name = "uuid")
	private String uuid;
	
	@Transient
	private String customer_uuid;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="wishlist", cascade=CascadeType.ALL)
	private List<WishlistProduct> wishlistProduct;
	
	
	@JsonIgnore
	public Long getWishlist_id() {
		return wishlist_id;
	}
	
	@JsonIgnore
	public Long getCustomer_id() {
		return customer_id;
	}
	

}
