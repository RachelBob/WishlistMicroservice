package com.lti.wishlistservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.wishlistservice.model.WishlistProduct;

public interface WishlistProductRepository extends JpaRepository<WishlistProduct, Long>{

	WishlistProduct save(WishlistProduct wishlistProduct);
	
	Optional<WishlistProduct> findByUuid(String wishlist_uuid);


}