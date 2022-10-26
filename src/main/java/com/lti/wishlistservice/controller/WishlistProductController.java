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
@RequestMapping("/wishlistproduct")
public class WishlistProductController {

	@Autowired
	private WishlistProductService wishlistProductService;
	
	@PostMapping("/add")
	public ResponseEntity<Wishlist> addWishlistProduct(@RequestBody Wishlist wishlist) {
		return new ResponseEntity<>(wishlistProductService.saveWishlistProduct(wishlist), HttpStatus.CREATED);
	}
	
	@GetMapping("/findbyuuid/{uuid}")
	public ResponseEntity<Optional<Wishlist>> getWishlistProductByUuid(@PathVariable(value="uuid") String wishlistUuid) {
		Optional<Wishlist> response = wishlistProductService.getWishlistProductByUuid(wishlistUuid);
		return ResponseEntity.ok(response);
	}  

	@GetMapping("/findall")
	public ResponseEntity<List<Wishlist>> getAllWishlistProduct() {
		return ResponseEntity.ok(wishlistProductService.getAllWishlistProduct());
	}
	
	@PutMapping("/update")
	public ResponseEntity<WishlistProduct> updateWishlistProduct(@RequestBody WishlistProduct wishlist) {
		return new ResponseEntity<>(wishlistProductService.updateWishlistProduct(wishlist),HttpStatus.OK);
	}

	@DeleteMapping("/delete/{uuid}")
	public ResponseEntity<String> deleteWishlistProduct(@PathVariable(value="uuid") String wishlistProductUuid) {
		wishlistProductService.deleteWishlistProduct(wishlistProductUuid);
		return new ResponseEntity<>("Wishlist Product deleted successfully !.",HttpStatus.OK);
	}
	
}
