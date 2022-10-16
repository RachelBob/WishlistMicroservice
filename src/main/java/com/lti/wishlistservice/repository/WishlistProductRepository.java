package com.lti.wishlistservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.wishlistservice.model.WishlistProduct;


public interface WishlistProductRepository extends JpaRepository<WishlistProduct, Long>{

}
