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
		logger.info("In Wishlist controller -> addWishlist method : Request {}  " , wishlist);
		Wishlist response = wishlistService.saveWishlist(wishlist);
		logger.info("Wishlist get from DB is ",response);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/findbyuuid/{uuid}")
	public ResponseEntity<Optional<Wishlist>> getWishlist(@PathVariable(value="uuid") String wishlistUuid) {
		logger.info("In Wishlist controller -> getWishlist method : wishlistUuid {}  " , wishlistUuid);
		Optional<Wishlist> response = wishlistService.getWishlistByUuid(wishlistUuid);
		logger.info("Wishlist get from DB is ",response.get().getUuid());
		return ResponseEntity.ok(response);
	}  
	
	@GetMapping("/findall")
	public ResponseEntity<List<Wishlist>> getWishlist() {
		logger.info("In Wishlist controller -> getWishlist method : getWishlist {}  ");
		return ResponseEntity.ok(wishlistService.getAllWishlist());
	}

	@PutMapping("/update")
	public ResponseEntity<Wishlist> updateWishlist(@RequestBody Wishlist wishlist) {
		logger.info("In Wishlist controller -> updateWishlist method : getWishlist {}  ", wishlist);
		Wishlist response = wishlistService.updateWishlist(wishlist);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	@DeleteMapping("/delete/{uuid}")
	public ResponseEntity<String> deleteWishlistById(@PathVariable(value="uuid") String wishlistUuid) {
		logger.info("In Wishlist controller -> deleteWishlistById method : deleteWishlistById {}  ", wishlistUuid);
		wishlistService.deleteWishlist(wishlistUuid);
		return new ResponseEntity<>("Wishlist deleted successfully !.",HttpStatus.OK);
	}
	
	@GetMapping("/findbycustomeruuid/{customeruuid}")
	public ResponseEntity<List<Wishlist>> getWishlistByCustomer(@PathVariable(value="customeruuid") String customeruuid) {
		logger.info("In Wishlist controller -> getWishlistByCustomer method : getWishlistByCustomer {}  ", customeruuid);
		List<Wishlist> response = wishlistService.getAllWishlistByCustomerUuid(customeruuid);
		logger.info("Wishlist get from DB is ",response);
		return ResponseEntity.ok(response);
	}  
	
}
