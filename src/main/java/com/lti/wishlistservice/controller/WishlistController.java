package com.lti.wishlistservice.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger("WishlistController.class");
	
	@Autowired
	private WishlistService wishlistService;

	@PostMapping("/add")
	public ResponseEntity<Wishlist> addWishlist(@RequestBody Wishlist wishlist) {
		return new ResponseEntity<>(wishlistService.saveWishlist(wishlist), HttpStatus.CREATED);
	}
	
	@GetMapping("/findbyuuid/{uuid}")
	public ResponseEntity<Optional<Wishlist>> getWishlist(@PathVariable(value="uuid") String wishlistUuid) {
		Optional<Wishlist> response = wishlistService.getWishlistByUuid(wishlistUuid);
		return ResponseEntity.ok(response);
	}  
	
	@GetMapping("/findall")
	public ResponseEntity<List<Wishlist>> getWishlist() {
		return ResponseEntity.ok(wishlistService.getAllWishlist());
	}

	@PutMapping("/update")
	public ResponseEntity<Wishlist> updateWishlist(@RequestBody Wishlist wishlist) {
		return new ResponseEntity<>(wishlistService.updateWishlist(wishlist),HttpStatus.OK);
	}

	@DeleteMapping("/delete/{uuid}")
	public ResponseEntity<String> deleteWishlistById(@PathVariable(value="uuid") String wishlistUuid) {
		wishlistService.deleteWishlist(wishlistUuid);
		return new ResponseEntity<>("Wishlist deleted successfully !.",HttpStatus.OK);
	}
	
}
