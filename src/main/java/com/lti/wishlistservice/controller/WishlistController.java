package com.lti.wishlistservice.controller;

import java.util.List;

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
import com.lti.wishlistservice.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;
	

	@GetMapping("{id}")
	public ResponseEntity<Wishlist> getWishlistById(@PathVariable(value="id") Long wishlist_id) {
		return ResponseEntity.ok(wishlistService.getWishlistById(wishlist_id));
	}  
	
	@GetMapping
	public ResponseEntity<List<Wishlist>> getWishlist() {
		return ResponseEntity.ok(wishlistService.getAllWishlist());
	}

	@PostMapping
	public ResponseEntity<Wishlist> saveWishlist(@RequestBody Wishlist wishlist) {
		return new ResponseEntity<>(wishlistService.saveWishlist(wishlist), HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Wishlist> updateWishlist(@PathVariable(value="id") Long wishlist_id, @RequestBody Wishlist wishlist) {
		return new ResponseEntity<>(wishlistService.updateWishlist(wishlist,wishlist_id),HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteWishlistById(@PathVariable(value="id") Long wishlist_id) {
		wishlistService.deleteWishlistById(wishlist_id);
		return new ResponseEntity<>("Wishlist deleted successfully !.",HttpStatus.OK);
	}
	
}
