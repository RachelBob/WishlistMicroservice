package com.lti.wishlistservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.wishlistservice.model.Wishlist;
import com.lti.wishlistservice.model.WishlistProduct;
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
	
	
	@GetMapping("{uuid}")
	public ResponseEntity<Optional<Wishlist>> getWishlistProductByUuid(@PathVariable(value="uuid") String wishlistUuid) {
		Optional<Wishlist> response = wishlistProductService.getWishlistProductByUuid(wishlistUuid);
		return ResponseEntity.ok(response);
	}  

	@GetMapping
	public ResponseEntity<List<Wishlist>> getAllWishlistProduct() {
		return ResponseEntity.ok(wishlistProductService.getAllWishlistProduct());
	}
	
	@PutMapping("{uuid}")
	public ResponseEntity<WishlistProduct> updateWishlistProduct(@PathVariable(value="uuid") String wishlistUuid, @RequestBody WishlistProduct wishlist) {
		return new ResponseEntity<>(wishlistProductService.updateWishlistProduct(wishlist,wishlistUuid),HttpStatus.OK);
	}

	@DeleteMapping("{uuid}")
	public ResponseEntity<String> deleteWishlistProduct(@PathVariable(value="uuid") String wishlistUuid) {
		wishlistProductService.deleteWishlistProduct(wishlistUuid);
		return new ResponseEntity<>("Wishlist deleted successfully !.",HttpStatus.OK);
	}
	
}
