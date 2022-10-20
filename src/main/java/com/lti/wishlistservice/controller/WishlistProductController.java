package com.lti.wishlistservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.wishlistservice.model.Wishlist;
import com.lti.wishlistservice.service.WishlistProductService;


@RestController
@RequestMapping("/wishlistProduct")
public class WishlistProductController {

	@Autowired
	private WishlistProductService wishlistProductService;
	
	@PostMapping
	public ResponseEntity<Wishlist> addWishlistProduct(@RequestBody Wishlist wishlist) {
		return new ResponseEntity<>(wishlistProductService.saveWishlistProduct(wishlist), HttpStatus.CREATED);
	}
	
	
}
